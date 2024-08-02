package springsecuritycouse1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.Vendor;
import springsecuritycouse1.services.VendorService;

import java.util.List;

@RestController
@RequestMapping("/api6")
@CrossOrigin(origins = "*")
public class VendorContoller {


    private final VendorService vendorService;

    public VendorContoller(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @PostMapping("/vendor")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return   vendorService.saveVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors(){
        return vendorService.getAllVendors();
    }

    @GetMapping("/vendor/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id){
        Vendor vendor= vendorService.getVendorById(id);
        if(vendor ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vendor);
    }

    @PutMapping("/vendor/{id}")
    public ResponseEntity<Long> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        Vendor existingVendor = vendorService.getVendorById(id);
        if (existingVendor == null)
            return ResponseEntity.notFound().build();

        existingVendor.setName(vendor.getName());
        existingVendor.setAddress(vendor.getAddress());
        existingVendor.setRating(vendor.getRating());
        existingVendor.setReviews(vendor.getReviews());
        existingVendor.setLocation(vendor.getLocation());
        existingVendor.setShippingInformation(vendor.getShippingInformation());
        existingVendor.setContactInformation(vendor.getContactInformation());
        existingVendor.setProductOrigin(vendor.getProductOrigin());
        existingVendor.setCertifications(vendor.getCertifications());
        existingVendor.setDescription(vendor.getDescription());

        Vendor updatedVendor = vendorService.updateVendor(existingVendor);
        // Returning the ID after a successful update
        return ResponseEntity.ok(id);
    }



    @DeleteMapping("/vendor/{id}")
    public  ResponseEntity<Vendor> deleteVendor(@PathVariable Long id){
        Vendor existingVendor = vendorService.getVendorById(id);
        if(existingVendor == null)
            return  ResponseEntity.notFound().build();
        vendorService.deleteVendor(id);
        return  ResponseEntity.ok().build();

    }

}
