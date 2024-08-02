package springsecuritycouse1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.services.InventoryService;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InventoryCntrroller {

    private final InventoryService inventoryService;

    public InventoryCntrroller(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory inventory){
        return   inventoryService.addInventory(inventory);
    }

    @GetMapping("/inventories")
    public List<Inventory> getAllItems(){
        return inventoryService.getAllItems();
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id){
        Inventory inventory= inventoryService.getInventoryId(id);
        if(inventory ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity<Long> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory existingInventory = inventoryService.getInventoryId(id);
        if (existingInventory == null)
            return ResponseEntity.notFound().build();

        existingInventory.setName(inventory.getName());
        existingInventory.setProduct(inventory.getProduct());
        existingInventory.setCategory(inventory.getCategory());
        existingInventory.setPrice(inventory.getPrice());
        existingInventory.setTotal(inventory.getTotal());
        existingInventory.setStatus(inventory.getStatus());
        existingInventory.setAdded_at(inventory.getAdded_at());
        existingInventory.setExpired_at(inventory.getExpired_at());

        // Assuming inventoryService.updateInventory returns the updated inventory
        Inventory updatedInventory = inventoryService.updateInventory(existingInventory);

        // Returning the ID after a successful update
        return ResponseEntity.ok(id);
    }



    @DeleteMapping("/inventory/{id}")
    public  ResponseEntity<Inventory> deleteInventory(@PathVariable Long id){
        Inventory existingInventory = inventoryService.getInventoryId(id);
        if(existingInventory == null)
            return  ResponseEntity.notFound().build();
        inventoryService.deleteInventory(id);
        return  ResponseEntity.ok().build();

    }


}
