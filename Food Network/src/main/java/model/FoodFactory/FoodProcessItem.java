<<<<<<<< HEAD:FoodNetwork/FoodNetwork/FoodNetwork/src/main/java/model/FoodProcessItem/FoodProcessItem.java
package model.FoodProcessItem;
========
package model.FoodFactory;
>>>>>>>> NilayRaut:Food Network/src/main/java/model/FoodFactory/FoodProcessItem.java


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

    private ObjectId foodID;
    private String foodName;
    private String foodType;
 
  
    
  
    
}