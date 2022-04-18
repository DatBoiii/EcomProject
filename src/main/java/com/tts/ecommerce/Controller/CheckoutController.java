package com.tts.ecommerce.Controller;

import com.tts.ecommerce.ChargeRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Value;

@Controller
public class CheckoutController {
    
    @Value("${pk_test_51KoV3rHVkZVA3WqIDiffqsjRsb7OKbu6uM4RvMPJnohCQQYhCl4SWuV5ET1gp2wbBam6sYvZKAlqoqFpALb0apgj004QQot8Ut}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model, @RequestParam("amount") double amount) {
        model.addAttribute("amount", (int) (amount * 100)); 
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}
