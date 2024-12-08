package model.FoodProcessItem;






import model.Farmer.Produce;
import org.bson.types.ObjectId;

import org.bson.types.ObjectId;

public class FoodProcessItem {

    public ObjectId getFoodID() {
        return foodID;
    }

    public void setFoodID(ObjectId foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
       private Produce createProduce(String produceName, ObjectId produceID, String produceComposition,
            String producePrice, int produceQuantity, String produceDescription, String produceCategory,
            String produceExpiryDate, String produceHarvestDate, String produceUsage) {
        Produce prod = produceDirectory.findProduce(produceName);
        if (prod != null) {
            System.out.println(prod + " produce already exists");
        }
        prod = produceDirectory.addProduce(produceName, produceID, produceComposition,
                producePrice, produceQuantity, produceDescription, produceCategory,
                produceExpiryDate, produceHarvestDate, produceUsage);
        return prod;
    }

    private void updateQuantity(int quantity, Produce produce) {

        if (produceDirectory.findProduce(produce.getProduceName()) != null) {
            produce.updateQuantity(quantity);
            System.out.println("produce quantity updated");
            return;
        }
        System.out.println("Produce does not exist");
    }

    private ObjectId foodID;
    private String foodName;
    private String foodType;
 
  
    
  
    
}