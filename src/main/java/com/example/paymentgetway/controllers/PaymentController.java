package com.example.paymentgetway.controllers;

import com.example.paymentgetway.dtos.InitiatePaymentRequestDTO;
import com.example.paymentgetway.paymentGateways.PaymentGatewayss;
import com.example.paymentgetway.services.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentGatewayss paymentGateway;
    <PaymentGetway> PaymentController(PaymentGetway paymentGetway) {} {
        this.paymentGateway=paymentGateway;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO initiatePaymentRequestDTO) throws RazorpayException, StripeException {
        return paymentService.initiatePayment(initiatePaymentRequestDTO.getOrderId(),
                initiatePaymentRequestDTO.getEmail()
        );
//        return "hi";
    }
}
