/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.FoodProcessItem;

/**
 *
 * @author Nilay
 */
import org.bson.Document;
import org.bson.types.ObjectId;

public class Product {
    private String productName;
    private ObjectId productID;
    private String productDescription;
    private String productCategory;
    private Double productPrice;
    private int productQuantity;

    public Product(String productName, ObjectId productID, String productDescription,
                   String productCategory, Double productPrice, int productQuantity) {
        this.productName = productName;
        this.productID = productID;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product(Document productDoc) {
        this.productName = productDoc.getString("productName");
        this.productID = productDoc.getObjectId("_id");
        this.productDescription = productDoc.getString("productDescription");
        this.productCategory = productDoc.getString("productCategory");
        this.productPrice = productDoc.getDouble("productPrice");
        this.productQuantity = productDoc.getInteger("productQuantity");
    }

    public void updateQuantity(int quantity) {
        this.productQuantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ObjectId getProductID() {
        return productID;
    }

    public void setProductID(ObjectId productID) {
        this.productID = productID;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return productName;
    }
}

