package com.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountnumber;
	private String accholdersname;
	private String email;
	private String contact;
	private String password;
	private String address;
	private double accountbalance;
	

	
	public BankAccounts()
	{
		
	}
	

	public BankAccounts(int accountnumber, String accholdersname, String email, String contact, String password,
			String address, double accountbalance) {
		super();
		this.accountnumber = accountnumber;
		this.accholdersname = accholdersname;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.address = address;
		this.accountbalance = accountbalance;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAccholdersname() {
		return accholdersname;
	}
	public void setAccholdersname(String accholdersname) {
		this.accholdersname = accholdersname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	

	
}
