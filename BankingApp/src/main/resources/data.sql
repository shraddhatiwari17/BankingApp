
CREATE TABLE Customer_details(
  account_no BIGINT primary key,
  account_holder_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  sex VARCHAR(10) NOT NULL,
  email VARCHAR(50),
  contact_no BIGINT  NOT NULL,
  is_active VARCHAR(20) NOT NULL DEFAULT 'Y',
  debit_card_no BIGINT AUTO_INCREMENT
);


CREATE TABLE Transaction_details	 (
  transaction_id BIGINT primary key,
  account_no BIGINT NOT NULL,
  debited_amount DOUBLE NOT NULL DEFAULT 0,
  credited_amount DOUBLE NOT NULL DEFAULT 0,
  total_balance DOUBLE NOT NULL DEFAULT 0
);

  CREATE SEQUENCE account_no_sequence
  START WITH 100000
  INCREMENT BY 1;
  
  CREATE SEQUENCE debit_card_no_sequence
  START WITH 100000
  INCREMENT BY 1;
  
  CREATE SEQUENCE transaction_id_sequence
  START WITH 1
  INCREMENT BY 1;
  