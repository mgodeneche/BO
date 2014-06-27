package com.epsi.tpecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false, length=250)
	private String name;

	@Column(name="surname", nullable=false, length=250)
	private String surname;
	
	@Column(name="login", nullable=false, unique=true)
	private String login;
	
	@Column(name="password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
