package com.obms.service.impl;


import com.obms.entity.Injury;
import com.obms.repository.InjuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjuryService {

    @Autowired
    private InjuryRepository injuryRepository;

    public  void saveInjury(Injury injury){
        injuryRepository.save(injury);
    }

    public List<Injury> getAllInjuries(){
        return  injuryRepository.findAll();
    }

    public Injury getInjuryById(Long id){

        return injuryRepository.findById(id).get();
    }

    public  void deleteInjuryById(Long id){
        injuryRepository.deleteById(id);
    }
}
