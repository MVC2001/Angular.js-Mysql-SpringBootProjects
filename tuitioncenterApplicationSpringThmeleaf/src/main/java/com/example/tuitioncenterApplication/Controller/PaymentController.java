package com.example.tuitioncenterApplication.Controller;

import com.example.tuitioncenterApplication.Entity.Payment;
import com.example.tuitioncenterApplication.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentController {


    @Autowired
    private PaymentService paymentService;



    @GetMapping("/GetAllPays")
    public ModelAndView getAllPays(){
        List<Payment> list= paymentService.getAllpayment();
        return new ModelAndView("paymentPage","payment",list);
    }

    @GetMapping("/addPaymentPage")
    public  String addPaymentPage(){

        return "addPayment";
    }


    @PostMapping("/savePays")
    public  String addPay(@ModelAttribute Payment payment){
        paymentService.savePayment(payment);
        return "redirect:/GetAllPays";
    }



    @RequestMapping("/editPay/{id}")
    public  String editPay(@PathVariable("id") long id, Model model){
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "payEdit";
    }

    @RequestMapping("/deletePayment/{id}")
    public  String deletePay(@PathVariable("id") long id){
        paymentService.deletePaymentById(id);
        return "redirect:/GetAllPays";
    }
}

