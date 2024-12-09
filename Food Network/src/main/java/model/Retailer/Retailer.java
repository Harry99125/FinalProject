/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nilay
 */
package model.Retailer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Retailer {

    private ObjectId retailerId;
    private String retailerName;
    private String retailerAddress;
    private String retailerContact;
    private String retailerEmail;
    private String retailerAdminId;
    private String managerName;

    public Retailer(String retailerName, String retailerAdminId, String retailerAddress, String retailerContact, String retailerEmail, String managerName) {
        this.retailerName = retailerName;
        this.retailerAddress = retailerAddress;
        this.retailerContact = retailerContact;
        this.retailerEmail = retailerEmail;
        this.retailerAdminId = retailerAdminId;
        this.managerName = managerName;
    }

    public Retailer(Document organization, Document userLogin) {
        this.retailerId = organization.getObjectId("_id");
        this.retailerName = organization.getString("retailerName");
        this.retailerAddress = organization.getString("RetailerAddress");
        this.retailerContact = organization.getString("RetailerContact");
        this.retailerEmail = organization.getString("RetailerEmail");
        this.retailerAdminId = userLogin.getString("username");
        this.managerName = organization.getString("managerName");
    }

    public Retailer(Document retailerDocument) {
        this.retailerId = retailerDocument.getObjectId("_id");
        this.retailerName = retailerDocument.getString("retailerName");
        this.retailerAddress = retailerDocument.getString("RetailerAddress");
        this.retailerContact = retailerDocument.getString("RetailerContact");
        this.retailerEmail = retailerDocument.getString("RetailerEmail");
        this.retailerAdminId = retailerDocument.getString("RetailerAdminId");
        this.managerName = retailerDocument.getString("managerName");
    }

    // Update retailer details in the database
    public void updateRetailer(Retailer retailer, MongoDatabase database) {
        MongoCollection<Document> retailerCollection = database.getCollection("Retailer");
        Document updatedRetailer = new Document("RetailerName", retailer.getRetailerName())
                .append("RetailerAddress", retailer.getRetailerAddress())
                .append("RetailerContact", retailer.getRetailerContact())
                .append("RetailerEmail", retailer.getRetailerEmail())
                .append("RetailerAdminId", retailer.getRetailerAdminId())
                .append("managerName", retailer.getManagerName());
        retailerCollection.updateOne(new Document("_id", retailer.getId()), new Document("$set", updatedRetailer));
    }

    // Convert Retailer object to MongoDB Document
    public Document toDocument() {
        return new Document("RetailerName", retailerName)
                .append("RetailerAddress", retailerAddress)
                .append("RetailerContact", retailerContact)
                .append("RetailerEmail", retailerEmail)
                .append("RetailerAdminId", retailerAdminId)
                .append("managerName", managerName);
    }

    // Getters and Setters
    public ObjectId getId() {
        return retailerId;
    }

    public void setId(ObjectId retailerId) {
        this.retailerId = retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getRetailerAddress() {
        return retailerAddress;
    }

    public void setRetailerAddress(String retailerAddress) {
        this.retailerAddress = retailerAddress;
    }

    public String getRetailerContact() {
        return retailerContact;
    }

    public void setRetailerContact(String retailerContact) {
        this.retailerContact = retailerContact;
    }

    public String getRetailerEmail() {
        return retailerEmail;
    }

    public void setRetailerEmail(String retailerEmail) {
        this.retailerEmail = retailerEmail;
    }

    public String getRetailerAdminId() {
        return retailerAdminId;
    }

    public void setRetailerAdminId(String retailerAdminId) {
        this.retailerAdminId = retailerAdminId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return retailerName;
    }

    public String getRetailerManagerName() {
        return managerName;
    }
}
