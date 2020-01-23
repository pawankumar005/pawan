package com.capgemini.forestmanagementsystemspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	private int productId;
	@Column
	private String productName;
	@Column
	private int quantity;
	@Column
	private String url;
	
	


}
