package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.AuxPath;

public class Functions {

	public static void newClient(ArrayList<Customer>cuList) throws IOException
	{
		Scanner aCustormer = new Scanner(System.in);		
		ArrayList<Account> aClientList =  new ArrayList<Account>();
		ArrayList<Transaction> aClientTrans =  new ArrayList<Transaction>();
		System.out.println("\nPlease enter the required information");
		System.out.println("\nFirst Name");
		String fn = aCustormer.nextLine();
		System.out.println("\nLast Name");
		String ln = aCustormer.nextLine();
		System.out.println("\nEmail");
		String email = aCustormer.nextLine();
		System.out.println("\nPhone Number");
		String phone = aCustormer.nextLine();
		System.out.println("\nOpening date, day:");
		int day = aCustormer.nextInt();
		System.out.println("\nOpening date, month:");
		int month = aCustormer.nextInt();
		System.out.println("\nOpening date, year:");
		int year = aCustormer.nextInt();
		System.out.println("\nPin for your Checkin account");
		int pin = aCustormer.nextInt();
		Date acoPDate = new Date(day,month,year);		
		Account ca = new Checking(1,pin,acoPDate,0,aClientTrans,true,4,1.5);
		int custNum = cuList.size()+1;
		Customer newCust = new Customer(custNum,fn,ln,email,phone,ca,aClientList);
		cuList.add(newCust);
		System.out.println(newCust);
		AuxPath.writeFiles(cuList);
	}
//=======================================================================
//Listing registered clients
	public static Customer showClients (ArrayList<Customer>custList)
	{
		boolean valid = false;
		//@SuppressWarnings("resource")
		Scanner aCustormer = new Scanner(System.in);		
		while(!valid) {
		System.out.println("\n\tPlease, select a client from the list:\n\t\tType 0 to return\n");
			for(Customer aCustomer : custList)	{
				System.out.println(aCustomer.getId()+" "+ aCustomer.getFn()+" "+ aCustomer.getLn());
			}
			
			String aux = aCustormer.nextLine();
			
		
			System.out.println(aux.toUpperCase()); 
			if(aux == "0")
			{
				System.out.println("Returning...");
				return null;
			}
			
			
			
				int chCust = Integer.parseInt(aux);
			for(Customer aCustomer : custList)	{
				if(aCustomer.getId() == chCust)
				{					
					valid=true;
					return aCustomer;
				}
			}
				if(chCust == 0)
				{
					System.out.println("\n\tInvalid selection, please try again....");
					valid = false;
					return null;
				}	
			}
		
		
		return null;
		
	}

//===============================================================================
//Creating checking
	public static void openChecking(Customer thisCust)
	{
		@SuppressWarnings("resource")
		Scanner aCustormer = new Scanner(System.in);		
		System.out.println("\n\tPlease provide the following information:");
		System.out.println("\n\t1 - Pin Number");
		int pinNum = aCustormer.nextInt();
		System.out.println("\n\t2 - Initial balance");
		double bal = aCustormer.nextDouble();
		ArrayList<Transaction> thisTrans =  new ArrayList<Transaction>();
		Date opDate = new Date(01,12,2019);
		thisCust.opChecking(pinNum, opDate, bal, thisTrans, true, 4, 2);				
		System.out.println("\nAccount succesfully created!");
		System.out.println(thisCust.getAcList());		
	}

//===============================================================================
//Creating saving
	public static void openSavings(Customer thisClient)
	{
		@SuppressWarnings("resource")
		Scanner aCustormer = new Scanner(System.in);		
		System.out.println("\nPlease provide the following information:");
		System.out.println("\n1 - Pin Number");
		int pinNum = aCustormer.nextInt();
		System.out.println("\n2 - Balance");
		double bal = aCustormer.nextDouble();
		ArrayList<Transaction> thisTrans =  new ArrayList<Transaction>();
		Date opDate = new Date(01,12,2019);
		thisClient.opSaving(pinNum, opDate, bal, thisTrans, true, 12, 15, 50);
		System.out.println("\nAccount succesfully created!");
		System.out.println(thisClient.getAcList());		
	}

//==============================================================================
//Creating credit account
//	public static void openCredit(Customer thisClient)
//	{
//		@SuppressWarnings("resource")
//		Scanner aCustormer = new Scanner(System.in);		
//		System.out.println("\nPlease provide the following information:");
//		System.out.println("\n1 - Pin Number");
//		int pinNum = aCustormer.nextInt();
//		System.out.println("\n2 - Balance");
//		double bal = aCustormer.nextDouble();
//		ArrayList<Transaction> thisTrans =  new ArrayList<Transaction>();
//		Date opDate = new Date(01,12,2019);
//		thisClient.opCredit(pinNum, opDate, bal, thisTrans, true, 2, 2000, 100);
//		System.out.println("\nAccount succesfully created!");
//		System.out.println(thisClient.getAcList());		
//	}
//==============================================================================
//Closing account
	public static void closeAccounts(Customer currCustomer)
	{
		Scanner aCustormer = new Scanner(System.in);	
		System.out.println("\n\tWhich account would you like to close:");
		for(Account aAccount : currCustomer.getAcList())	{
			System.out.println(( currCustomer.getAcList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
				}
		int thisAc = aCustormer.nextInt();		
		currCustomer.clAccount(currCustomer.getAcList().get(thisAc));
	}
	
//==============================================================================
//Depositing money
	public static void doDeposit(Customer thisClient) throws IOException
	{		
		
		Scanner aCustormer = new Scanner(System.in);	
		System.out.println("\nWhich account would like to deposit:");
		for(Account aAccount : thisClient.getAcList())	{
		System.out.println(( thisClient.getAcList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
		}
		
		int selectedAcc = aCustormer.nextInt();		
		Account thisAccount = thisClient.getAcList().get(selectedAcc);
		System.out.println("\nEnter the amount to deposit: ");
		double entValue = aCustormer.nextDouble();
		int transNum = thisAccount.getTransList().size()+1;
		String info = "Deposit to account";
		String type = "Deposit";
		Date transDate = new Date(01,12,2019);
		double value = entValue;
		
		thisAccount.impTrans(transNum, info, type, transDate, value);
		
		//ArrayList<Transaction> newCustomerTrans =  new ArrayList<Transaction>();
//		Transaction newTrans = new Transaction(transId,info,type,td,value);
//		newTrans.add(currCustomer);
//		System.out.println(newCustomer);
//		AuxPath.writetransactions(newTrans);
//		================================================
//		Customer newCustomer = new Customer(custNumber,fname,lname,email,pNumber,ca,newCustomeraccountList);
//		customerList.add(newCustomer);
//		System.out.println(newCustomer);
//		AuxPath.writeFiles(customerList);
		
		//=================
//		ArrayList<Transaction> newCustomerTrans =  new ArrayList<Transaction>();
//		Transaction newTrans = new Transaction(transId,info,type,td,value);
//		newCustomerTrans.add(newTrans);
//		//System.out.println(newCustomer);
//		AuxPath.writetransactions(newCustomerTrans);
		
		
	}
	
	
//==================================================================================
//Processing withdraw
	public static void doWithdraw(Customer thisClient) throws IOException
	{		
		Scanner aCustormer = new Scanner(System.in);	
		System.out.println("\nWhich account would you like to withdraw: ");
		for(Account aAccount : thisClient.getAcList())	{
		System.out.println(( thisClient.getAcList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
		}
		
		int thisAc = aCustormer.nextInt();		
		Account thisAccount = thisClient.getAcList().get(thisAc);
		System.out.println("\nPlease enter the value to withdraw:");
		double entValue = aCustormer.nextDouble();
		int transNum = thisAccount.getTransList().size()+1;
		String info = "Withdraw from account";
		String type = "Withdraw";
		Date transDate = new Date(01,12,2019);
		double value = entValue;
		thisAccount.impTrans(transNum, info, type, transDate, value);
		
	}
	
}
