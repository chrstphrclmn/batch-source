package com.revature.bankingapp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.revature.bankingapp.sysoutgui.util.ApplicationLogger;
import com.revature.bankingapp.sysoutgui.util.FeeHandler;
import com.revature.bankingapp.sysoutgui.util.ScannerUtil;
import com.revature.bankingapp.sysoutgui.views.HomeView;

@SpringBootApplication
public class BankingAppApplication {
	private static Logger logger = ApplicationLogger.getLogger();

	public static void main(String[] args) {
		// SpringApplication.run(BankingAppApplication.class, args);

		new FeeHandler().schedule();
		// See Singleton Scanner for explanation
		try (Scanner reader = ScannerUtil.getScannerInstance()) {
			while (run().equalsIgnoreCase("L"))
				;
		} catch (Exception e) {
			logger.info("An error occured in class " + e.getClass() + ": " + e + "\n Exiting application...");
		}
	}

	private static String run() {
		logger.info("App is running");
		HomeController homeController = new HomeController();
		String indicator = homeController.launch();
		if (indicator.equalsIgnoreCase("L")) {
			AccountController accountController = new AccountController(homeController.getLoggedinAccount());
			indicator = accountController.launch();
		}
		return indicator;
	}
}