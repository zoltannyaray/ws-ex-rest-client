package com.epam.nyz.backend.service;

import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.nyz.backend.model.CalculateRequest;
import com.epam.nyz.backend.model.CalculateResult;
import com.epam.nyz.backend.service.exception.CalculatorServiceClientException;
import com.epam.nyz.backend.service.exception.CalculatorServiceException;
import com.epam.nyz.backend.service.exception.CalculatorServiceServerException;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@Service
public class CalculatorService {

    private WebResource calculateWebResource;

    @Autowired
    public CalculatorService(WebResource calculateWebResource) {
        this.calculateWebResource = calculateWebResource;
    }
    
    public CalculateResult calculate(CalculateRequest request) {
        try{
            return calculateWebResource.queryParam("expression", request.getExpression()).get(CalculateResult.class);
        }
        catch (ClientHandlerException e) {
            throw new CalculatorServiceServerException(e);
        }
        catch (UniformInterfaceException e) {
            Status.Family errorFamily = e.getResponse().getStatusInfo().getFamily();
            if(errorFamily.equals(Status.Family.CLIENT_ERROR)){
                throw new CalculatorServiceClientException(e);
            }
            else if(errorFamily.equals(Status.Family.SERVER_ERROR)){
                throw new CalculatorServiceServerException(e);
            }
            else {
                throw new CalculatorServiceException(e);
            }
        }
        catch (Exception e) {
            throw new CalculatorServiceException(e);
        }
    }
    
    
}
