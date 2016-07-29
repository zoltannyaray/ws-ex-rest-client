package com.epam.nyz.backend.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalculateResult {

    private Long result;

    public CalculateResult() {
    }

    public CalculateResult(Long result) {
        this.result = result;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
    
    
    
}
