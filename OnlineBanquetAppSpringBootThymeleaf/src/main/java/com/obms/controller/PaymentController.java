package com.obms.controller;

import com.obms.entity.Payment;
import com.obms.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentController {


      @Autowired
      private PaymentService paymentService;



    @GetMapping("/paymentAccount")
    public ModelAndView paymentPage(){
        List<Payment> list= paymentService.getAllPayments();
        return new ModelAndView("paymentAccount","payment",list);
    }



    @GetMapping("/savePayment")
    public  String paymentForm(){
        return  "savePayment";
    }



    @PostMapping("/savePayment")
    public  String addPayment(@ModelAttribute Payment payment){
        paymentService.savePayment(payment);
        return "redirect:/paymentAccount?success";
    }


    @RequestMapping("/PaymentEdit/{id}")
    public  String editPayment(@PathVariable("id") Long id, Model model){
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "PaymentEdit";
    }



    @RequestMapping("/deletePayment/{id}")
    public  String deleteOrder(@PathVariable("id") Long id){
        paymentService.deletePaymentById(id);
        return "redirect:/paymentAccount";
    }
}
