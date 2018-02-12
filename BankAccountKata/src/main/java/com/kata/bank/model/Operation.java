package com.kata.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Class Operation represents the operation occurred in the bank account.
 * @author Mohamed BOUATIRA
 */
public class Operation {

	/** The amount of money. */
	private BigDecimal amountOfMoney;

	/** The type operation. */
	private TypeOperation typeOperation;

	/** The date of operation. */
	private LocalDate dateOfOperation;

	/**
	 * Instantiates a new operation.
	 *
	 * @param amountOfMoney
	 *            the amount of money
	 * @param typeOperation
	 *            the type operation
	 * @param dateOfOperation
	 *            the date of operation
	 */
	public Operation(BigDecimal amountOfMoney, TypeOperation typeOperation, LocalDate dateOfOperation) {
		super();
		this.amountOfMoney = amountOfMoney;
		this.typeOperation = typeOperation;
		this.dateOfOperation = dateOfOperation;
	}

	/**
	 * Gets the amount of money.
	 *
	 * @return the amount of money
	 */
	public BigDecimal getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Sets the amount of money.
	 *
	 * @param amountOfMoney
	 *            the new amount of money
	 */
	public void setAmountOfMoney(BigDecimal amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	/**
	 * Gets the type operation.
	 *
	 * @return the type operation
	 */
	public TypeOperation getTypeOperation() {
		return typeOperation;
	}

	/**
	 * Sets the type operation.
	 *
	 * @param typeOperation
	 *            the new type operation
	 */
	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	/**
	 * Gets the date of operation.
	 *
	 * @return the date of operation
	 */
	public LocalDate getDateOfOperation() {
		return dateOfOperation;
	}

	/**
	 * Sets the date of operation.
	 *
	 * @param dateOfOperation
	 *            the new date of operation
	 */
	public void setDateOfOperation(LocalDate dateOfOperation) {
		this.dateOfOperation = dateOfOperation;
	}

}
