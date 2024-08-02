package com.example.tuitioncenterApplication.Service;

import com.example.tuitioncenterApplication.Entity.Payment;
import com.example.tuitioncenterApplication.Repository.PaymentRepository;
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

    public List<Payment> getAllpayment(){
        return  paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id){

        return paymentRepository.findById(id).get();
    }

    public  void deletePaymentById(long id){
        paymentRepository.deleteById(id);
    }


}
