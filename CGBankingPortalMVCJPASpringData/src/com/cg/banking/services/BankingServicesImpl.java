package com.cg.banking.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

@Component("bankingServices")
public class BankingServicesImpl implements  BankingServices{
	@Autowired
	private AccountDAO service;
	private	Transaction transaction ;
	Account account;
	
	static int  pinNumber=(int)((int)1000*Math.random());
	public int getPinNumber()
	{
		return ++pinNumber;
		
	}
	
	@Override
	public Account openAccount(Account account)
	{
		//throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		//Account account = new Account(accountType,initBalance);
		account.setPinNumber(pinNumber);
		account.setAccountStatus("Active");
		account = service.save(account);
		return account; 
	}

		@Override
		public List<Account> getAllAccountDetails() throws BankingServicesDownException {
			return service.findAll();
		}
		@Override
		public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
			account=service.findById((int) accountNo).orElseThrow
					(()->new AccountNotFoundException("Account  not found associate Id"+accountNo));
			if(account==null)
				throw new AccountNotFoundException();
			return account;
		}
		@Override
		public float depositAmount(long accountNo, float amount)
				throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
			Account account=service.findById((int) accountNo).orElseThrow
					(()->new AccountNotFoundException("Account  not found associate Id"+accountNo));
			float finalAmount = account.getAccountBalance()+amount;
			account.setAccountBalance(finalAmount);
			return finalAmount;
		}
		@Override
		public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
		AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
			Account account = service.findById((int) accountNo).orElseThrow
					(()->new AccountNotFoundException("Account  not found associate Id"+accountNo));
			if(pinNumber==account.getPinNumber())
			{account=service.findById((int) accountNo).orElseThrow
					(()->new AccountNotFoundException("Account  not found associate Id"+accountNo));;
			float finalAmount = account.getAccountBalance()-amount;
			account.setAccountBalance(finalAmount);
			return finalAmount;}
			else
				throw new InvalidPinNumberException();
		}
		@Override
		public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
				throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
				BankingServicesDownException, AccountBlockedException {
			withdrawAmount(accountNoFrom, transferAmount, pinNumber);
			depositAmount(accountNoTo, transferAmount);
			return true;
		}
		@Override
		public List<Transaction> getAccountAllTransaction(long accountNo)
				throws BankingServicesDownException, AccountNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String accountStatus(long accountNo)
				throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
			// TODO Auto-generated method stub
			return null;
		}
}