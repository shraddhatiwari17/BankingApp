package com.app.bank.BankingApp.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.BankingApp.dao.BankingOperationDao;
import com.app.bank.BankingApp.dto.CustomerDetailDTO;
import com.app.bank.BankingApp.dto.TransactionDetailsDTO;

@Service
public class BankingOperationServiceImpl implements BankingOperationService{
@Autowired
BankingOperationDao bankingOperationDao;
	
	@Override
	public CustomerDetailDTO getCustomerDetails(long accountNo) {
		
		return bankingOperationDao.getCustomerDetails(accountNo);
		
	}
	@Transactional
	@Override
	public String addCustomerDetails(CustomerDetailDTO customerDetailDTO) {
		String OututMessage="";
		long rowAffected=bankingOperationDao.addCustomerDetails(customerDetailDTO);
		
		if(rowAffected>0) {
			long accountNo=bankingOperationDao.getAccountNo();
		 OututMessage="Account successfully created, Account no. is: "+accountNo;
		}
		return OututMessage;
	}

	@Override
	public String updateCustomerDetail(long accountNo, String parameter, String value) {
		
		String msg="";
		int upatedRow=bankingOperationDao.updateCustomerDetail(accountNo, parameter, value);
		if (upatedRow>0) {
			msg=parameter+" for Account No. "+accountNo+" updated successfully";
		}
		return msg;
	}
	
	@Override
	public String addTransactionDetails(TransactionDetailsDTO transactionDetailsDTO) {
		
		String OututMessage="";
		if((null!=transactionDetailsDTO.getDebitedAmount()  && transactionDetailsDTO.getDebitedAmount().compareTo(BigDecimal.ZERO)==0)
				|| (null!=transactionDetailsDTO.getCreditedAmount	()  && transactionDetailsDTO.getCreditedAmount().compareTo(BigDecimal.ZERO)==0 )) {
		String isActive=bankingOperationDao.checkIsActive(transactionDetailsDTO.getAccountNo());
		if(isActive.equals("Y")) {
		BigDecimal existingBalance=bankingOperationDao.getTotalBalance(transactionDetailsDTO.getAccountNo());
		if(null!=transactionDetailsDTO.getDebitedAmount()  && existingBalance.compareTo(transactionDetailsDTO.getDebitedAmount()) !=-1) {
		
			if(null!=transactionDetailsDTO.getDebitedAmount()  && transactionDetailsDTO.getDebitedAmount().compareTo(BigDecimal.ZERO)!=0) {
				transactionDetailsDTO.setTotalBalance(existingBalance.subtract(transactionDetailsDTO.getDebitedAmount()));
			}
			if(null!=transactionDetailsDTO.getCreditedAmount()  && transactionDetailsDTO.getCreditedAmount().compareTo(BigDecimal.ZERO)!=0) {
				transactionDetailsDTO.setTotalBalance(existingBalance.add(transactionDetailsDTO.getCreditedAmount()));
			}
			
			long rowAffected=bankingOperationDao.addTransactionDetails(transactionDetailsDTO);
		if(rowAffected>0) {
		 OututMessage="Transaction was done successfully";
		}
		}else {
			OututMessage="Account does not have enough balance";
		}
		}else {
			OututMessage="Account "+transactionDetailsDTO.getAccountNo()+" is inactive";
		}
		}else {
			OututMessage="Please provide valid input";
		}
		return OututMessage;
	}
	@Override
	public String deleteCustomerDetail(long accountNo) {
		
		String OututMessage="";
		String isActive=bankingOperationDao.checkIsActive(accountNo);
		if(isActive.equals("Y")) {
		long rowAffected=bankingOperationDao.deleteCustomerDetail(accountNo);
		if(rowAffected>0) {
		 OututMessage="Account" +accountNo+ " is deactivated successfully";
		}
		}else {
			OututMessage="Account "+accountNo+" is already inactive";
		}
		return OututMessage;
	}

}
