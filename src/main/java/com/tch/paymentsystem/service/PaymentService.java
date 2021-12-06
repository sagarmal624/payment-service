package com.tch.paymentsystem.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.tch.paymentsystem.pojo.Payment;
import com.tch.paymentsystem.pojo.PaymentSearchRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private static List<Payment> payments = new ArrayList<>();
    @Value("${csv.file.path}")
    private String filePath;

    @PostConstruct
    public void init() {
        try {

            payments = new CsvToBeanBuilder(new FileReader(filePath))
                    .withType(Payment.class)
                    .build()
                    .parse();
            payments = payments.stream().skip(1).collect(Collectors.toList());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Payment> search(PaymentSearchRequest paymentSearchRequest) {
        Predicate<Payment> predicate = (payment) -> {
            if (StringUtils.isNotEmpty(paymentSearchRequest.getSearchKeyword())) {
                return payment.isKeywordExist(paymentSearchRequest.getSearchKeyword());
            } else if (StringUtils.isNotEmpty(paymentSearchRequest.getCity()) && StringUtils.isNotEmpty(paymentSearchRequest.getState())) {
                return payment.getCity().toLowerCase().contains(paymentSearchRequest.getCity().toLowerCase()) && payment.getState().toLowerCase().contains(paymentSearchRequest.getState().toLowerCase());
            }
            return false;
        };
        return payments.stream().filter(predicate).collect(Collectors.toList());
    }
}
