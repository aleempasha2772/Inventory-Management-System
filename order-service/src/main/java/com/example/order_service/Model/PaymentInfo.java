package com.example.order_service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "card_number")  // Store only last 4 digits in production!
    private String cardNumber;

    @Column(name = "transaction_id")
    private String transactionId;
}