package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.Farmer.Farmer;
import org.bson.Document;
 import org.bson.types.ObjectId;

public class FarmerService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("Farmer");
    CRUDOperations crud = new CRUDOperations();

    public void updateFarmer(Farmer farmer, MongoDatabase database) {
        crud.updateStringById(farmer.getId(), "farmlocation", farmer.getFarmerAddress(), collection);
        crud.updateStringById(farmer.getId(), "farmerContact", farmer.getFarmerContact(), collection);
        crud.updateStringById(farmer.getId(), "farmerEmail", farmer.getFarmerEmail(), collection);
    }
    
    public void updateFarmerProduce(int stockQuantity, String farmerPrice, ObjectId id, MongoCollection<Document> collection) {
        crud.updateIntById(id, "stockQuantity", stockQuantity, collection);
        crud.updateStringById(id, "farmerPrice", farmerPrice, collection);
    }
}
