package com.example.paymentgetway.paymentGateways;

import com.razorpay.PaymentLink;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
//import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import lombok.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class StripePaymentGateway implements PaymentGatewayss{
    @Value("${stripe.apiKey}")
    private String apiKey;

    @Override
    public String generatePaymentLink(Long orderId, String email) throws StripeException {
        Stripe.apiKey = apiKey;
        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(1000L)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();
        Price price = Price.create(params);
        String priceData = price.getId();
        PaymentLinkCreateParams paymentParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(priceData)
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paymentParams);

        return paymentLink.getUrl();
    }
}
