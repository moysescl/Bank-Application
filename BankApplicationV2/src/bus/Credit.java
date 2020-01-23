package bus;

public class Credit extends Account{
	
	Date dd; //due date
	double cl; //credit limit
	
	
	public Date getDd() {
		return dd;
	}
	public void setDd(Date dd) {
		this.dd = dd;
	}
	public double getCl() {
		return cl;
	}
	public void setCl(double cl) {
		this.cl = cl;
	}
	public Credit(Date dd, double cl) {
		super();
		this.dd = dd;
		this.cl = cl;
	}
	public Credit() {
		super();
		this.dd = new Date(01,12,2019);
		this.cl = 0;
	}
	@Override
	public String toString() {
		return "\n\tCredit Account Info: "+"\n\tPayment Date= " + dd + "\n\tLimit Amount= " + cl;
	}
	

}
