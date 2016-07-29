package com.epam.nyz.ui.model;

import org.hibernate.validator.constraints.NotBlank;

public class ServiceTestForm {

    @NotBlank
    private String expression;

    public ServiceTestForm() {
    }

    public ServiceTestForm(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
