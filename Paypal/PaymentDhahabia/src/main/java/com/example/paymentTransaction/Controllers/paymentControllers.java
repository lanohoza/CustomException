package com.example.paymentTransaction.Controllers;


import com.example.paymentTransaction.Exception.NullObjectException;
import com.example.paymentTransaction.Requests.OrderRequest;
import com.example.paymentTransaction.Services.*;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class paymentControllers {

    public static final String SUCCESS_URL_PP = "try/success";
    public static final String CANCEL_URL_PP = "try/cancel";


    @Autowired
    private PaypalService paypalService;




    ////////////////////////////////////////////////// Page Home ///////////////////////////////////////////////////////////////////////
    @GetMapping("/")
    public String home() {
        return "home";
    }





    ///////////////////////////////////////////////// PayPal Payment ////////////////////////////////////////////////////////////////////

    @RequestMapping("/try")
    public String paymentPayPal(@ModelAttribute("order") OrderRequest orderRequest) throws Exception {


        try {
            Payment paymentPaypal = paypalService.createPayment(null, "EUR", "PAYPAL",
                    "sale", "good product", "http://localhost:1995/" + CANCEL_URL_PP,
                    "http://localhost:1995/" + SUCCESS_URL_PP);

            for (Links link : paymentPaypal.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        catch (NullObjectException e) {

            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL_PP)
    public String cancelPayPal() {
        return CANCEL_URL_PP;
    }

    @GetMapping(value = SUCCESS_URL_PP)
    public String successPayPal(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) throws Exception {
        try {
            com.paypal.api.payments.Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return SUCCESS_URL_PP;
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }





}
