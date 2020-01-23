package bus;

public interface InterfaceTrans {
	
	public void doTransaction(Integer transNum, String info, String type, Date transDate,
			double value);

}
