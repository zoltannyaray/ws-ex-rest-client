package com.epam.nyz.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.nyz.ui.model.ServiceTestForm;
import com.epam.nyz.ui.model.ServiceTestResult;

@Controller
@RequestMapping(path="/service-test", method=RequestMethod.GET)
public class ServiceTestGetController {

    @ModelAttribute
    public ServiceTestForm getServiceTestForm(){
        return new ServiceTestForm();
    }
    
    @ModelAttribute
    public ServiceTestResult getServiceTestResult(){
        return new ServiceTestResult();
    }
    
    @RequestMapping
    public String getView(){
        return "service-test-form";
    }
    
}
