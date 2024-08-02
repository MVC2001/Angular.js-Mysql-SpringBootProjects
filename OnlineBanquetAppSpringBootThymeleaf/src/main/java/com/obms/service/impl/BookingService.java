package com.obms.service.impl;


import com.obms.entity.Booking;
import com.obms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {


    @Autowired
    private BookingRepository bookingRepository;

    public  void saveOrder(Booking booking){
        bookingRepository.save(booking);
    }

    public List<Booking> getAllOrders(){
        return  bookingRepository.findAll();
    }

    public Booking getOrderById(Long id){

        return bookingRepository.findById(id).get();
    }

    public  void deleteOrderById(Long id){
        bookingRepository.deleteById(id);
    }
}
