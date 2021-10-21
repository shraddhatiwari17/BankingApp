package com.app.bank.BankingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.BankingApp.dto.CustomerDetailDTO;
import com.app.bank.BankingApp.dto.TransactionDetailsDTO;
import com.app.bank.BankingApp.service.BankingOperationService;

@RestController
@RequestMapping("/BankingApp")
public class BankingOperationController {
	
@Autowired
BankingOperationService bankingOperationService;

@GetMapping("/getCustomerDetails")
public CustomerDetailDTO getCustomerDetails(@RequestParam long accountNo) {
	
	
	return bankingOperationService.getCustomerDetails(accountNo);
	
}
@PostMapping("/addCustomerDetail")
public String addCustomerDetail(@RequestBody CustomerDetailDTO customerDetailDTO) {
	String OututMessage=bankingOperationService.addCustomerDetails(customerDetailDTO);

	
	return OututMessage;
	
}

@PostMapping("/updateCustomerDetail")
public String updateCustomerDetail(@RequestParam long accountNo, String parameter, String value) {
	
	String OututMessage=bankingOperationService.updateCustomerDetail(accountNo,parameter,value);
	
	return OututMessage;
	
}

@PostMapping("/addTransactionDetails")
public String addTransactionDetails(@RequestBody TransactionDetailsDTO transactionDetailsDTO) {
	
	String OututMessage=bankingOperationService.addTransactionDetails(transactionDetailsDTO);
	
	return OututMessage;
	
}

@PostMapping("/deleteCustomerDetail")
public String deleteCustomerDetail(@RequestParam long accountNo) {
	
	String OututMessage=bankingOperationService.deleteCustomerDetail(accountNo);
	
	return OututMessage;
	
}

}
