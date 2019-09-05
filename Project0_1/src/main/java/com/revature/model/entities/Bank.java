package com.revature.model.entities;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.StringValueExp;

import com.revature.bankdao.AccountDao;
import com.revature.bankdao.UserDao;
import com.revature.bankdao.methods.AccountDaoMethods;
import com.revature.bankdao.methods.UserDaoMethods;
import com.revature.model.abstractObjects.Account;
import com.revature.visualfeedback.Mensajes;





public class Bank implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	static Scanner sc = new Scanner(System.in);
	static UserDao udao = new UserDaoMethods();
	static AccountDao adao = new AccountDaoMethods();
	 
	
	private static int passwordTries=3;
	
	

	public Bank() {
		super();
	}
	
	public static String formulario(int i) {
				
		String parameters = "";
		boolean passwordConfirm = false;
		
		switch (i) {
		case 0: 
			System.out.println("Full Name:");
			parameters=sc.nextLine();
			break;
		case 1:
			System.out.println("Username:");
			parameters=sc.nextLine();
			break;
		case 2:
			System.out.println("Address:");
			parameters=sc.nextLine();
			break;
		case 3:
			System.out.println("Email:");
			parameters=sc.nextLine();
			break;
		case 4:
			System.out.println("Password:");
			parameters=DigestUtils.md5Hex(sc.nextLine());
			while(passwordConfirm==false) {
				System.out.println("Confirm Password:");
				String p=DigestUtils.md5Hex(sc.nextLine());
				if(p.matches(parameters)) {
					passwordConfirm=true;
				}				
			}
			
			break;
			
		}
		
		return parameters;
	}
	
	public static void createBankUser() {
		int state=0;
		
		String[] parameters =new String[5];
		for(int i=0;i<parameters.length;i++) {
			parameters[i]=Bank.formulario(i);	
		}
		
		User u = new User(
				0, parameters[0],
				parameters[1],
				parameters[2],
				parameters[3],
				parameters[4]
						);
		state=udao.createUser(u);
		if(state==0) {
			Mensajes.invalidArguments();
			Bank.start();
		}
	}
	
	
	public static void start() {
		
		Mensajes.start();
		String opcion = sc.nextLine();
		UserDao u = new UserDaoMethods();
		
		switch(opcion) {
		
		default:
			
			Bank.start();
			Mensajes.invalidOption();
			Mensajes.start();
			break;
			
		case "0":
			Mensajes.end();
			break;
			
		case "1": 
			Bank.createBankUser();
			Bank.start();	
			break;
			
		case "2":
			Bank.userValid();				
			break;
			
		}
	}


	public static void userValid() {
		
		int user=0;
		int i=passwordTries;
		while(i>0) {
			i--;
			Mensajes.enterUser();
			String usuario=sc.nextLine();
			Mensajes.enterPassword();
			String contraseña=DigestUtils.md5Hex(sc.nextLine());
			user=udao.confirmUser(usuario, contraseña);
			if(user>0) {
				break;
			}
			if (i==0) {
				Bank.start();
			}
			Mensajes.invalidArguments();
		
		}
		
		
		
		userMenu(udao.getUser(user));	
	}

	
	public static void userMenu(User u) {
		
		
		Mensajes.userMenu(u.getName());
		String opcion = sc.nextLine();
		
		
		switch(opcion) {
		
		
			
		case "0":
			Bank.start();
			break;
			
		case "1":
			Mensajes.crearCuenta();
			Bank.createAccount(u);
			
			break;
			
		case "2":
			Bank.viewAccountBalance(u);				
			break;
			
		default:
//			Mensajes.invalidOption();
			userMenu(u);
			//			Mensajes.userMenu(u.getName());
			break;
			
//		case "3":
//			Bank.depositMoney(u);				
//			break;
//			
//		case "4":
//			Bank.withdrawMoney(u);				
//			break;	
		}
		
	}
	
	
	public static void createAccount(User u) {
		List<Account> cuentas = adao.getAccounts(u.getId());
		int number=cuentas.size()+1;
		int cos=sc.nextInt();
		int accountNumber=100*u.getId()+100000*cos+number;
		Mensajes.initialAmount();
		double totalMoney=sc.nextDouble();
		Account cuenta = new Account(0, u.getId(), 
				cos, u.getUserName(), accountNumber, totalMoney);
		
		adao.createAccount(cuenta);
		
		Bank.userMenu(u);
		
	}
	
	public static void viewAccountBalance(User u) {
		
		
		List<Account> cuentas = adao.getAccounts(u.getId()); 
		if(cuentas.isEmpty()) {
			Bank.userMenu(u);
		}
		int cont=1;
		for(Account cuenta:cuentas) {
			
			System.out.print(cuenta.getAccountNumber()
					+"--------------------------------------------");
			System.out.printf("$%.2f", cuenta.getTotalMoney());
			System.out.print("   "+cont+"\n");
			cont++;		
		}
			
		Mensajes.selectAccount();
		int selectCuenta=sc.nextInt();
		Account cuenta=null;
		cuenta=cuentas.get(selectCuenta-1);
		Mensajes.balanceCuenta(cuenta);
		switch(selectCuenta) {
		default:		
			Bank.depositOrWithdraw(u,cuenta);		
			break;
		
		case 0:
			Bank.userMenu(u);
		
		}
	}
	
	public static void depositOrWithdraw(User u,Account c) {
		Mensajes.depositOrwithdraw();
		int opcion = sc.nextInt();
		
		double amount = 0;
		double money=0;
		switch(opcion) {
		
		
		case 1:
			Mensajes.amount();
			amount = sc.nextDouble();
			money =+amount;
			adao.updateTotal(c.getAccountId(), money);
			Bank.userMenu(u);
			break;
		case 2:
			Mensajes.amount();
			
			amount = sc.nextDouble();
			if(amount>c.getTotalMoney()) {
				Mensajes.invalidArguments();
				depositOrWithdraw(u,c);
				break;
				
			}
			money =-amount;
			
			adao.updateTotal(c.getAccountId(), money);
			Bank.userMenu(u);
			break;
		case 3:
			adao.deleteAccount(c.getAccountId());
			Bank.userMenu(u);
			break;
		case 0:
			Bank.userMenu(u);
			break;
		default:
			Mensajes.invalidOption();
			depositOrWithdraw(u,c);
			break;
		
		}
		
	}
	
	
	

	
	
	
}
