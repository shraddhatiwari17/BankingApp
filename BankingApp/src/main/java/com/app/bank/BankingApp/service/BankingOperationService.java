package com.app.bank.BankingApp.service;

import com.app.bank.BankingApp.dto.CustomerDetailDTO;
import com.app.bank.BankingApp.dto.TransactionDetailsDTO;

public interface BankingOperationService {

public CustomerDetailDTO getCustomerDetails(long accountNo);
	
	public String addCustomerDetails(CustomerDetailDTO customerDetailDTO);
	
	public String updateCustomerDetail(long accountNo,String parameter,String value);
	
	public String deleteCustomerDetail(long accountNo);

	String addTransactionDetails(TransactionDetailsDTO transactionDetailsDTO);
}
