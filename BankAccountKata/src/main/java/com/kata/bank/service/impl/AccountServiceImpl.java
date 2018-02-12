package com.kata.bank.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kata.bank.model.Account;
import com.kata.bank.model.DepositOperation;
import com.kata.bank.model.StatementRecord;
import com.kata.bank.model.TypeOperation;
import com.kata.bank.model.WithdrawnOperation;
import com.kata.bank.service.AccountService;

 
/**
 * The Class AccountServiceImpl .
 *  @author Mohamed BOUATIRA
 */
public class AccountServiceImpl implements AccountService {

	/*  
	 * @see com.kata.bank.service.AccountService#deposit(com.kata.bank.model.Account, java.time.LocalDate, java.math.BigDecimal)
	 */
	public Account deposit(Account account, LocalDate dateOfOperation, BigDecimal moneyOfDeposit) {

		DepositOperation depositOperation = new DepositOperation(moneyOfDeposit, TypeOperation.DEPOSIT,
				dateOfOperation);

		BigDecimal actualBalance = account.getBalanceOfAccount().add(moneyOfDeposit);
		account.setBalanceOfAccount(actualBalance);

		StatementRecord statementRecord = new StatementRecord(depositOperation, actualBalance);

		account.getStatementRecords().add(statementRecord);

		return account;
	}

	/* 
	 * @see com.kata.bank.service.AccountService#withdrawn(com.kata.bank.model.Account, java.time.LocalDate, java.math.BigDecimal)
	 */
	public Account withdrawn(Account account, LocalDate dateOfOperation, BigDecimal moneyToWithdrawn) {

		WithdrawnOperation withdrawnOperation = new WithdrawnOperation(moneyToWithdrawn, TypeOperation.WITHDRAWN,
				dateOfOperation);

		BigDecimal actualBalance = account.getBalanceOfAccount().subtract(moneyToWithdrawn);
		account.setBalanceOfAccount(actualBalance);

		StatementRecord statementRecord = new StatementRecord(withdrawnOperation, actualBalance);

		account.getStatementRecords().add(statementRecord);

		return account;
	}

}