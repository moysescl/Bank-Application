package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int id;
	String fn;
	String ln;
	String email;
	String phone;
	//cheking account
	Account ca;
	ArrayList<Account> acList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Account getCa() {
		return ca;
	}
	public void setCa(Account ca) {
		this.ca = ca;
	
	}
	public ArrayList<Account> getAcList() {
		return acList;
	}
	
	public void setAcList(ArrayList<Account> acList) {
		this.acList = acList;
	}
	public Customer(int id, String fn, String ln, String email, String phone, Account ca,
			ArrayList<Account> acList) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.phone = phone;
		this.ca = ca;
		this.acList = acList;
		this.acList.add(ca);
	}
	public Customer() {
		super();
		this.id = 0;
		this.fn = " ";
		this.ln = " ";
		this.email = " ";
		this.phone = " ";
		this.ca = new Checking();
		this.acList = new ArrayList<Account>();
		this.acList.add(ca);
	}
	@Override
	public String toString() {
		return "\n\tClient Info: "+"\n\tID= " + id + "\n\tName= " + fn + " " + ln + "\n\tEmail= " + email + "\n\tPhone= " + phone
				+ "\n\tChecking =" + ca + "\n\tRelated Accounts= " + acList;
	}

//===========================================================	
//Creating saving accounts	
	public void opSaving(Integer pin, Date opDate, double bal,
			ArrayList<Transaction> transList, boolean st, double af, double ae, double of) {
		int acNum = this.acList.size()+1;
		Account saving = new Saving(acNum, pin, opDate, bal,transList, st,af,ae,of);
		this.acList.add(saving);		
	}

//testing...
//============================================================
//Creating crediti accounts
//	public void opCredit(Integer pin, Date opDate, double bal,
//			ArrayList<Transaction> transList, boolean st, double af, double ae, double of) {
//		int acNum = this.acList.size()+1;
//		Account credit = new Credit(acNum, pin, opDate, bal,transList, st,af,ae,of);
//		this.acList.add(saving);		
//	}
	
//============================================================
//Creating Checking accounts	
	public void opChecking(Integer pin, Date opDate, double bal,
			ArrayList<Transaction> transList, boolean st,int ft, double fee) {
		int acNum = this.acList.size()+1;
		Account checking = new Checking(acNum, pin, opDate, bal,transList,st,ft,fee);
		this.acList.add(checking);		
	}
	
	
//============================================================	
//Closing accounts
	public void clAccount(Account acClose) {
		
		if(acClose instanceof Checking) {
			System.out.println("\n\tYou are not allowed to close your Checking account!...\n\n\t\tPlease, try again!");
		}
		else {
			this.acList.get(this.acList.indexOf(acClose)).st = false;		
			System.out.println("Account succesfully closed!\n\n\tThanks for used our ATM");
		}
	}
	
}
