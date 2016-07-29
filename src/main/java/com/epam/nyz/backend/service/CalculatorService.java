package com.epam.nyz.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.nyz.backend.model.CalculateRequest;
import com.epam.nyz.backend.model.CalculateResult;
import com.sun.jersey.api.client.WebResource;

@Service
public class CalculatorService {

    private WebResource calculateWebResource;

    @Autowired
    public CalculatorService(WebResource calculateWebResource) {
        this.calculateWebResource = calculateWebResource;
    }
    
    public CalculateResult calculate(CalculateRequest request) {
        return calculateWebResource.queryParam("expression", request.getExpression()).get(CalculateResult.class);
    }
    
    
}
