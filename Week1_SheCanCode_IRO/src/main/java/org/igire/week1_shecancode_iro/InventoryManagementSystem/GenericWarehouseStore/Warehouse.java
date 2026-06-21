package org.igire.week1_shecancode_iro.InventoryManagementSystem.GenericWarehouseStore;

import java.util.ArrayList;
import java.util.List;

public class Warehouse <T extends Product> {
    private List<T> items = new ArrayList<>();;


    public void addItem(T item){
        items.add(item);
    }

    public void removeItem(String id){
        items.removeIf(item -> id.equals(item.getId()));
    }

    public List<T> findByCategory(String cat){
        List<T> found = new ArrayList<>();
        for (T item: items){
            if (item.getCategory().equalsIgnoreCase(cat)){
                found.add(item);
            }
        }
        return found;
    }

}

