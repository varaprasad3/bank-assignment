package com.wissen.Bank_Assignment.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.wissen.Bank_Assignment.dto.AccountDto;
import com.wissen.Bank_Assignment.entities.Account;
import com.wissen.Bank_Assignment.entities.Bank;
import com.wissen.Bank_Assignment.mapper.AccountToAccountDtoMapper;
import com.wissen.Bank_Assignment.repository.AccountRepository;
import com.wissen.Bank_Assignment.repository.BankRepository;
import com.wissen.Bank_Assignment.util.PaymentInstruction;
import com.wissen.Bank_Assignment.util.Transaction;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BankRepository bankRepository;

	@Autowired
	private KafkaTemplate<String, List<PaymentInstruction>> kafkaTemplate;

	public ResponseEntity<Account> saveAccount(Account account) {
		Bank bank = bankRepository.findById(account.getBankId()).orElseThrow();

		List<Account> accounts = bank.getAccounts();
		if (accounts.size() > 0)
			accounts.add(account);
		else {
			List<Account> newAccounts = new ArrayList<Account>();
			newAccounts.add(account);

			bank.setAccounts(newAccounts);
		}

		Account savedAccount = accountRepository.save(account);
		bankRepository.save(bank);

		System.out.println("Good " + savedAccount.getAccountNumber());

		return new ResponseEntity<Account>(savedAccount, HttpStatus.CREATED);
	}

	public ResponseEntity<AccountDto> findAccountByAccountNumber(Long accountNumber) throws Exception {
		Account account = accountRepository.findByAccountNumber(accountNumber);

		if (account != null) {
			AccountDto fetchedAccountDto = new AccountToAccountDtoMapper().AccountToAccountDto(account,
					bankRepository.findById(account.getBankId()).orElseThrow());
			return new ResponseEntity<AccountDto>(fetchedAccountDto, HttpStatus.FOUND);
		}

		else {
			throw new Exception("account not found");
		}
	}

	public boolean checkAccountExistence(Long accountNumber) {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null)
			return true;
		return false;
	}

	public ResponseEntity<Transaction> findAccountNumber(@RequestBody Transaction transaction) throws Exception {
		if (checkAccountExistence(transaction.getDebitAccountNumber())
				&& checkAccountExistence(transaction.getCreditAccountNumber())) {
			Account debitAccount = accountRepository.findByAccountNumber(transaction.getDebitAccountNumber());
			Account creditAccount = accountRepository.findByAccountNumber(transaction.getCreditAccountNumber());

			if (transaction.getAmount() <= debitAccount.getBalance()) {
				debitAccount.setBalance(debitAccount.getBalance() - transaction.getAmount());
				creditAccount.setBalance(creditAccount.getBalance() + transaction.getAmount());

				accountRepository.save(debitAccount);
				accountRepository.save(creditAccount);

				List<PaymentInstruction> instructions = new ArrayList<PaymentInstruction>();

				PaymentInstruction debitInstruction = new PaymentInstruction();
				debitInstruction.setAccountNumber(transaction.getDebitAccountNumber());
				debitInstruction.setAmount(transaction.getAmount());
				debitInstruction.setCurrency("Inr");
				debitInstruction.setInstructionType("debit");

				PaymentInstruction creditInstruction = new PaymentInstruction();
				creditInstruction.setAccountNumber(transaction.getCreditAccountNumber());
				creditInstruction.setAmount(transaction.getAmount());
				creditInstruction.setCurrency("INR");
				creditInstruction.setInstructionType("credit");

				instructions.add(debitInstruction);
				instructions.add(creditInstruction);

				kafkaTemplate.send("instruction", instructions);

			}

			else {
				throw new Exception("balance not available");
			}

		} else {
			throw new Exception("account not found");
		}

		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
}
