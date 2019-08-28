package com.revature.bankingapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.bankingapp.sysoutgui.controllers.AccountController;
import com.revature.bankingapp.sysoutgui.controllers.HomeController;
import com.revature.bankingapp.sysoutgui.dao.AccountDAO;
import com.revature.bankingapp.sysoutgui.dao.UserDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.AccountDAOImpl;
import com.revature.bankingapp.sysoutgui.daoimpl.UserDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.model.User;
import com.revature.bankingapp.sysoutgui.views.HomeView;

@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {
		// SpringApplication.run(BankingAppApplication.class, args);
		
		//See Singleton Scanner for explanation
		try (Scanner reader = SingletonScanner.getScannerInstance()) {
			while(run().equalsIgnoreCase("L"));		
		} catch (Exception e) {
			System.out.println("An error occured in class " + e.getClass() + ": " + e + "\n Exiting application...");
		}
	}
	
	private static String run() {
		System.out.println("App is running");
		HomeController homeController = new HomeController();
		String indicator = homeController.launch();
		if(indicator.equalsIgnoreCase("L")) {
			System.out.println("Logged in successfull");
			AccountController accountController = new AccountController(homeController.getLoggedinAccount());
			indicator = accountController.launch();
		}
		return indicator;
	}
}


//UserDAO userDAOImpl = new UserDAOImpl();
//AccountDAO accountDAOImpl = new AccountDAOImpl();
//User user = new User("Samuel", "Dorilas", "samueldorilas@outlook.com");
//userDAOImpl.save(user);
//User user = new Userc("YinYu", "Chen", "yinyuchen@outlook.com");	
//Account account = new Account("rootYinYu", "password", 2L);
//String [] params = {"Samuel", "Dorilas", "samuel.dorilas@outlook.com"};
//String [] params2 = {"YinYu", "Chen", "yinyuchen@outlook.com"};
//accountDAOImpl.save(account);
//System.out.println(userDAOImpl.getAll());
//System.out.println(accountDAOImpl.getAll());
//new AccountController().launch();
//System.out.println(userDAOImpl.findByEmail("yinyuchen@gmail.com"));