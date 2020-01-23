package com.capgemini.forestmanagementsystemspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrderBean {
	@Id
	@Column
	@GeneratedValue
	private int orderNo;
	@Column
	private String email;
	@Column
	private int productId;
	@Column
	private int quantity;
	@Column
	private String Status= "Order Placed";
	@Column
	private String expectedDeliveryDate= "Not yet Shipped";
	

}
