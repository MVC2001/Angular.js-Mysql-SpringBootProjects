package com.example.tuitioncenterApplication.Controller;


import com.example.tuitioncenterApplication.Entity.Payment;
import com.example.tuitioncenterApplication.Entity.Staff;
import com.example.tuitioncenterApplication.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/GetAllStaffs")
    public ModelAndView getAllStaffs(){
        List<Staff> list= staffService.getAllstaff();
        return new ModelAndView("staffPannel","staff",list);
    }

    @GetMapping("/addStaffPage")
    public  String addStaffPage(){

        return "addStaff";
    }


    @PostMapping("/saveStaffs")
    public  String addStaff(@ModelAttribute Staff staff){
        staffService.saveNewStaff(staff);
        return "redirect:/GetAllStaffs";
    }



    @RequestMapping("/editStaff/{id}")
    public  String editPay(@PathVariable("id") long id, Model model){
        Staff staff = staffService.getStaffById(id);
        model.addAttribute("staff", staff);
        return "staffEdit";
    }

    @RequestMapping("/deleteStaff/{id}")
    public  String deleteStaff(@PathVariable("id") long id){
        staffService.deleteStaffById(id);
        return "redirect:/GetAllStaffs";
    }
}
