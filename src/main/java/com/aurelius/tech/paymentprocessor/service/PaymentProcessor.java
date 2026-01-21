package com.aurelius.tech.paymentprocessor.service;

public interface PaymentProcessor {

    void onMessage(com.aurelius.tech.paymentprocessor.model.PaymentRequest request);

}
