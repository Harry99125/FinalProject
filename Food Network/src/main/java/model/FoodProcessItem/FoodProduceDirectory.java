package model.FoodProcessItem;

import model.Farmer.*;
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class FoodProduceDirectory {
    
    ArrayList<FoodProcessorProduce> produceList;

    public FoodProduceDirectory() {
        produceList = new ArrayList();
    }

    public ArrayList<FoodProcessorProduce> getProduceList() {
        return produceList;
    }

    public FoodProcessorProduce addProduce(String produceName, ObjectId produceID, String produceType,
                              String producePrice, int produceQuantity, String produceDescription, String produceCategory,
                              String produceExpiryDate, String produceHarvestDate, String produceUsage) {

        FoodProcessorProduce prod = new FoodProcessorProduce(produceName, produceID, produceType,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        produceList.add(prod);
        return prod;
    }

    public FoodProcessorProduce findProduce(String produceName) {
        for (FoodProcessorProduce prod : produceList) {
            if (prod.toString().equalsIgnoreCase(produceName)) {
                return prod;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> produceCatList = new ArrayList<>();
        for (FoodProcessorProduce prod : produceList) {
            if (!produceCatList.contains(prod.getProduceCategory())) {
                produceCatList.add(prod.getProduceCategory());
            }
        }
        return produceCatList;
    }

    public void addProduce(FoodProcessorProduce prod) {
        produceList.add(prod);
    }

}
