package springsecuritycouse1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    public Inventory addInventory(Inventory inventory){
        return  inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllItems(){
        return  inventoryRepository.findAll();
    }


    public  Inventory getInventoryId(Long id){
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory  updateInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public  void deleteInventory(Long id){
        inventoryRepository.deleteById(id);
    }



}
