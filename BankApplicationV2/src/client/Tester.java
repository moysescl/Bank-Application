package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bus.Account;
import bus.Checking;
import bus.Customer;
import bus.Date;
import bus.Functions;
import bus.ExceptionClass;
import bus.Transaction;
import data.AuxPath;

public class Tester {
	//@SuppressWarnings("unused")
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, ClassNotFoundException, ExceptionClass {
		
	
	int aClient = 0;
	Customer thisClient = new Customer();		
	Account thisAc = new Account();
	ArrayList<Customer> readSer;	
	if(AuxPath.listClient() == null)
	{
		readSer = new ArrayList<Customer>();
		System.out.println("\n\n\t\t\t\t\tWelcome to Fortis Bank");
		System.out.println("\n\n\t\tSorry, there is no customer registered yet...");
		System.out.println("\n\n\t\tPlease, register at least one customer!");
		
	}	
	else {
		readSer = AuxPath.listClient();	
	}
	int transNum;		
	boolean out = false;
	do {
	//First Menu
	System.out.println("\n\n\t\t\t\t\tWelcome to Fortis Bank!");
	System.out.println("\n\tWhich operation would you like to do:");
	System.out.println("\n\t\t1-Register new client");
	System.out.println("\n\t\t2-Existing client");
	System.out.println("\n\t\t3-End application");	
	
	Scanner  aCust = new Scanner(System.in);
	int aux1 = aCust.nextInt();
	aCust.nextLine();	
	switch (aux1) {
	
//=======================================================================	
//Registering new clients for the bank
		case 1:
			Functions.newClient(readSer);
			break;

//=======================================================================
//Managing existing clients 		
		case 2:
			
			thisClient = Functions.showClients(readSer);		
			if(thisClient==null)
			{
				System.out.println("\nUnable to find Client, please try again.");				
				break;
			}			
			boolean b = false;
			do {
				//back=false;
				System.out.println("\n\n\t\t\t\t\tWelcome back "+ thisClient.getFn()+ " !");
				System.out.println("\n\tWhich operation would you like to do:");
				System.out.println("\n\t\t1 - Open new account");
				System.out.println("\n\t\t2 - Close existing accounts");
				System.out.println("\n\t\t3 - Balance consultation");
				System.out.println("\n\t\t4 - Deposit");
				System.out.println("\n\t\t5 - Withdraw");
				System.out.println("\n\t\t6 - Return");
				
				int aux2 = aCust.nextInt();				 
				switch(aux2) {

//===========================================================================
//New accounts
					case 1:
						System.out.println("\n\tWhich account would you like to open:");
						System.out.println("\n\t\t1 - Checking");
						System.out.println("\n\t\t2 - Saving");
						System.out.println("\n\t\t3 - Credit");
						
						
			
						System.out.println("\n\t0 - Return");
						int inputMenu3 = aCust.nextInt();
						
						switch(inputMenu3) {
							
							case 1:
								Functions.openChecking(thisClient);
								break;
															
							case 2:
								Functions.openSavings(thisClient);
								break;		
							case 4:
								b = true;
								break;
							default:
								System.out.println("\n\n\t\tWrong choice, please try again!");
								}				
						break;		
						
					case 2://Close Account
						Functions.closeAccounts(thisClient);
						break;
					
					case 3: //Check Balance
						System.out.println("\n\tShowing balance: ");
						for(Account aAccount : thisClient.getAcList())
						{
							System.out.println(( thisClient.getAcList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)+ " $" + aAccount.getBal()));
						}				
						break;
//=====================================================================
//Deposit
					case 4:
						Functions.doDeposit(thisClient);
						break;
					case 5:
//=====================================================================
//Withdraw
						Functions.doWithdraw(thisClient);
						break;
					case 6:
						b = true;
						break;
					default:
						System.out.println("Invalid Option!");						
							}				
						
						int indexOfcust = readSer.indexOf(thisClient);
						readSer.set(indexOfcust, thisClient);	
						AuxPath.writeFiles(readSer);	
						}while(!b);
			break;
		case 3:
				AuxPath.writeFiles(readSer);		
				out = true;
				System.out.println("\n\n\t\tThanks for using our ATM");
				System.out.println("\n\n\t\t\tBye bye...");
				break;	
		default:
			System.out.println("Invalid Option!");
			}
		AuxPath.writeFiles(readSer);		
		}while(!out);
	}
}
		
		
		
			
			
		
		
