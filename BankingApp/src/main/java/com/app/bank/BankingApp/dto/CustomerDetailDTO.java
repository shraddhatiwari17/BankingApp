package com.app.bank.BankingApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailDTO {

	private long accountNo;
	private String accountHolderName;
	private int age;
	private String address;
	private String sex;
	private String email;
	private long contactNo;
	private long debitCardNo;
	private String isActive;
	private List<TransactionDetailsDTO> transactionDetailsDTO;
	
	
	
	public long getDebitCardNo() {
		return debitCardNo;
	}
	public void setDebitCardNo(long debitCardNo) {
		this.debitCardNo = debitCardNo;
	}
	public List<TransactionDetailsDTO> getTransactionDetailsDTO() {
		return transactionDetailsDTO;
	}
	public void setTransactionDetailsDTO(List<TransactionDetailsDTO> transactionDetailsDTO) {
		this.transactionDetailsDTO = transactionDetailsDTO;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
