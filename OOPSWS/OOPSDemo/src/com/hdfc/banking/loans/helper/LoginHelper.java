package com.hdfc.banking.loans.helper;

import com.hdfc.banking.loans.dao.LoginDAO;
import com.hdfc.banking.loans.dto.LoginDTO;

public class LoginHelper {
	public String doLogin(LoginDTO loginDTO){
		LoginDAO loginDAO = new LoginDAO();
		if(loginDAO.doLogin(loginDTO)){
			return "Welcome "+loginDTO.getUserid();
		}
		return "Invalid Userid or Password";
	}
}
