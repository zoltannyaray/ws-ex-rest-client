package com.epam.nyz.backend.model;

public class CalculateRequest {

    private String expression;

    public CalculateRequest() {
    }

    public CalculateRequest(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    

}
