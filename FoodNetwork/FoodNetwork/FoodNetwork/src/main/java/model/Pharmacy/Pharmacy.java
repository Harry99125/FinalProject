package model.Pharmacy;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import service.PharmacyService;

public class Pharmacy {

    private ObjectId pharmacyId;
    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyContact;
    private String pharmacyEmail;
    private MedicineDirectory medicineDirectory;
    private String pharmacyAdminId;

    PharmacyService pharmacyService = new PharmacyService();

    public Pharmacy(String PharmacyName, String pharmacyAdminId, String pharmacyAddress, String pharmacyContact, String pharmacyEmail) {
        this.pharmacyName = PharmacyName;
        this.medicineDirectory = new MedicineDirectory();
        this.pharmacyAdminId = pharmacyAdminId;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyContact = pharmacyContact;
        this.pharmacyEmail = pharmacyEmail;
    }

    public Pharmacy(Document organization, Document userLogin) {
        this.pharmacyId = organization.getObjectId("_id");
        this.pharmacyName = organization.getString("pharmacyName");
        this.pharmacyAddress = organization.getString("pharmacyAddress");
        this.pharmacyContact = organization.getString("pharmacyContact");
        this.pharmacyEmail = organization.getString("pharmacyEmail");
        this.medicineDirectory = new MedicineDirectory();
        this.pharmacyAdminId = userLogin.getString("name");
    }

    private Medicine createMedicine(String medicineName, ObjectId medicineID, String medicineComposition,
            String medicinePrice, int medicineQuantity, String medicineDescription, String medicineCategory,
            String medicineExpiryDate, String medicineManufactureDate, String medicineUsage) {
        Medicine med = medicineDirectory.findMedicine(medicineName);
        if (med != null) {
            System.out.println(med + "medicine already exists");
        }
        med = medicineDirectory.addMedicine(medicineName, medicineID, medicineComposition,
                medicinePrice, medicineQuantity, medicineDescription, medicineCategory,
                medicineExpiryDate, medicineManufactureDate, medicineUsage);
        return med;
    }

    private void updateQuantity(int quantity, Medicine medicine) {

        if (medicineDirectory.findMedicine(medicine.getMedicineName()) != null) {
            medicine.updateQuantity(quantity);
            System.out.println("medicine quantity updated");
            return;
        }
        System.out.println("Medicine does not exists");
    }

    private MedicineDirectory getMedicineList() {
        return medicineDirectory;
    }

    private MedicineDirectory getMedicinesByCategory(String category) {
        MedicineDirectory md = new MedicineDirectory();
        for (Medicine med : medicineDirectory.getMedicineList()) {
            if (med.getMedicineCategory().equalsIgnoreCase(category)) {
                md.addMedicine(med);
            }
        }
        return md;
    }
//    get list of  all category

    private ArrayList<String> getCategoryList() {
        return medicineDirectory.getCategoryList();
    }

    public boolean isMatch(String pharmacyName) {
        return this.pharmacyName.equalsIgnoreCase(pharmacyName);
    }

    public boolean authenticateAdmin(String adminUserName) {
        if (isMatch(adminUserName)) {
            return true;
        }
        return false;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public ObjectId getId() {
        return pharmacyId;
    }

    public void setId(ObjectId id) {
        this.pharmacyId = id;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyContact() {
        return pharmacyContact;
    }

    public void setPharmacyContact(String pharmacyContact) {
        this.pharmacyContact = pharmacyContact;
    }

    public String getPharmacyEmail() {
        return pharmacyEmail;
    }

    public void setPharmacyEmail(String pharmacyEmail) {
        this.pharmacyEmail = pharmacyEmail;
    }

    public MedicineDirectory getMedicineDirectory() {
        return medicineDirectory;
    }

    public void setMedicineDirectory(MedicineDirectory medicineDirectory) {
        this.medicineDirectory = medicineDirectory;
    }

    public String getPharmacyAdminId() {
        return pharmacyAdminId;
    }

    public void setPharmacyAdminId(String pharmacyAdminId) {
        this.pharmacyAdminId = pharmacyAdminId;
    }

    @Override
    public String toString() {
        return pharmacyName;
    }

    public String getPharmacyManagerName() {
        return pharmacyAdminId;
    }

    public void updatePharmacy(Pharmacy pharmacy, MongoDatabase database) {
        pharmacyService.updatePharmacy(pharmacy, database);
    }
    
    public void updatePharmacyMedicine(int stockQuantity, String pharmacyPrice, ObjectId id, MongoCollection<Document> collection) {
        pharmacyService.updatePharmacyMedicine( stockQuantity, pharmacyPrice, id, collection);
    }

    public Document toDocument() {
        return new Document("pharmacyName", pharmacyName)
                .append("pharmacyAddress", pharmacyAddress)
                .append("pharmacyContact", pharmacyContact)
                .append("pharmacyEmail", pharmacyEmail)
                .append("pharmacyAdminId", pharmacyAdminId);
    }
}
