package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.entity.BankAccounts;
import com.util.HibernateConnection;

public class BankAccountDaoOperations implements BankAccountDao {

	
	//========================================================creation==========================================================================

	@Override
	public void createAccount(BankAccounts account) {
		
		Session session  = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();
		session.close();
		System.out.println(" Congratulations...Account Created Sucessfully with given credentials...");
		
		}

	
	//========================================================get account==========================================================================

	
	@Override
	public BankAccounts getAccountById(int accountnumber)
	{
		Session session = HibernateConnection.getSessionFactory().openSession();
		BankAccounts account=session.get(BankAccounts.class,accountnumber);
		session.close();
		return account;
	}
	
	
	//========================================================deposit==========================================================================

	

	@Override
	public void depositAmount(int accountnumber ,  double depositamount) 
	{
		
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction transaction =  session.beginTransaction();
		BankAccounts account = session.get(BankAccounts.class,accountnumber);
		
		
		 if (account != null) {

		        double oldBalance = account.getAccountbalance();
		        System.out.println("your Current Balance  is : " + oldBalance);

		        System.out.println(" Enter amount to deposit : " + depositamount);

		        double newBalance = oldBalance + depositamount;
		        account.setAccountbalance(newBalance);

		        session.update(account);
		        transaction.commit();

		        System.out.println("Amount Deposited Successfully");
		        System.out.println(" Your Deposited Amount : " + depositamount);
		        System.out.println("Your Updated Balance : " + newBalance);

		    } else {
		        System.out.println("Account not found with given credentials");
		    }

		    session.close();
		}
	
	
	
	//========================================================withdraw==========================================================================
	

	@Override
	public void withdrawAmount(int accountnumber, double withdrawamount)
	{
		
		
		    Session session = HibernateConnection.getSessionFactory().openSession();
		    Transaction tx = session.beginTransaction();

		    BankAccounts account = session.get(BankAccounts.class, accountnumber);

		    if (account != null) {

		        double oldBalance = account.getAccountbalance();
		        System.out.println(" your Current Balance is : " + oldBalance);

		        System.out.println("Enter amount to Withdraw : " + withdrawamount);

		        if (oldBalance >= withdrawamount) {

		            double newBalance = oldBalance - withdrawamount;
		            account.setAccountbalance(newBalance);

		            session.update(account);
		            tx.commit();

		            System.out.println("Amount Withdrawn Successfully");
		            System.out.println("Withdrawn Amount : " + withdrawamount);
		            System.out.println("Updated Balance : " + newBalance);

		        } else {
		            System.out.println("Insufficient Balance");
		        }

		    } else {
		        System.out.println(" Account not found with given Credentials..");
		    }

		    session.close();
		}

	//========================================================close==========================================================================


	@Override
	public void closeAccount(int accountNo) 
	{
		Session session = HibernateConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        BankAccounts account = session.get(BankAccounts.class, accountNo);
        session.delete(account);

        tx.commit();
        session.close();

        System.out.println("Your Account is closed now....!");
    }

		
	}


