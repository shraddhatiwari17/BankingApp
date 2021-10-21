package com.app.bank.BankingApp.constant;

public class BankingOperationQuery {

	public static final String GET_CUSTOMER_DETAILS="select c.account_no, c.account_holder_name, c.address, c.age, c.sex, c.email,"
			+"c.contact_no, c.is_active,c.debit_card_no  from customer_details c where c.account_no=?";
	
	
	public static final String GET_TRANSACTION_DETAILS="select transacton_id,debited_amount,credited_amount,total_balance "
			+ " from transaction_details where account_no=?";
	
	public static final String ADD_CUSTOMER_DETAILS="insert into customer_details (account_no,account_holder_name, address, age, sex, email,contact_no )"
			+ "values(account_no_sequence.nextval,?,?,?,?,?,?)";
	
	public static final String GET_ACCOUNT_NO="select Max(account_no) from customer_details";
	
	public static final String ADD_TRANSACTION_DETAILS="insert into transaction_details (transaction_id,debited_amount,credited_amount,total_balance,account_no)"
			+ "values(transaction_id_sequence.nextval,?,?,?,?)";
	
	public static final String CHECK_ACCOUNT_IS_ACTIVE="select is_active from customer_details c where c.account_no=?";
	
	public static final String GET_TOTAL_BALANCE="select total_balance from transaction_details c where c.account_no=? order by transaction_id DESC limit 1";
	
	public static final String GET_COUNT_TOTAL_BALANCE="select count(total_balance) from transaction_details c where c.account_no=?";
	
	public static final String UPDATE_CUSTOMER_DETAILS1= "update customer_details set ";
	
	public static final String UPDATE_CUSTOMER_DETAILS2= " where account_no=?";
	
	public static final String DELETE_CUSTOMER_DETAILS= "update  customer_details set is_active='N' where account_no=?";
	
	
}
