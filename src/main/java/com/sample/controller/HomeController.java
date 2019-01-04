package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.business.Payment;

@Controller
public class HomeController {

	private static String stripePublicKey = System.getenv("stripePublicKey");

	@RequestMapping(value = "/")
	public String home(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "index";
	}

	@RequestMapping(value = "/pay")
	public String pay(Model model) {
		model.addAttribute("amount", 50 * 100); // in cents
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("currency", Payment.Currency.USD);
		return "checkout";
	}
}
