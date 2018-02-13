package com.kata.bank.account;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kata.bank.exception.BankAccountException;
import com.kata.bank.model.account.Account;
import com.kata.bank.service.AccountService;
import com.kata.bank.service.impl.AccountServiceImpl;

 
/**
 * The Class AccountTest.
 * 
 * @author Mohamed BOUATIRA
 */
public class AccountTest {

	/** The account service. */
	private AccountService accountService;

	/** The account. */
	private Account account;

	/**
	 * Inits the test.
	 */
	@Before
	public void init() {

		final String codeAccount = "FR12354566266275";
		account = new Account(codeAccount, LocalDate.now(), BigDecimal.ZERO);
		accountService=new AccountServiceImpl();
	}

	/**
	 * Should return 100 when i deposit 100 today.
	 */
	@Test
	public void should_return_100_when_i_deposit_100_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);

		Account expectedAccount = accountService.deposit(account, LocalDate.now(), moneyOfDeposit);

		Assert.assertEquals(expectedAccount.getBalance(), BigDecimal.valueOf(100));

	}

	/**
	 * Should return 200 when i deposit 100 and the initial balance is 100 today.
	 */
	@Test
	public void should_return_200_when_i_deposit_100_and_the_initial_balance_is_100_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);
		BigDecimal initialBalance = BigDecimal.valueOf(100);
		account.setBalance(initialBalance);

		Account expectedAccount = accountService.deposit(account, LocalDate.now(), moneyOfDeposit);
		Assert.assertEquals(expectedAccount.getBalance(), BigDecimal.valueOf(200));

	}

	/**
	 * Should return minus 200 when i withdrawn 200 today.
	 */
	@Test
	public void should_return_minus_200_when_i_withdrawn_200_today() {

		BigDecimal moneyToWithdrawn = BigDecimal.valueOf(200);

		Account expectedAccount = accountService.withdrawn(account, LocalDate.now(), moneyToWithdrawn);
		Assert.assertNotNull(expectedAccount);
		Assert.assertEquals(expectedAccount.getBalance(), BigDecimal.valueOf(-200));

	}

	/**
	 * Should return 50 when i deposit 100 and withdrawn 50 today.
	 */
	@Test
	public void should_return_50_when_i_deposit_100_and_withdrawn_50_today() {

		BigDecimal moneyOfDeposit = BigDecimal.valueOf(100);
		BigDecimal moneyToWithdrawn = BigDecimal.valueOf(50);

		Account expectedAccount = accountService.deposit(account, LocalDate.now(), moneyOfDeposit);
		Assert.assertNotNull(expectedAccount);

		expectedAccount = accountService.withdrawn(account, LocalDate.now(), moneyToWithdrawn);
		Assert.assertEquals(expectedAccount.getBalance(), BigDecimal.valueOf(50));

	}

	/**
	 * Should return exception when i withdrawn 500 and the limit of withdrawn is 400 per day today.
	 */
	@Test(expected = BankAccountException.class)
	public void should_return_exception_when_i_withdrawn_500_and_the_limit_of_withdrawn_is_400_per_day_today() {

		BigDecimal moneyToWithdrawn = BigDecimal.valueOf(500);

		Account expectedAccount = accountService.withdrawn(account, LocalDate.now(), moneyToWithdrawn);
		Assert.assertNotNull(expectedAccount);

	}
}
