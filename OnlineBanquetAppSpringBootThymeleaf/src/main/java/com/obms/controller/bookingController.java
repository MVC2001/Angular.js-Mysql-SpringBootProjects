package com.obms.controller;


import com.obms.service.impl.BookingService;
import com.obms.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class bookingController {

      @Autowired
      private BookingService bookingService;




    @GetMapping("/bookingAccount")
    public ModelAndView bookPage(){
        List<Booking> list= bookingService.getAllOrders();
        return new ModelAndView("bookingAccount","booking",list);
    }



    @GetMapping("/saveOrder")
    public  String bookingForm(){
        return  "saveOrder";
    }



    @PostMapping("/saveOrder")
    public  String addOrder(@ModelAttribute Booking booking){
        bookingService.saveOrder(booking);
        return "redirect:/saveOrder?success";
    }

//

    @RequestMapping("/OrderEdit/{id}")
    public  String editOrder(@PathVariable("id") Long id, Model model){
        Booking booking = bookingService.getOrderById(id);
        model.addAttribute("booking", booking);
        return "OrderEdit";
    }

    @RequestMapping("/deleteOrder/{id}")
    public  String deleteOrder(@PathVariable("id") Long id){
        bookingService.deleteOrderById(id);
        return "redirect:/bookingAccount";
    }
}
