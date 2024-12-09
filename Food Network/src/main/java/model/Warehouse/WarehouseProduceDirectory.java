package model.Warehouse;

import model.Restaurant.*;
import model.Restaurant.Restaurant.*;
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class WarehouseProduceDirectory {
    
    ArrayList<WarehouseProduce> produceList;

    public WarehouseProduceDirectory() {
        produceList = new ArrayList();
    }

    public ArrayList<WarehouseProduce> getProduceList() {
        return produceList;
    }

    public WarehouseProduce addProduce(String produceName, ObjectId produceID, String produceType,
                              String producePrice, int produceQuantity, String produceDescription, String produceCategory,
                              String produceExpiryDate, String produceHarvestDate, String produceUsage) {

        WarehouseProduce prod = new WarehouseProduce(produceName, produceID, produceType,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        produceList.add(prod);
        return prod;
    }

    public WarehouseProduce findProduce(String produceName) {
        for (WarehouseProduce prod : produceList) {
            if (prod.toString().equalsIgnoreCase(produceName)) {
                return prod;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> produceCatList = new ArrayList<>();
        for (WarehouseProduce prod : produceList) {
            if (!produceCatList.contains(prod.getProduceCategory())) {
                produceCatList.add(prod.getProduceCategory());
            }
        }
        return produceCatList;
    }

    public void addProduce(WarehouseProduce prod) {
        produceList.add(prod);
    }

}
