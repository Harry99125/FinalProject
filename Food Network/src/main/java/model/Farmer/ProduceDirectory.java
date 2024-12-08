package model.Farmer;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class ProduceDirectory {
    
    ArrayList<Produce> produceList;

    public ProduceDirectory() {
        produceList = new ArrayList();
    }

    public ArrayList<Produce> getProduceList() {
        return produceList;
    }

    public Produce addProduce(String produceName, ObjectId produceID, String produceType,
                              String producePrice, int produceQuantity, String produceDescription, String produceCategory,
                              String produceExpiryDate, String produceHarvestDate, String produceUsage) {

        Produce prod = new Produce(produceName, produceID, produceType,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        produceList.add(prod);
        return prod;
    }

    public Produce findProduce(String produceName) {
        for (Produce prod : produceList) {
            if (prod.toString().equalsIgnoreCase(produceName)) {
                return prod;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> produceCatList = new ArrayList<>();
        for (Produce prod : produceList) {
            if (!produceCatList.contains(prod.getProduceCategory())) {
                produceCatList.add(prod.getProduceCategory());
            }
        }
        return produceCatList;
    }

    public void addProduce(Produce prod) {
        produceList.add(prod);
    }

}
