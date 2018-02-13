package com.kata.bank.model.statement;

import java.util.List;

import com.kata.bank.model.account.Account;

/**
 * The Class Statement represents the statement bank.
 * 
 * @author Mohamed BOUATIRA
 */
public class Statement {

	/** The Constant LINE. */
	private static final String LINE = "-----------------------------------------------------------------------------------------------------------------------------------------\n";

	/** The Constant STATEMENT_HEADER. */
	private static final String STATEMENT_HEADER = String.format("%10s  %10s %30s %25s %10s %25s %10s %10s","Operation", "|", "Date", "|", "Amount",
			"|", "Balance", "|\n") + LINE;

	/** The Constant STATEMENT_FOOTER. */
	private static final String STATEMENT_FOOTER = "-----------------------------------------------------------------------------------------------------------------------------------------\n";

	/** The account. */
	private Account account;

	/**
	 * Instantiates a new statement.
	 *
	 * @param account
	 *            the account
	 */
	public Statement(Account account) {
		super();
		this.account = account;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account
	 *            the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Prints the statement.
	 *
	 * @return the string
	 */
	public String printStatement() {

		StringBuilder stringBuilder = new StringBuilder();

		List<StatementRecord> statementRecords = this.account.getStatementRecords();

		stringBuilder.append(LINE);
		stringBuilder.append(STATEMENT_HEADER);

		if (!statementRecords.isEmpty()) {
			for (StatementRecord statementRecord : statementRecords) {
				statementRecord.printStatementRecord(stringBuilder);
			}
		}
		stringBuilder.append(STATEMENT_FOOTER);

		return stringBuilder.toString();

	}
}
