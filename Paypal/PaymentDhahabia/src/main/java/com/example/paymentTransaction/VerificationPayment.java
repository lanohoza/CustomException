package com.example.paymentTransaction;

import com.example.paymentTransaction.Exception.NullObjectException;
import com.paypal.base.rest.APIContext;


public class VerificationPayment {
    public void verificatioCreate(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl, APIContext apiContext) {

        if (total == null|| total==0.0){
            throw new NullObjectException("total can't be null or zéro");
        }
        if (currency == null|| currency==""){
            throw new NullObjectException("currency can't be null or empty");
        }
        if (method == null|| method==""){
            throw new NullObjectException("method can't be null or empty");
        }
        if (intent == null|| intent==""){
            throw new NullObjectException("intent can't be null or empty");
        }
        if (description == null|| description==""){
            throw new NullObjectException("description can't be null or empty");
        }
        if (cancelUrl == null|| cancelUrl==""){
            throw new NullObjectException("cancelUrl can't be null or empty");
        }
        if (successUrl == null|| successUrl==""){
            throw new NullObjectException("successUrl can't be null or empty");
        }
        if (apiContext==null){
            throw new NullObjectException("ApiContext can't be null");
        }
    }

    public void verificatioExecute(String paymentId, String payerId){

        if (paymentId == null|| paymentId==""){
            throw new NullObjectException("paymentId can't be null or empty");
        }
        if (payerId == null|| payerId==""){
            throw new NullObjectException("payerId can't be null or empty");
        }
    }
}
