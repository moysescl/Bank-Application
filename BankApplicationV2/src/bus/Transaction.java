package bus;

import java.io.Serializable;

public class Transaction  implements Serializable{

	private static final long serialVersionUID = 1L;
	Integer transNum;
	String type;
	String info;
	Date transDate;
	double amount;
	
	
	public Integer getTransNum() {
		return transNum;
	}
	public void setTransNum(Integer transNum) {
		this.transNum = transNum;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(Integer transNum, String info, String type, Date transDate,
			double amount) {
		super();
		this.transNum = transNum;
		this.info = info;
		this.type = type;
		this.transDate = transDate;
		this.amount = amount;
	}
	public Transaction() {
		super();
		this.transNum = 0;
		this.info = " ";
		this.type = " ";
		this.transDate = new Date(01,12,2019);
		this.amount = 0;
	}
	@Override
	public String toString() {
		return "\n\tTransaction Info: "+ "\n\tTransaction ID= " + transNum + "\n\tInfo= " + info + "\ntype= " + type
				+ "\n\tDate= " + transDate + "\n\tAmount= " + amount;
	}

//========================================================================
//Processing a withdraw
	public Boolean withdraw (double amount, Account anAc) {
		Boolean aux;
		double lastValue = anAc.bal - amount;
		if (lastValue >= 0)
		{ 
			anAc.setBal(lastValue);
			System.out.println("\n\n\t\tWithdraw completed!");
			aux = true; 
		}
		else
		{
			aux = false;
		}
		return aux;		
	}
	
//=========================================================================
//Processing a deposit
	public Boolean deposit (double amount, Account aAc) {
		Boolean aux;
		double lastValue = aAc.bal + amount;
		if (lastValue >= 0)
		{
			aAc.setBal(lastValue);
			System.out.println("\n\n\t\tDeposit completed!");
			aux = true; 
		}
		else
		{
			aux = false;
		}
		return aux;		
	}
			
}
