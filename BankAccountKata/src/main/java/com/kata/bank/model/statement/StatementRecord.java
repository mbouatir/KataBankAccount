package com.kata.bank.model.statement;

import java.math.BigDecimal;

import com.kata.bank.model.operation.Operation;
import com.kata.bank.model.operation.TypeOperation;

/**
 * The Class StatementRecord represents the statement record.
 *  @author Mohamed BOUATIRA
 */
public class StatementRecord {

	/** The operation. */
	private Operation operation;

	/** The balance. */
	private BigDecimal balance;

	/**
	 * Instantiates a new statement record.
	 *
	 * @param operation
	 *            the operation
	 * @param balance
	 *            the balance
	 */
	public StatementRecord(Operation operation, BigDecimal balance) {
		super();
		this.operation = operation;
		this.balance = balance;
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation
	 *            the new operation
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance
	 *            the new balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * Prints the statement record.
	 *
	 * @param stringBuilder
	 *            the string builder
	 * @return the string builder
	 */
	public StringBuilder printStatementRecord(StringBuilder stringBuilder) {

		String dateOperation = operation.getDateOfOperation().toString();
		TypeOperation typeOperation = operation.getTypeOperation();
		String amount = operation.getAmountOfMoney().toString();

		StringBuilder amountBuilder = new StringBuilder();
		amountBuilder = (TypeOperation.DEPOSIT.equals(typeOperation)) ? amountBuilder.append("+").append(amount)
				: amountBuilder.append("-").append(amount);

		stringBuilder.append(String.format("%10s  %10s %30s %25s %10s %25s %10s %10s",typeOperation.toString(), "|", dateOperation, "|",
				amountBuilder.toString(), "|", balance, "|\n"));

		return stringBuilder;
	}

}
