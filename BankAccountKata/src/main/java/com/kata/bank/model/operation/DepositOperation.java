package com.kata.bank.model.operation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DepositOperation extends Operation {

	/**
	 * Instantiates a new deposit operation.
	 *
	 * @param amountOfMoney
	 *            the amount of money
	 * @param typeOperation
	 *            the type operation
	 * @param dateOfOperation
	 *            the date of operation
	 */
	public DepositOperation(BigDecimal amountOfMoney, LocalDate dateOfOperation) {
		super(amountOfMoney, TypeOperation.DEPOSIT, dateOfOperation);

	}

}
