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
import com.epam.nyz.backend.model.CalculateResult;
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
    public void serviceTestResult(@Valid ServiceTestForm serviceTestForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ServiceTestResult serviceTestResult = new ServiceTestResult();
        if (!bindingResult.hasErrors()) {
            CalculateRequest calculateRequest = new CalculateRequest(serviceTestForm.getExpression());
            CalculateResult calculateResult = calculatorService.calculate(calculateRequest);
            serviceTestResult.setResult(String.valueOf(calculateResult.getResult()));
            redirectAttributes.addFlashAttribute(serviceTestResult);
        } else {
            redirectAttributes.addFlashAttribute(serviceTestForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.serviceTestForm", bindingResult);
        }
    }

    @RequestMapping
    public String getView(@Valid ServiceTestForm serviceTestForm, BindingResult bindingResult) {
        return "redirect:/service-test";
    }

}
