package com.example.paymentTransaction;

import com.example.paymentTransaction.Services.PaypalService;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;


@SpringBootApplication
public class PaymentDhahabiaApplication {

    public static void main(String[] args) throws PayPalRESTException {
        SpringApplication.run(PaymentDhahabiaApplication.class, args);
    }


}
