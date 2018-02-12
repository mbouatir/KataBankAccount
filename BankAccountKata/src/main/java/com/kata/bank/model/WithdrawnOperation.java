package com.kata.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

 
/**
 * The Class Withdrawn Operation.
 *  @author Mohamed BOUATIRA
 */
public class WithdrawnOperation extends Operation {

	/**
	 * Instantiates a new withdrawn operation.
	 *
	 * @param amountOfMoney the amount of money
	 * @param typeOperation the type operation
	 * @param dateOfOperation the date of operation
	 */
	public WithdrawnOperation(BigDecimal amountOfMoney, TypeOperation typeOperation, LocalDate dateOfOperation) {
		super(amountOfMoney, typeOperation, dateOfOperation);

	}

}
