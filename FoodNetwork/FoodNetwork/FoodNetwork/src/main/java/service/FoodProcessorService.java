package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.FoodProcessItem.FoodProcessItemDirectory;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FoodProcessorService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("FoodProcessor");
    CRUDOperations crud = new CRUDOperations();
    public void updatefoodProcessor(FoodProcessItemDirectory fd, MongoDatabase database) {
        CRUDOperations crud = new CRUDOperations();
        crud.updateStringById(fd.getId(), "factoryContact", fd.getSupplierContact(), collection);
        crud.updateStringById(fd.getId(), "factoryAddress", fd.getSupplierAddress(), collection);
        crud.updateStringById(fd.getId(), "factoryEmail", fd.getSupplierEmail(), collection);
          crud.updateStringById(fd.getId(), "foodprocessorName", fd.getSupplierName(), collection);
       
        
    }
    public void readIncomingData(FoodProcessItemDirectory fd, MongoDatabase database) {
        ObjectId id= fd.getId();
        System.out.println("+++++++++"+ id.toString());
        
          Document query = new Document("foodprocessorAdminId",id.toString() );
        Document firstDocument= collection.find(query).first();
        fd.setSupplierContact(firstDocument.get("factoryContact").toString());
        fd.setSupplierAddress(firstDocument.get("factoryAddress").toString());
        fd.setSupplierEmail(firstDocument.get("factoryEmail").toString());
        fd.setSupplierName(firstDocument.get("foodprocessorName").toString());
 
    }
}
