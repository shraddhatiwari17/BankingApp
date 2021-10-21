package com.app.bank.BankingApp.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.app.bank.BankingApp.dto.CustomerDetailDTO;
import com.app.bank.BankingApp.dto.TransactionDetailsDTO;

public interface BankingOperationDao {

	public CustomerDetailDTO getCustomerDetails(long accountNo);
	
	public long addCustomerDetails(CustomerDetailDTO customerDetailDTO);
	
	public int updateCustomerDetail(long accountNo,String parameter,String value);
	
	public int deleteCustomerDetail(long accountNo);

	long addTransactionDetails(TransactionDetailsDTO transactionDetailsDTO);

	String checkIsActive(long accountId);

	BigDecimal getTotalBalance(long accountNo);

	long getAccountNo();
}
