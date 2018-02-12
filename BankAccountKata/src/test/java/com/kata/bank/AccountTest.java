package com.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kata.bank.model.Account;
import com.kata.bank.service.impl.AccountServiceImpl;

/**
 * The Class AccountTest.
 *  @author Mohamed BOUATIRA
 */
public class AccountTest {

	/** The account service impl. */
	private AccountServiceImpl accountServiceImpl;

	/** The account. */
	private Account account;

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
	 * Should return 100 when i deposit 100 today.
	 */
	@Test
	public void should_return_100_when_i_deposit_100_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);

		Account expectedAccount = accountServiceImpl.deposit(account, LocalDate.now(), moneyOfDeposit);

		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(100));

	}

	/**
	 * Should return 200 when i deposit 100 and the initial balance is 100 today.
	 */
	@Test
	public void should_return_200_when_i_deposit_100_and_the_initial_balance_is_100_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);
		BigDecimal initialBalance = BigDecimal.valueOf(100);
		account.setBalanceOfAccount(initialBalance);

		Account expectedAccount = accountServiceImpl.deposit(account, LocalDate.now(), moneyOfDeposit);
		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(200));

	}

	/**
	 * Should return minus 200 when i withdrawn 200 today.
	 */
	@Test
	public void should_return_minus_200_when_i_withdrawn_200_today() {

		BigDecimal moneyToWithdrawn = BigDecimal.valueOf(200);

		Account expectedAccount = accountServiceImpl.withdrawn(account, LocalDate.now(), moneyToWithdrawn);
		Assert.assertNotNull(expectedAccount);
		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(-200));

	}

	/**
	 * Should return 50 when i deposit 100 and withdrawn 50 today.
	 */
	@Test
	public void should_return_50_when_i_deposit_100_and_withdrawn_50_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);
		BigDecimal moneyToWithdrawn = BigDecimal.valueOf(50);

		Account expectedAccount = accountServiceImpl.deposit(account, LocalDate.now(), moneyOfDeposit);
		Assert.assertNotNull(expectedAccount);

		expectedAccount = accountServiceImpl.withdrawn(account, LocalDate.now(), moneyToWithdrawn);
		Assert.assertEquals(expectedAccount.getBalanceOfAccount(), BigDecimal.valueOf(50));

	}
}
