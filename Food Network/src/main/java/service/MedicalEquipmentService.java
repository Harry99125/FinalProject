package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDOperations;
import database.Connection;
import model.MedicalEquipment.MedicalEquipmentSupplier;
import org.bson.Document;

public class MedicalEquipmentService {
    MongoDatabase database = new Connection().connectToDatabase();
    MongoCollection<Document> collection = database.getCollection("Supplier");
    CRUDOperations crud = new CRUDOperations();
    public void updateMedicalEquipmentSupplier(MedicalEquipmentSupplier medicalEquipmentSupplier, MongoDatabase database) {
        CRUDOperations crud = new CRUDOperations();
        crud.updateStringById(medicalEquipmentSupplier.getId(), "supplierContact", medicalEquipmentSupplier.getSupplierContact(), collection);
        crud.updateStringById(medicalEquipmentSupplier.getId(), "supplierAddress", medicalEquipmentSupplier.getSupplierAddress(), collection);
        crud.updateStringById(medicalEquipmentSupplier.getId(), "supplierEmail", medicalEquipmentSupplier.getSupplierEmail(), collection);
    }
}
