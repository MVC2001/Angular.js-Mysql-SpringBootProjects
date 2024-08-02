package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.PriceUpdates;
import springsecuritycouse1.repositories.PriceUpdatedRepository;

import java.util.List;

@Service
public class PricesUpdatedService {

    @Autowired
    private final PriceUpdatedRepository priceUpdatedRepository;

    public PricesUpdatedService(PriceUpdatedRepository priceUpdatedRepository) {
        this.priceUpdatedRepository = priceUpdatedRepository;
    }

    public PriceUpdates addPriceUpdate(PriceUpdates priceUpdates){
        return  priceUpdatedRepository.save(priceUpdates);
    }

    public List<PriceUpdates> getPriceUpdated(){
        return  priceUpdatedRepository.findAll();
    }


    public  PriceUpdates getPriceUpdateById(Long id){
        return priceUpdatedRepository.findById(id).orElse(null);
    }

    public PriceUpdates  updatePriceUpdates(PriceUpdates priceUpdates){
        return priceUpdatedRepository.save(priceUpdates);
    }

    public  void deletePriceUpdates(Long id){
        priceUpdatedRepository.deleteById(id);
    }



}
