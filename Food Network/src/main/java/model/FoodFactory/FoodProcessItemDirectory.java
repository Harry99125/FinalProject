package model.FoodFactory;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import service.MedicalEquipmentService;

import java.util.ArrayList;

public class FoodProcessItemDirectory {

    private ObjectId id;
    private String supplierName;
    private String supplierAddress;

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }
    private String supplierContact;
    private String supplierEmail;
    private ArrayList<FoodProcessItem> foodList;
    private String FoodProcessManagerId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public ArrayList<FoodProcessItem> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<FoodProcessItem> foodList) {
        this.foodList = foodList;
    }

    public String getFoodProcessManagerId() {
        return FoodProcessManagerId;
    }

    public void setFoodProcessManagerId(String FoodProcessManagerId) {
        this.FoodProcessManagerId = FoodProcessManagerId;
    }

    public MedicalEquipmentService getMedicalEquipmentService() {
        return medicalEquipmentService;
    }

    public void setMedicalEquipmentService(MedicalEquipmentService medicalEquipmentService) {
        this.medicalEquipmentService = medicalEquipmentService;
    }
    MedicalEquipmentService medicalEquipmentService = new MedicalEquipmentService();

    public FoodProcessItemDirectory(Document organization, Document userLogin) {
        this.id = organization.getObjectId("_id");
        System.out.println("Supplier id: "+this.id);
        this.supplierName = organization.getString("supplierName");
        this.supplierAddress = organization.getString("supplierAddress");
        this.supplierContact = organization.getString("supplierContact");
        this.supplierEmail = organization.getString("supplierEmail");
        this.FoodProcessManagerId = userLogin.getString("name");
    }

  

    public void updateSupplierDetails(FoodProcessItemDirectory medicalEquipmentSupplier, MongoDatabase database) {
        System.out.println("Updating supplier details "+medicalEquipmentSupplier.getId());
//        medicalEquipmentService.updateMedicalEquipmentSupplier(medicalEquipmentSupplier, database);
    }

  
}


