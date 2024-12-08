package model.FoodProcessItem;

import model.Farmer.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FoodProcessorProduce {
    private String produceName;
    private ObjectId produceID;
    private String produceType;
    private String producePrice;
    private int produceQuantity;
    private String produceDescription;
    private String produceCategory;
    private String produceUsage;

    public FoodProcessorProduce(String produceName, ObjectId produceID, String produceType,
                   String producePrice, int produceQuantity, String produceDescription,
                   String produceCategory, String produceExpiryDate, String produceHarvestDate,
                   String produceUsage) {
        this.produceName = produceName;
        this.produceID = produceID;
        this.producePrice = producePrice;
        this.produceQuantity = produceQuantity;
        this.produceDescription = produceDescription;
        this.produceCategory = produceCategory;
        this.produceUsage = produceUsage;
    }

    public FoodProcessorProduce(Document produceDoc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateQuantity(int quantity) {
        produceQuantity = quantity;
    }

    public String getProduceCategory() {
        return produceCategory;
    }

    public void setProduceCategory(String produceCategory) {
        this.produceCategory = produceCategory;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public ObjectId getProduceID() {
        return produceID;
    }

    public void setProduceID(ObjectId produceID) {
        this.produceID = produceID;
    }

    public String getProduceType() {
        return produceType;
    }

    public void setProduceType(String produceType) {
        this.produceType = produceType;
    }

    public String getProducePrice() {
        return producePrice;
    }

    public void setProducePrice(String producePrice) {
        this.producePrice = producePrice;
    }

    public int getProduceQuantity() {
        return produceQuantity;
    }

    public void setProduceQuantity(int produceQuantity) {
        this.produceQuantity = produceQuantity;
    }

    public String getProduceDescription() {
        return produceDescription;
    }

    public void setProduceDescription(String produceDescription) {
        this.produceDescription = produceDescription;
    }

    public String getProduceUsage() {
        return produceUsage;
    }

    public void setProduceUsage(String produceUsage) {
        this.produceUsage = produceUsage;
    }

    @Override
    public String toString() {
        return produceName;
    }
}
