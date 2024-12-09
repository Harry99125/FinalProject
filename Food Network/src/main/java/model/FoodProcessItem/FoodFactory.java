/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.FoodProcessItem;

/**
 *
 * @author Nilay
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import service.FarmerService;

import java.util.ArrayList;

public class FoodFactory {

    private ObjectId factoryId;
    private String factoryName;
    private String factoryLocation;
    private String factoryContact;
    private String factoryEmail;
    private ProductDirectory productDirectory;
    private String factoryAdminId;
    private String factoryManagerName;

    public FoodFactory(String factoryName, String factoryAdminId, String factoryLocation, String factoryContact, String factoryEmail) {
        this.factoryName = factoryName;
        this.factoryLocation = factoryLocation;
        this.factoryContact = factoryContact;
        this.factoryEmail = factoryEmail;
        this.factoryAdminId = factoryAdminId;
        this.productDirectory = new ProductDirectory();
    }

    public FoodFactory(Document factoryDoc, Document userLogin) {
        this.factoryId = factoryDoc.getObjectId("_id");
        this.factoryName = factoryDoc.getString("foodprocessorName");
        this.factoryLocation = factoryDoc.getString("factoryAddress");
        this.factoryContact = factoryDoc.getString("factoryContact");
        this.factoryEmail = factoryDoc.getString("factoryEmail");
        this.factoryAdminId = userLogin.getString("username");
        this.productDirectory = new ProductDirectory();
    }

    // Add a product to the factory's product directory
    public Product createProduct(String productName, ObjectId productId, String productDescription, 
                                 double productPrice, int productQuantity, String productCategory) {
        Product prod = productDirectory.findProduct(productName);
        if (prod != null) {
            System.out.println(productName + " already exists in the factory");
            return prod;
        }
        prod = productDirectory.addProduct(productName, productId, productDescription, productPrice, productQuantity, productCategory);
        return prod;
    }

    public void updateProductQuantity(int quantity, Product product) {
        Product prod = productDirectory.findProduct(product.getProductName());
        if (prod != null) {
            prod.updateQuantity(quantity);
            System.out.println("Product quantity updated.");
        } else {
            System.out.println("Product does not exist in the factory.");
        }
    }

    public ProductDirectory getProductsByCategory(String category) {
        ProductDirectory pd = new ProductDirectory();
        for (Product prod : productDirectory.getProductList()) {
            if (prod.getProductCategory().equalsIgnoreCase(category)) {
                pd.addProduct(prod);
            }
        }
        return pd;
    }

    public ArrayList<String> getCategoryList() {
        return productDirectory.getCategoryList();
    }

    public boolean isMatch(String factoryName) {
        return this.factoryName.equalsIgnoreCase(factoryName);
    }

    public boolean authenticateAdmin(String adminUserName) {
        return this.factoryAdminId.equals(adminUserName);
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public ObjectId getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(ObjectId factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    public String getFactoryContact() {
        return factoryContact;
    }

    public void setFactoryContact(String factoryContact) {
        this.factoryContact = factoryContact;
    }

    public String getFactoryEmail() {
        return factoryEmail;
    }

    public void setFactoryEmail(String factoryEmail) {
        this.factoryEmail = factoryEmail;
    }

    public String getFactoryAdminId() {
        return factoryAdminId;
    }

    public void setFactoryAdminId(String factoryAdminId) {
        this.factoryAdminId = factoryAdminId;
    }

    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ProductDirectory productDirectory) {
        this.productDirectory = productDirectory;
    }

    public Document toDocument() {
        return new Document("factoryName", factoryName)
                .append("factoryLocation", factoryLocation)
                .append("factoryContact", factoryContact)
                .append("factoryEmail", factoryEmail)
                .append("factoryAdminId", factoryAdminId);
    }

    @Override
    public String toString() {
        return factoryName;
    }
}

