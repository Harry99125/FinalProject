package model.Restaurant;

import model.Restaurant.Restaurant.*;
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class RestaurantItemDirectory {
    
    ArrayList<RestaurantItem> produceList;

    public RestaurantItemDirectory() {
        produceList = new ArrayList();
    }

    public ArrayList<RestaurantItem> getProduceList() {
        return produceList;
    }

    public RestaurantItem addProduce(String produceName, ObjectId produceID, String produceType,
                              String producePrice, int produceQuantity, String produceDescription, String produceCategory,
                              String produceExpiryDate, String produceHarvestDate, String produceUsage) {

        RestaurantItem prod = new RestaurantItem(produceName, produceID, produceType,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        produceList.add(prod);
        return prod;
    }

    public RestaurantItem findProduce(String produceName) {
        for (RestaurantItem prod : produceList) {
            if (prod.toString().equalsIgnoreCase(produceName)) {
                return prod;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> produceCatList = new ArrayList<>();
        for (RestaurantItem prod : produceList) {
            if (!produceCatList.contains(prod.getProduceCategory())) {
                produceCatList.add(prod.getProduceCategory());
            }
        }
        return produceCatList;
    }

    public void addProduce(RestaurantItem prod) {
        produceList.add(prod);
    }

}
