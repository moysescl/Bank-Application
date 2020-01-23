package bus;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import data.AuxPath;

@SuppressWarnings("serial")
public class Account implements Serializable {
	
	
	//private static final long serialVersionUID = 42L;
	Integer acNum;
	Integer pin;
	double bal;
	Date opDate;
	boolean st;
	
	ArrayList<Transaction> transList;
	public Account(Integer acNum, Integer pin, Date opDate, double bal,
			ArrayList<Transaction> transList, boolean st) {
		super();
		this.acNum = acNum;
		this.pin = pin;		
		this.opDate = opDate;
		this.bal = bal;
		this.transList = transList;
		this.st = st;
	}
	
	public Account() {
		super();
		this.acNum = 0;
		this.pin = 0;	
		this.opDate = new Date(01,12,2019);
		this.bal = 0;
		this.transList = new ArrayList<Transaction>();
		this.st = true;
	}
	public Integer getAcNum() {
		return acNum;
	}
	public void setAcNum(Integer acNum) {
		this.acNum = acNum;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
		
	public Date getOpDate() {
		return opDate;
	}
	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public ArrayList<Transaction> getTransList() {
		return transList;
	}
	public void setTransList(ArrayList<Transaction> transList) {
		this.transList = transList;
	}

	public boolean isSt() {
		return st;
	}

	public void setSt(boolean st) {
		this.st = st;
	}

	
	
	@Override
	public String toString() {
		return "\nAccount Data:"
				+ "\n\tAccount Number=" + acNum + "\n\tpin number=" + pin + "\n\tDate=" + opDate + "\n\tBalance="
				+ bal + "\n\tTransactions=" + transList + "\n\tStatus=" + st;
		
	}
	
//================================================================
//Implementing transactions
	public void impTrans(Integer transId, String info, String type, Date transDate,
			double value) throws IOException
	{
		Transaction aTransaction = new Transaction(transId,info,type,transDate,value);		
		if(type == "Deposit")
		{
			aTransaction.deposit(value, this);
			//AuxPath.writetransactions(transList);
		}
		else if (type == "Withdraw")
		{
			if (this.bal>=value) {
			aTransaction.withdraw(value, this);
			}
			else {
				System.out.println("Error! Not enoght money...");
			}
		}
		else
		{
			System.out.println("Wrong choice, please try again!");
		}

		this.transList.add(aTransaction);
		AuxPath.writetransactions(transList);
	}
		
}
