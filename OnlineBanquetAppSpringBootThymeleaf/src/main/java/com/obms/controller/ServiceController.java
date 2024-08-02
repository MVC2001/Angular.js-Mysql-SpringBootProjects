package com.obms.controller;

import com.obms.entity.ServiceEntity;
import com.obms.service.impl.ServiceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceServiceImp serviceServiceImp;



    @GetMapping("/serviceHome")
    public ModelAndView  servicePage(){
        List<ServiceEntity> list= serviceServiceImp.getAllServicePosts();
        return new ModelAndView("/serviceHome","service",list);
    }


    @GetMapping("/service/servicePage")
    public ModelAndView AdminservicePage(){
        List<ServiceEntity> list= serviceServiceImp.getAllServicePosts();
        return new ModelAndView("/service/servicePage","service",list);
    }



    @GetMapping("/service/addPost")
    public  String SaveServicePosts(){
        return "/service/addPost";
    }



    @PostMapping("/service/addPost")
    public  String addServicePosts(@ModelAttribute ServiceEntity serviceEntity){
        serviceServiceImp.saveServicePosts(serviceEntity);
        return "redirect:/service/servicePage?success";
    }


    @RequestMapping("/service/PostEditForm/{id}")
    public  String editPost(@PathVariable("id") Long id, Model model){
        ServiceEntity service = serviceServiceImp.getServicePostsById(id);
        model.addAttribute("service", service);
        return "/service/PostEditForm";
    }



    @RequestMapping("/deleteServicePost/{id}")
    public  String deletePost(@PathVariable("id") Long id){
        serviceServiceImp.deleteServicePostsById(id);
        return "redirect:/service/servicePage";
    }

}
