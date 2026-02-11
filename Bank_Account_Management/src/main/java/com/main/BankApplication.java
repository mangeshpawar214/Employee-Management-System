package com.main;

import java.util.Scanner;

import com.dao.BankAccountDao;
import com.dao.BankAccountDaoOperations;
import com.entity.BankAccounts;

public class BankApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccountDao BAdao = new BankAccountDaoOperations();

        while (true) {
            System.out.println("\n------------------------- Enter Your Choice----------------------------------------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    BankAccounts account = new BankAccounts();
                    BAdao.createAccount(account);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accountnumber = sc.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depAmount = sc.nextDouble();

                    BAdao.depositAmount(accountnumber, depAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accountnumber1 = sc.nextInt();

                    System.out.print("Enter Withdraw Amount: ");
                    double withAmount = sc.nextDouble();

                    BAdao.withdrawAmount(accountnumber1, withAmount);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
