package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.MedicalEquipment.FoodProcessItemDirectory;
import org.bson.Document;

public class FoodProcessorService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("FoodProcessor");
    CRUDOperations crud = new CRUDOperations();
    public void updateMedicalEquipmentSupplier(FoodProcessItemDirectory fd, MongoDatabase database) {
        CRUDOperations crud = new CRUDOperations();
        crud.updateStringById(fd.getId(), "factoryContact", fd.getSupplierContact(), collection);
        crud.updateStringById(fd.getId(), "factoryAddress", fd.getSupplierAddress(), collection);
        crud.updateStringById(fd.getId(), "factoryEmail", fd.getSupplierEmail(), collection);
          crud.updateStringById(fd.getId(), "foodprocessorName", fd.getSupplierName(), collection);
       
        
    }
    public void readIncomingData(FoodProcessItemDirectory fd, MongoDatabase database) {
        Document firstDocument= collection.find().first();
        fd.setSupplierContact(firstDocument.get("factoryContact").toString());
 
    }
}
