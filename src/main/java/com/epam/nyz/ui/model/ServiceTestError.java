package com.epam.nyz.ui.model;

public class ServiceTestError {

    private ServiceTestErrorType errorType;

    public ServiceTestError(ServiceTestErrorType errorType) {
        this.errorType = errorType;
    }

    public ServiceTestErrorType getErrorType() {
        return errorType;
    }
    
}
