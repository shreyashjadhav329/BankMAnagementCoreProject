package BankManagement.View;
import java.util.Scanner;
import BankManagement.Model.BankAccount;
import BankManagement.Controller.*;
public class BankApp {
	

	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BankService service = new BankService();
	        int choice;

	        do {
	            System.out.println("\n--- Bank Management System ---");
	            System.out.println("1. Create New Account");
	            System.out.println("2. View All Accounts");
	            System.out.println("3. Deposit Money");
	            System.out.println("4. Withdraw Money");
	            System.out.println("5. Check Balance");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Account Number: ");
	                    String accNo = sc.nextLine();
	                    System.out.print("Enter Holder Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Initial Deposit: ");
	                    double deposit = sc.nextDouble();
	                    service.createAccount(accNo, name, deposit);
	                    System.out.println("Account created successfully!");
	                    break;
	                case 2:
	                    System.out.println("\nAll Accounts:");
	                    for (BankAccount acc : service.getAllAccounts()) {
	                        System.out.println(acc);
	                    }
	                    break;
	                case 3:
	                    System.out.print("Enter Account Number: ");
	                    String depAccNo = sc.nextLine();
	                    System.out.print("Enter Amount to Deposit: ");
	                    double amount = sc.nextDouble();
	                    if (service.deposit(depAccNo, amount)) {
	                        System.out.println("Amount deposited successfully!");
	                    } else {
	                        System.out.println("Account not found!");
	                    }
	                    break;
	                case 4:
	                    System.out.print("Enter Account Number: ");
	                    String witAccNo = sc.nextLine();
	                    System.out.print("Enter Amount to Withdraw: ");
	                    double witAmount = sc.nextDouble();
	                    if (service.withdraw(witAccNo, witAmount)) {
	                        System.out.println("Amount withdrawn successfully!");
	                    } else {
	                        System.out.println("Insufficient balance or Account not found!");
	                    }
	                    break;
	                case 5:
	                    System.out.print("Enter Account Number: ");
	                    String checkAccNo = sc.nextLine();
	                    BankAccount acc = service.findAccountByNumber(checkAccNo);
	                    if (acc != null) {
	                        System.out.println("Current Balance: $" + acc.getBalance());
	                    } else {
	                        System.out.println("Account not found!");
	                    }
	                    break;
	                case 6:
	                    System.out.println("Thank you for using Bank Management System!");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 6);

	        sc.close();
	    }
	}

