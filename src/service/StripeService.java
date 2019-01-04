package com.sample.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.sample.business.Payment;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
@Service
public class StripeService {
	private static String secretKey = "sk_test_nhjYbrePxWo533PKJJGPq173";

	@PostConstruct
	public void init() {
		Stripe.apiKey = this.secretKey;
	}

	public Charge charge(Payment payment) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		Map<String, Object> chargeParams = new HashMap();
		chargeParams.put("amount", payment.getAmount());
		chargeParams.put("currency", payment.getCurrency());
		chargeParams.put("description", payment.getDescription());
		chargeParams.put("source", payment.getStripeToken());
		return Charge.create(chargeParams);
	}

}
