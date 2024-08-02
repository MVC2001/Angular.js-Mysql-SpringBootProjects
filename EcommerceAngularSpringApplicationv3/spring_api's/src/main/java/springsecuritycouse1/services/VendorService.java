package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.entities.Vendor;
import springsecuritycouse1.repositories.ShopRepository;
import springsecuritycouse1.repositories.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }


    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }


    public Vendor getVendorById(Long id){
        return vendorRepository.findById(id).orElse(null);
    }

    public Vendor updateVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public  void deleteVendor(Long id){
        vendorRepository.deleteById(id);
    }

}
