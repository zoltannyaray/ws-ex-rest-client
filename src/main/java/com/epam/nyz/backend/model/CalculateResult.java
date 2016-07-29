package com.epam.nyz.backend.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalculateResult {

    private Double result;

    public CalculateResult() {
    }

    public CalculateResult(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
    
    
    
}
