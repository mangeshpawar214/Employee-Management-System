package com.Main;

import java.util.Scanner;

import com.Controller.UserController;
import com.Entity.UserEntity;

public class UserMain {
	
	public static void main(String[] args) 
	
	{
		
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		
		while(true)
		{
		System.out.println("============Welcome  To User Hub===============\n");
		
		System.out.println("-----------------select any choice give below-------------------\n");
		
		System.out.println("1.Save User");
		System.out.println("2.Update user	");
		System.out.println("3.Delete User");
		System.out.println("4.Delete User By Id");
		System.out.println("5.Delete All Users");
		System.out.println("6.Get User By Id");
		System.out.println("7.Get All Users");
		System.out.println("8.Get Male Users Only");
		System.out.println("9.Get Female Users Only");
		System.out.println("10.Exit");
		
		System.out.println("------------------------------------------------------------------");
		
		System.out.println("Enter Your Choice");
		int choice = sc.nextInt();
		
		
		
		if(choice==1)
		{
			
			System.out.println("----------Fill Following Detal To Save The User-------------");
			System.out.println("Enter User ID :");
			int id=sc.nextInt();
			System.out.println("Enter User NAME :");
			String name=sc.next();
			System.out.println("Enter User EMAIL :");
			String email=sc.next();
			System.out.println("Enter User PASSWORD :");
			String passoword=sc.next();
			System.out.println("Enter User GENDER :");
			String gender=sc.next();
			System.out.println("Enter User ADDRESS :");
			String address =sc.next();
			
			
			UserEntity user = new UserEntity();
			
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(passoword);
			user.setGender(gender);
			user.setAddress(address);
			
			controller.saveUser(user);
			
		}
		
		
		
		
		else if(choice==10)
		{
			System.out.println("=============Thank You===========");
			break;
		}else {
			System.out.println("Enter Valid Choice...");
		}
		
		}	
		
		
		sc.close();
	}

}
