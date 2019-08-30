package com.revature.bankingapp.sysoutgui.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLogger {

	private static Logger logger= LogManager.getLogger();;

	private ApplicationLogger() {
	}

	public static Logger getLogger() {
		
		return logger;
	}
}
