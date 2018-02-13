package com.kata.bank.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kata.bank.exception.BankAccountException;
import com.kata.bank.model.account.Account;
import com.kata.bank.model.operation.DepositOperation;
import com.kata.bank.model.operation.TypeOperation;
import com.kata.bank.model.operation.WithdrawnOperation;
import com.kata.bank.model.statement.StatementRecord;
import com.kata.bank.service.AccountService;

/**
 * The Class AccountServiceImpl .
 * 
 * @author Mohamed BOUATIRA
 */
public class AccountServiceImpl implements AccountService {

	private static final BigDecimal LIMIT_OF_WITHDRAWN = BigDecimal.valueOf(400);

	/*
	 * @see
	 * com.kata.bank.service.AccountService#deposit(com.kata.bank.model.Account,
	 * java.time.LocalDate, java.math.BigDecimal)
	 */
	public Account deposit(Account account, LocalDate dateOfOperation, BigDecimal moneyOfDeposit) {

		DepositOperation depositOperation = new DepositOperation(moneyOfDeposit, dateOfOperation);

		BigDecimal actualBalance = account.getBalance().add(moneyOfDeposit);
		account.setBalance(actualBalance);

		StatementRecord statementRecord = new StatementRecord(depositOperation, actualBalance);

		account.getStatementRecords().add(statementRecord);

		return account;
	}

	/*
	 * @see
	 * com.kata.bank.service.AccountService#withdrawn(com.kata.bank.model.Account,
	 * java.time.LocalDate, java.math.BigDecimal)
	 */
	public Account withdrawn(Account account, LocalDate dateOfOperation, BigDecimal moneyToWithdrawn) {

		WithdrawnOperation withdrawnOperation = new WithdrawnOperation(moneyToWithdrawn, dateOfOperation);

		if (moneyToWithdrawn.compareTo(LIMIT_OF_WITHDRAWN) > 0)
			throw new BankAccountException("The amount is not allowed – it is beyond the authorized limit of "
					+ LIMIT_OF_WITHDRAWN.toString());

		BigDecimal actualBalance = account.getBalance().subtract(moneyToWithdrawn);
		account.setBalance(actualBalance);

		StatementRecord statementRecord = new StatementRecord(withdrawnOperation, actualBalance);

		account.getStatementRecords().add(statementRecord);

		return account;
	}

}
