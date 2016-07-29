package com.epam.nyz.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.nyz.backend.model.CalculateRequest;
import com.epam.nyz.backend.service.CalculatorService;
import com.epam.nyz.ui.model.ServiceTestForm;
import com.epam.nyz.ui.model.ServiceTestResult;

@Controller
@RequestMapping(path = "/service-test", method = RequestMethod.POST)
public class ServiceTestPostController {

    private CalculatorService calculatorService;
    
    @Autowired
    public ServiceTestPostController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ModelAttribute
    public void getForm(@ModelAttribute @Valid ServiceTestForm serviceTestForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(!bindingResult.hasErrors()){
            ServiceTestResult serviceTestResult = new ServiceTestResult(String.valueOf(calculatorService.calculate(new CalculateRequest(serviceTestForm.getExpression())).getResult()));
            redirectAttributes.addFlashAttribute(serviceTestResult);
        }
    }
    
    @RequestMapping
    public String getView(@ModelAttribute @Valid ServiceTestForm serviceTestForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "service-test-form";
        }
        else {
            return "redirect:/service-test";
        }
    }

}
