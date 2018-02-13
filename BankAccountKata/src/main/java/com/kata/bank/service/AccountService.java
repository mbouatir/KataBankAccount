package com.kata.bank.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kata.bank.model.account.Account;

 
/**
 * The Interface AccountService.
 *  @author Mohamed BOUATIRA
 */
public interface AccountService {

	
	/**
	 * Deposit in the account bank.
	 *
	 * @param account the account
	 * @param dateOfOperation the date of operation
	 * @param moneyOfDeposit the money of deposit
	 * @return the account
	 */
	public Account deposit(Account account, LocalDate dateOfOperation, BigDecimal moneyOfDeposit);
	
	/**
	 * Withdrawn from the account bank.
	 *
	 * @param account the account
	 * @param dateOfOperation the date of operation
	 * @param moneyToWithdrawn the money to withdrawn
	 * @return the account
	 */
	public Account withdrawn(Account account, LocalDate dateOfOperation, BigDecimal moneyToWithdrawn);
	
	
}
