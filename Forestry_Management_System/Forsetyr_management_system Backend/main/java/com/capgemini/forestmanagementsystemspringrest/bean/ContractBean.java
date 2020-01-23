package com.capgemini.forestmanagementsystemspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="contracts")
public class ContractBean {
	@Id
	@Column
	@GeneratedValue
	int contractNo;
	@Column
	String email;
	@Column
	int productId;
	
	@Column
	String deliveryDate;
	@Column
	int quantity;
	@Column
	int orderNo;
	@Column
	String status;


}
