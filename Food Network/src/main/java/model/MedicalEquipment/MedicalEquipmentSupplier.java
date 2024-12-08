package model.MedicalEquipment;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import service.MedicalEquipmentService;

import java.util.ArrayList;

public class MedicalEquipmentSupplier {

    private ObjectId id;
    private String supplierName;
    private String supplierAddress;
    private String supplierContact;
    private String supplierEmail;
    private ArrayList<MedicalEquipment> medicalEquipmentList;
    private String medicalEquipmentManagerId;
    MedicalEquipmentService medicalEquipmentService = new MedicalEquipmentService();

    public MedicalEquipmentSupplier(Document organization, Document userLogin) {
        this.id = organization.getObjectId("_id");
        System.out.println("Supplier id: "+this.id);
        this.supplierName = organization.getString("supplierName");
        this.supplierAddress = organization.getString("supplierAddress");
        this.supplierContact = organization.getString("supplierContact");
        this.supplierEmail = organization.getString("supplierEmail");
        this.medicalEquipmentManagerId = userLogin.getString("name");
    }

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

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public ArrayList<MedicalEquipment> getMedicalEquipmentList() {
        return medicalEquipmentList;
    }

    public void setMedicalEquipmentList(ArrayList<MedicalEquipment> medicalEquipmentList) {
        this.medicalEquipmentList = medicalEquipmentList;
    }

    public String getMedicalEquipmentManagerId() {
        return medicalEquipmentManagerId;
    }

    public void setMedicalEquipmentManagerId(String medicalEquipmentManagerId) {
        this.medicalEquipmentManagerId = medicalEquipmentManagerId;
    }

    public void updateSupplierDetails(MedicalEquipmentSupplier medicalEquipmentSupplier, MongoDatabase database) {
        System.out.println("Updating supplier details "+medicalEquipmentSupplier.getId());
        medicalEquipmentService.updateMedicalEquipmentSupplier(medicalEquipmentSupplier, database);
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
}


