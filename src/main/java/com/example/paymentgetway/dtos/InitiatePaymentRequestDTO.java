package com.example.paymentgetway.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {
    private Long orderId;
    private String email;
}
