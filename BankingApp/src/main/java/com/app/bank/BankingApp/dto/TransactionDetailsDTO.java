package com.app.bank.BankingApp.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetailsDTO {

	private long transactionId;
	private long accountNo;
	private BigDecimal debitedAmount;
	private BigDecimal creditedAmount;
	private BigDecimal totalBalance;
	
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getDebitCardNo() {
		return accountNo;
	}
	public void setDebitCardNo(long debitCardNo) {
		this.accountNo = debitCardNo;
	}
	public BigDecimal getDebitedAmount() {
		return debitedAmount;
	}
	public void setDebitedAmount(BigDecimal debitedAmount) {
		this.debitedAmount = debitedAmount;
	}
	public BigDecimal getCreditedAmount() {
		return creditedAmount;
	}
	public void setCreditedAmount(BigDecimal creditedAmount) {
		this.creditedAmount = creditedAmount;
	}
	public BigDecimal getTotalBalance() {
		if(this.totalBalance==null) {
			return BigDecimal.ZERO;
		}
		return totalBalance;
	}
	public void setTotalBalance(BigDecimal totalBalance) {
		if(totalBalance!=null) {
			this.totalBalance = totalBalance;
		}else
		{
			this.totalBalance=BigDecimal.ZERO;	
		}
	}
	
	
}
