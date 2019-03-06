package com.cg.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.services.BankingServices;

@Controller
public class BankingServicesController {
@Autowired
BankingServices bankingServices;

@RequestMapping("/accountCreation")
public ModelAndView createAccount(@ModelAttribute Account account) {
	account =bankingServices.openAccount(account);
	return new ModelAndView("accountCreated","account",account) ;
	
}
}
