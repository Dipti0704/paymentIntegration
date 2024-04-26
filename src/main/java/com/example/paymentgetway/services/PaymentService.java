package com.example.paymentgetway.services;

import com.example.paymentgetway.paymentGateways.PaymentGatewayss;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public class PaymentService {
    private PaymentGatewayss paymentGateway;
    PaymentService(PaymentGatewayss paymentGateway) {
        this.paymentGateway=paymentGateway;
    }
    public String initiatePayment(Long orderId,String email) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(orderId, email);
    }
}
