package com.petadoption.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payments")
public class PaymentsEntity {

    @Id
    private String paymentId;

    private String userId;

    private String username;
    private List<PaymentDetailsEntity> payments;
}


