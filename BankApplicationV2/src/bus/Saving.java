package bus;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Saving extends Account{
	
	double yInt;
	double yEarn;
	double of;

	public double getyInt() {
		return yInt;
	}

	public void setyInt(double yInt) {
		this.yInt = yInt;
	}

	public double getyEarn() {
		return yEarn;
	}

	public void setYEarn() {
		this.yEarn = yInt*bal;
	}

	public double getOf() {
		return of;
	}

	public void setOf(double of) {
		this.of = of;
	}

	public Saving(Integer acNum, Integer pin, Date opDate, double bal,
			ArrayList<Transaction> transList, boolean st, double yInt, double yEarn, double of) {
		super(acNum, pin, opDate, bal, transList, st);
		this.yInt = yInt;
		this.yEarn = yEarn;
		this.of = of;
	}

	public Saving() {
		super();
		this.yInt = 0;
		this.yEarn = 0;
		this.of = 0;
	}

	@Override
	public String toString() {
		return "\n\tSaving Info: " +"\n\tYearly Interest= " + yInt + "\n\tYearly earn= " + yEarn + "\n\tExtra Fees= "
				+ of + "\n\tAccount ID= " + acNum + "\n\tPin number= " + pin + "\n\tDate=" + opDate + "\n\tBalance= "
				+ bal + "\n\tTransactions= " + transList + "\n\tStatus=" + st;
	}

}
