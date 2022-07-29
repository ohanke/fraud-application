package com.oscarhanke.fraud.controller;

import com.oscarhanke.fraud.model.FraudCheckResponse;
import com.oscarhanke.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/vi/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudelentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
