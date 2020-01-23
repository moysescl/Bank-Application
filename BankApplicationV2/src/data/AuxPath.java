package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

import bus.Account;
import bus.Customer;
import bus.ExceptionClass;
import bus.Transaction;


public class AuxPath {
	
//=======================================================================
//Serialized files
	private static String clientPath = "C:\\Users\\moyse\\eclipse-workspace\\BankApplicationV2\\src\\data\\serData.ser";
	private static String transPath = "C:\\Users\\moyse\\eclipse-workspace\\BankApplicationV2\\src\\data\\serTransactions.ser";
	

		public static void writeFiles(ArrayList<Customer> myCustomer) throws IOException
		{					
			FileOutputStream   fos1 = new FileOutputStream(clientPath);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(myCustomer);	
			oos1.close();		
					
		}
		

				public static void writetransactions(ArrayList<Transaction> myTransactions) throws IOException
				//public static void writetransactions(ArrayList<Transaction> transList) throws IOException
				{					
					FileOutputStream   fos1 = new FileOutputStream(transPath);
					ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
					oos1.writeObject(transPath);	
					oos1.close();		
							
				}

		//read from binary file
		@SuppressWarnings("unchecked")
		public static ArrayList<Customer> listClient() throws IOException, ClassNotFoundException
		{
			try {
			FileInputStream fis = new FileInputStream(clientPath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Customer> resultList = (ArrayList<Customer>)ois.readObject();		
			ois.close();
			return resultList;
			}
			catch(FileNotFoundException fnfe)
			{
				return null;
			}
			
		}
		

}
