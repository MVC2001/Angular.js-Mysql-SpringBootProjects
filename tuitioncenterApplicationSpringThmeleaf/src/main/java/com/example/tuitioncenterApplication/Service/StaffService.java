package com.example.tuitioncenterApplication.Service;

import com.example.tuitioncenterApplication.Entity.Staff;
import com.example.tuitioncenterApplication.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {


    @Autowired
    private StaffRepository staffRepository;

    public  void saveNewStaff(Staff staff){
        staffRepository.save(staff);
    }

    public List<Staff> getAllstaff(){
        return  staffRepository.findAll();
    }

    public Staff getStaffById(Long id){

        return staffRepository.findById(id).get();
    }

    public  void deleteStaffById(Long id){
        staffRepository.deleteById(id);
    }

}
