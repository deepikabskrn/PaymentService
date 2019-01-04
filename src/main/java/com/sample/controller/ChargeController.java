package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.business.Payment;
import com.sample.repository.PaymentRepo;
import com.sample.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;

@Controller
public class ChargeController {
    @Autowired
    private StripeService paymentsService;
    @Autowired
    private PaymentRepo paymentRepo;
 
    @PostMapping("/charge")
    public String charge(Payment payment, Model model)
      throws StripeException {
        Charge charge = paymentsService.charge(payment);
        payment.setChargId(charge.getId());
        payment.setUserEmail(((Card)charge.getSource()).getName());
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        paymentRepo.save(payment);
        return "result";
    }
 
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
    	model.addAttribute("error", ex.getMessage());
        return "result";
    }

}
