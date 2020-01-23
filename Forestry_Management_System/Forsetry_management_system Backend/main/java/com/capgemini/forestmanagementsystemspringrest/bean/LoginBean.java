package com.capgemini.forestmanagementsystemspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="login")
public class LoginBean {
	@Id
	@Column
	@GeneratedValue
	int id;
	@Column
	String email;
	@Column
	String password;
	@Column
	String role;

}
