package springsecuritycouse1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.PriceUpdates;
import springsecuritycouse1.services.PricesUpdatedService;

import java.util.List;


@RestController
@RequestMapping("/api2")
@CrossOrigin(origins = "*")
public class PriceUpdatesCobtroller {


    private final PricesUpdatedService pricesUpdatedService;

    public PriceUpdatesCobtroller(PricesUpdatedService pricesUpdatedService) {
        this.pricesUpdatedService = pricesUpdatedService;
    }


    @PostMapping("/priceUpdate")
    public PriceUpdates addPriceUpdates(@RequestBody PriceUpdates priceUpdates) {
        return pricesUpdatedService.addPriceUpdate(priceUpdates);
    }

    @GetMapping("/priceUpdates")
    public List<PriceUpdates> getPriceUpdates(){
        return pricesUpdatedService.getPriceUpdated();
    }

    @GetMapping("/priceUpdate/{id}")
    public ResponseEntity<PriceUpdates> getPriceUpdatesById(@PathVariable Long id){
        PriceUpdates priceUpdates= pricesUpdatedService.getPriceUpdateById(id);
        if(priceUpdates ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(priceUpdates);
    }

    @PutMapping("/priceUpdate/{id}")
    public ResponseEntity<Long> updatePriceUpdates(@PathVariable Long id, @RequestBody PriceUpdates priceUpdates) {
        PriceUpdates existingPriceUpdates = pricesUpdatedService.getPriceUpdateById(id);
        if (existingPriceUpdates == null)
            return ResponseEntity.notFound().build();

        existingPriceUpdates.setProductName(priceUpdates.getProductName());
        existingPriceUpdates.setCategory(priceUpdates.getCategory());
        existingPriceUpdates.setPrice(priceUpdates.getPrice());
        existingPriceUpdates.setUpdatedAt(priceUpdates.getUpdatedAt());


        PriceUpdates updatePriceUpdates = pricesUpdatedService.updatePriceUpdates(existingPriceUpdates);
        // Returning the ID after a successful update
        return ResponseEntity.ok(id);
    }



    @DeleteMapping("/priceUpdate/{id}")
    public  ResponseEntity<Inventory> deletePriceUpdated(@PathVariable Long id){
        PriceUpdates existingPriceUpdates = pricesUpdatedService.getPriceUpdateById(id);
        if(existingPriceUpdates == null)
            return  ResponseEntity.notFound().build();
        pricesUpdatedService.deletePriceUpdates(id);
        return  ResponseEntity.ok().build();

    }



}
