package com.obms.service.impl;

import com.obms.entity.Payment;
import com.obms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public  void savePayment(Payment payment){
        paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments(){
        return  paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id){

        return paymentRepository.findById(id).get();
    }

    public  void deletePaymentById(Long id){
        paymentRepository.deleteById(id);
    }
}
