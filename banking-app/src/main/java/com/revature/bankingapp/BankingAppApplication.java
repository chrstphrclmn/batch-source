package com.revature.bankingapp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.bankingapp.sysoutgui.controllers.AccountsController;
import com.revature.bankingapp.sysoutgui.controllers.HomeController;
import com.revature.bankingapp.sysoutgui.util.FeeHandler;
import com.revature.bankingapp.sysoutgui.util.ScannerUtil;

@SpringBootApplication
public class BankingAppApplication {
	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// SpringApplication.run(BankingAppApplication.class, args);
		
		logger.info("App is running");
		new FeeHandler().schedule();
		// See Singleton Scanner for explanation
		try (Scanner reader = ScannerUtil.getScannerInstance()) {
			while (run().equalsIgnoreCase("L"));
		} catch (Exception e) {
			logger.info("An error occured in class " + e.getClass() + ": " + e + "\n Exiting application...");
		}
	}

	private static String run() {
		HomeController homeController = new HomeController();
		String indicator = homeController.launch();
		if (indicator.equalsIgnoreCase("L")) {
			AccountsController accountsController = new AccountsController(homeController.getLoggedinAccountId());
			indicator = accountsController.launch();
		}
		return indicator;
	}
}