package bus;

public class ExceptionClass extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	private  static final String message = "Something wrong...." ;
	public ExceptionClass(String msg) {
		super(msg);
	
	}
	public ExceptionClass() {
		super(message);
		
	}
}
