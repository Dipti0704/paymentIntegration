package com.example.paymentgetway.paymentGateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGatewayss {
    public String generatePaymentLink(Long orderId, String email) throws RazorpayException, StripeException;
}
