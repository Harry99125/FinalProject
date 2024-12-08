package model.Pharmacy;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Medicine {
    private String medicineName;
    private ObjectId medicineID;
    private String medicineComposition;
    private String medicinePrice;
    private int medicineQuantity;
//    TODO could be added later
    private String medicineDescription;
    private String medicineCategory;
    
    private String medicineUsage;
    
    public Medicine(String medicineName,ObjectId medicineID, String medicineComposition,
     String medicinePrice,int medicineQuantity,String medicineDescription,String medicineCategory,
     String medicineExpiryDate,String medicineManufactureDate,String medicineUsage){
        this.medicineName = medicineName;
        this.medicineID = medicineID;
        this.medicineComposition = medicineComposition;
        this.medicinePrice = medicinePrice;
        this.medicineQuantity = medicineQuantity;
        
        this.medicineDescription = medicineDescription;
        this.medicineCategory = medicineCategory;
       
        
        this.medicineUsage = medicineUsage;
    }

    public Medicine(Document medicineDoc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    add quantity 
    public void updateQuantity(int quantity){
        medicineQuantity = quantity;
    }

    public String getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public ObjectId getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(ObjectId medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineComposition() {
        return medicineComposition;
    }

    public void setMedicineComposition(String medicineComposition) {
        this.medicineComposition = medicineComposition;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public int getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(int medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public String getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(String medicineUsage) {
        this.medicineUsage = medicineUsage;
    }

    @Override
    public String toString(){
        return medicineName;
    }
}
