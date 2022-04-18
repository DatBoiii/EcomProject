package com.tts.ecommerce.Service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tts.ecommerce.ChargeRequest;

import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class StripeService {
    
    @Value("${sk_test_51KoV3rHVkZVA3WqIAUUtomb2PdtsnwyjHjS1izdAXXHl07U9il7WVGUIzambZD6mAByTbs74vi1GiBVBwcdRyXnT00Cjg754Pd}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Charge charge(ChargeRequest chargeRequest)
        throws AuthenticationException, InvalidRequestException,
        ApiConnectionException, CardException, StripeException {
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", chargeRequest.getAmount());
            chargeParams.put("currency", chargeRequest.getCurrency());
            chargeParams.put("description", chargeRequest.getDescription());
            chargeParams.put("source", chargeRequest.getStripeToken());
            return Charge.create(chargeParams);
        }
}
