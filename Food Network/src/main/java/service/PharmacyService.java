package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.Pharmacy.Pharmacy;
import org.bson.Document;
 import org.bson.types.ObjectId;

public class PharmacyService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("Pharmacy");
    CRUDOperations crud = new CRUDOperations();

    public void updatePharmacy(Pharmacy pharmacy, MongoDatabase database) {
        crud.updateStringById(pharmacy.getId(), "pharmacyAddress", pharmacy.getPharmacyAddress(), collection);
        crud.updateStringById(pharmacy.getId(), "pharmacyContact", pharmacy.getPharmacyContact(), collection);
        crud.updateStringById(pharmacy.getId(), "pharmacyEmail", pharmacy.getPharmacyEmail(), collection);
    }
    
    public void updatePharmacyMedicine(int stockQuantity, String pharmacyPrice, ObjectId id, MongoCollection<Document> collection) {
        crud.updateIntById(id, "stockQuantity", stockQuantity, collection);
        crud.updateStringById(id, "pharmacyPrice", pharmacyPrice, collection);
    }
}
