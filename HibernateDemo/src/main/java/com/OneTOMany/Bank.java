package com.OneTOMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Accounts> accounts;
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
	public List<Accounts> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
	public Bank(int id, String name, List<Accounts> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}
	public Bank() {
		super();
	}
	
}
