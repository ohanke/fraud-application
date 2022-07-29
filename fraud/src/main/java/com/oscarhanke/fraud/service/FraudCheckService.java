package com.oscarhanke.fraud.service;

import com.oscarhanke.fraud.model.FraudCheckHistory;
import com.oscarhanke.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudelentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
