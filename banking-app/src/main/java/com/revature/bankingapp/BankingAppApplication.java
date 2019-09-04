package com.revature.bankingapp;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.boot.SpringApplication;
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

		logger.info("The application was started successfully");
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new FeeHandler(), 0, 24, TimeUnit.HOURS);

		try (Scanner reader = ScannerUtil.getScannerInstance()) {
			while (run().equalsIgnoreCase("L"))
				;
		} catch (Exception e) {
			logger.info("An error occured in class " + e.getClass() + ": " + e + "\n Exiting application...");
		}
		logger.info("Successfully exited the application");
	}

	private static String run() {
		HomeController homeController = new HomeController();
		String indicator = homeController.launch();
		logger.info("Successfully exited the home controller");
		if (indicator.equalsIgnoreCase("L")) {
			AccountsController accountsController = new AccountsController(homeController.getLoggedinAccountId());
			indicator = accountsController.launch();
			logger.info("Successfully exited the account controller");
		}
		return indicator;
	}
}