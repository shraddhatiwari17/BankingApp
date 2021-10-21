package com.app.bank.BankingApp.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.bank.BankingApp.constant.BankingOperationQuery;
import com.app.bank.BankingApp.dto.CustomerDetailDTO;
import com.app.bank.BankingApp.dto.TransactionDetailsDTO;
@Repository
public class BankingOperationDaoImpl implements BankingOperationDao{

	private static final Logger log = LoggerFactory.getLogger(BankingOperationDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public CustomerDetailDTO getCustomerDetails(long accountNo) {
		try {
			return jdbcTemplate.queryForObject(BankingOperationQuery.GET_CUSTOMER_DETAILS,new Object[] {accountNo}, new RowMapper<CustomerDetailDTO>(){

				@Override
				public CustomerDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					CustomerDetailDTO customerDetailDTO=new CustomerDetailDTO();
					if(rs!=null) {
						customerDetailDTO.setAccountHolderName(rs.getString("account_holder_name"));
						customerDetailDTO.setAccountNo(rs.getInt("account_no"));
						customerDetailDTO.setAddress(rs.getString("address"));
						customerDetailDTO.setAge(rs.getInt("age"));
						customerDetailDTO.setContactNo(rs.getLong("contact_no"));
						customerDetailDTO.setEmail(rs.getString("email"));
						customerDetailDTO.setSex(rs.getString("sex"));
						customerDetailDTO.setIsActive(rs.getString("is_active"));
						customerDetailDTO.setDebitCardNo(rs.getLong("debit_card_no"));
					}
					return customerDetailDTO;
				}
			});
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return new CustomerDetailDTO();
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return null;
		}

	}

	@Override
	public long addCustomerDetails(CustomerDetailDTO customerDetailDTO) {
		try {
			return jdbcTemplate.update(BankingOperationQuery.ADD_CUSTOMER_DETAILS,customerDetailDTO.getAccountHolderName(),customerDetailDTO.getAddress(),
					customerDetailDTO.getAge(),customerDetailDTO.getSex(),customerDetailDTO.getEmail(),customerDetailDTO.getContactNo());
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return 0;
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return 0;
		}

	}

	@Override
	public long getAccountNo() {
		try {
			return jdbcTemplate.queryForObject(BankingOperationQuery.GET_ACCOUNT_NO,Long.class);
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return 0;
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return 0;
		}

	}

	@Override
	public int updateCustomerDetail(long accountNo, String parameter, String value) {
		try {
			return jdbcTemplate.update(BankingOperationQuery.UPDATE_CUSTOMER_DETAILS1+parameter+"='"+value+" ' "+BankingOperationQuery.UPDATE_CUSTOMER_DETAILS2,accountNo);
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return 0;
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return 0;
		}
	}

	@Override
	public long addTransactionDetails(TransactionDetailsDTO transactionDetailsDTO) {
		try {
			return jdbcTemplate.update(BankingOperationQuery.ADD_TRANSACTION_DETAILS,transactionDetailsDTO.getDebitedAmount(),transactionDetailsDTO.getCreditedAmount(),
					transactionDetailsDTO.getTotalBalance(),transactionDetailsDTO.getAccountNo());
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return 0;
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return 0;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public String checkIsActive(long accountNo) {
		try {
			return jdbcTemplate.queryForObject(BankingOperationQuery.CHECK_ACCOUNT_IS_ACTIVE,new Object[] {accountNo},String.class);
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return "N";
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return "N";
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BigDecimal getTotalBalance(long accountNo) {
		try {
			int count=jdbcTemplate.queryForObject(BankingOperationQuery.GET_COUNT_TOTAL_BALANCE,new Object[] {accountNo},Integer.class);
			if(count>0) {
				return jdbcTemplate.queryForObject(BankingOperationQuery.GET_TOTAL_BALANCE,new Object[] {accountNo},BigDecimal.class);
			}else {
				return BigDecimal.ZERO;
			}
		}catch(Exception e) {
			System.out.println(e);
			return BigDecimal.ZERO;
		}

	}

	@Override
	public int deleteCustomerDetail(long accountNo) {
		try {
			return jdbcTemplate.update(BankingOperationQuery.DELETE_CUSTOMER_DETAILS,accountNo);
		}catch(EmptyResultDataAccessException e) {
			log.info("no record found"+e);
			return 0;
		}catch(Exception e) {
			log.info("Exception occurred"+e);
			return 0;
		}
	}



}
