package com.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kata.bank.model.Account;
import com.kata.bank.model.Statement;
import com.kata.bank.service.impl.AccountServiceImpl;

/**
 * The Class StatementTest.
 *  @author Mohamed BOUATIRA
 */
public class StatementTest {

	/** The account service impl. */
	private AccountServiceImpl accountServiceImpl;

	/** The account. */
	private Account account;

	/** The  EXPECTED_STATEMENT. */
	private static final String EXPECTED_STATEMENT =
			"-----------------------------------------------------------------------------------------------------------------------------------------\n"
			+" Operation           |                           Date                         |     Amount                         |    Balance         |\n"
			+"-----------------------------------------------------------------------------------------------------------------------------------------\n"
			+"   DEPOSIT           |                     2018-02-01                         |       +100                         |        100         |\n"
			+" WITHDRAWN           |                     2017-02-01                         |        -50                         |         50         |\n"
			+"-----------------------------------------------------------------------------------------------------------------------------------------\n";


	/**
	 * Inits the test.
	 */
	@Before
	public void init() {

		final String codeAccount = "FR12354566266275";
		account = new Account(LocalDate.now(), BigDecimal.ZERO, codeAccount);
		accountServiceImpl = new AccountServiceImpl();
	}

	/**
	 * Should print statement of 2 rows when i deposit 100 and i withdrawn 50.
	 */
	@Test
	public void should_print_statement_of_2_rows_when_i_deposit_100_and_i_withdrawn_50() {

		Statement statement = new Statement(account);

		final BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);
		final LocalDate dateOfDeposit = LocalDate.parse("2018-02-01");

		Account expectedAccount = accountServiceImpl.deposit(account, dateOfDeposit, moneyOfDeposit);

		Assert.assertNotNull(expectedAccount);
		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(100));
		Assert.assertEquals(expectedAccount.getStatementRecords().get(0).getOperation().getDateOfOperation(),
				dateOfDeposit);
	

		final BigDecimal moneyToWithdrawn = BigDecimal.valueOf(50);
		final LocalDate dateOfWithdrawn = LocalDate.parse("2017-02-01");

		expectedAccount = accountServiceImpl.withdrawn(account, dateOfWithdrawn, moneyToWithdrawn);

		Assert.assertNotNull(expectedAccount);
		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(50));
		Assert.assertEquals(expectedAccount.getStatementRecords().get(1).getOperation().getDateOfOperation(),
				dateOfWithdrawn);

		Assert.assertEquals(EXPECTED_STATEMENT, statement.printStatement());
	}
}
