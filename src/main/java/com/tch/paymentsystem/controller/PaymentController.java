package com.tch.paymentsystem.controller;

import com.tch.paymentsystem.pojo.Payment;
import com.tch.paymentsystem.pojo.PaymentSearchRequest;
import com.tch.paymentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/search")
    public List<Payment> search(PaymentSearchRequest paymentSearchRequest) {
        return paymentService.search(paymentSearchRequest);
    }
}
