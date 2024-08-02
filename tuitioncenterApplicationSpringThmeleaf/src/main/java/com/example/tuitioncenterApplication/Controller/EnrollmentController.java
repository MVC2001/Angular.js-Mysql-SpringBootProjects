package com.example.tuitioncenterApplication.Controller;

import com.example.tuitioncenterApplication.Entity.Enrollment;
import com.example.tuitioncenterApplication.Entity.Payment;
import com.example.tuitioncenterApplication.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;




    @GetMapping("/GetAllEnrolls")
    public ModelAndView getAllEnrolls(){
        List<Enrollment> list= enrollmentService.getAllenrollments();
        return new ModelAndView("enrollsPannel","enrollment",list);
    }

    @GetMapping("/addEnrollPage")
    public  String addEnrollPage(){

        return "addEntrollment";
    }


    @PostMapping("/savEnrolls")
    public  String addEnrollment(@ModelAttribute Enrollment enrollment){
        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/GetAllEnrolls";
    }


    @RequestMapping("/editEnroll/{id}")
    public  String editEnroll(@PathVariable("id") Integer id, Model model){
        Enrollment enrollment = enrollmentService.getEnrollsById(id);
        model.addAttribute("enrollment", enrollment);
        return "enrollmentEdit";
    }

    @RequestMapping("/deleteEnrollment/{id}")
    public  String deleteEnrollment(@PathVariable("id") Integer id){
        enrollmentService.deleteEnollmentById(id);
        return "redirect:/GetAllEnrolls";
    }

}
