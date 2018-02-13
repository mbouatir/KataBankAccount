package com.kata.bank.model.account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kata.bank.model.statement.StatementRecord;

/**
 * The Class Account that represents the account bank.
 * 
 * @author Mohamed BOUATIRA
 * 
 */
public class Account {

	/** The date creation. */
	private LocalDate dateCreation;

	/** The balance of account. */
	private BigDecimal balance;

	/** The code account. */
	private String codeAccount;

	/** The statement records. */
	private List<StatementRecord> statementRecords = new ArrayList<StatementRecord>();

	/**
	 * Instantiates a new account.
	 *
	 * @param dateCreation
	 *            the date creation
	 * @param balanceOfAccount
	 *            the balance of account
	 * @param codeAccount
	 *            the code account
	 */
	public Account(String codeAccount, LocalDate dateCreation, BigDecimal balanceOfAccount) {
		super();
		this.dateCreation = dateCreation;
		this.balance = balanceOfAccount;
		this.codeAccount = codeAccount;
	}

	/**
	 * Gets the date creation.
	 *
	 * @return the date creation
	 */
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * Sets the date creation.
	 *
	 * @param dateCreation
	 *            the new date creation
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Gets the balance of account.
	 *
	 * @return the balance of account
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of account.
	 *
	 * @param balanceOfAccount
	 *            the new balance of account
	 */
	public void setBalance(BigDecimal balanceOfAccount) {
		this.balance = balanceOfAccount;
	}

	/**
	 * Gets the code account.
	 *
	 * @return the code account
	 */
	public String getCodeAccount() {
		return codeAccount;
	}

	/**
	 * Sets the code account.
	 *
	 * @param codeAccount
	 *            the new code account
	 */
	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}

	/**
	 * Gets the statement records.
	 *
	 * @return the statement records
	 */
	public List<StatementRecord> getStatementRecords() {
		return statementRecords;
	}

	/**
	 * Sets the statement records.
	 *
	 * @param statementRecords
	 *            the new statement records
	 */
	public void setStatementRecords(List<StatementRecord> statementRecords) {
		this.statementRecords = statementRecords;
	}

}
