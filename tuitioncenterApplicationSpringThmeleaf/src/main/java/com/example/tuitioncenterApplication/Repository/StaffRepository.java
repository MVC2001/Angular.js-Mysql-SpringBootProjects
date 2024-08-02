package com.example.tuitioncenterApplication.Repository;

import com.example.tuitioncenterApplication.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository  extends JpaRepository<Staff, Long> {
}
