package bus;

import java.util.ArrayList;

public class Checking extends Account {
	
	int ft; //free transactions
	double fee;
	
	public Checking(Integer acNum, Integer pin, Date opDate, double bal,
			ArrayList<Transaction> transList,boolean st, int ft, double fees) {
		super(acNum, pin, opDate, bal, transList, st);
		this.ft = ft;
		this.fee = fees;
	}
	
	public Checking() {
		super();
		this.ft = 4;
		this.fee = 0;
	}
	public int getFt() {
		return ft;
	}
	public void setFt(int ft) {
		this.ft = ft;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fees) {
		this.fee = fees;
	}

	@Override
	public String toString() {
		return "\n\tChecking Info: "+"\n\tFree Transactions= " + ft + "\n\tfee= " + fee + "\n\tAccount Number= " + acNum
				+ "\n\tpin= " + pin + "\n\tDate= " + opDate + "\nBalance= " + bal + "\n\tTransactions= "
				+ transList + "\nstatus=" + st;
	}
	
	
	

}
