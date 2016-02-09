package com.hdfc.banking.loans.views;

import java.util.Scanner;

import com.hdfc.banking.loans.dto.LoginDTO;
import com.hdfc.banking.loans.helper.LoginHelper;

public class LoginView {
	
	//void doLogin(String userid, String password, String pinCode){
	void doLogin(LoginDTO loginDTO){
		LoginHelper loginHelper = new LoginHelper();
		String message =loginHelper.doLogin(loginDTO);
		System.out.println("Message "+message);  // Output
		
	}
	public static void main(String[] args) {
		// Input 
		LoginDTO loginDTO = new LoginDTO();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Userid ");
		loginDTO.setUserid(scanner.next());
		System.out.println("Enter the Password");
		loginDTO.setPassword(scanner.next());
		System.out.println("Enter the PinCode");
		loginDTO.setPinCode(scanner.next());
		LoginView loginView =new LoginView();
		
		loginView.doLogin(loginDTO);
		
	}

}
