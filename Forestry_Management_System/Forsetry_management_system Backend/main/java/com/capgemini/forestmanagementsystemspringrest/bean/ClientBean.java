package com.capgemini.forestmanagementsystemspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="clients")
public class ClientBean {
	@Id
	@Column
	@GeneratedValue
	int clientId;
	@Column
	String clientName;
	@Column
	String streetAddress1;
	@Column
	String streetAddress2;
	@Column
	String town;
	@Column
	long postalCode;
	@Column(unique=true,nullable=false)
	String email;
	@Column
	long telephone;
	@Column(nullable=false)
	String password;
	
	
}