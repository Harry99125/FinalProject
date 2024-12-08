package model.Pharmacy;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class MedicineDirectory {
    
    ArrayList<Medicine> medicineList;

    public MedicineDirectory() {
        medicineList = new ArrayList();
    }

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public Medicine addMedicine(String medicineName, ObjectId medicineID, String medicineComposition,
                                String medicinePrice, int medicineQuantity, String medicineDescription, String medicineCategory,
                                String medicineExpiryDate, String medicineManufactureDate, String medicineUsage) {

        Medicine med = new Medicine(medicineName, medicineID, medicineComposition,
                medicinePrice, medicineQuantity, medicineDescription, medicineCategory,
                medicineExpiryDate, medicineManufactureDate, medicineUsage);
        medicineList.add(med);
        return med;
    }

    public Medicine findMedicine(String medicineName) {
        for (Medicine med : medicineList) {
            if (med.toString().equalsIgnoreCase(medicineName)) {
                return med;
            }
        }
        return null;
    }

    public ArrayList<String> getCategoryList() {
        ArrayList<String> medCatList = new ArrayList<>();
        for (Medicine med : medicineList) {
            if (!medCatList.contains(med.getMedicineCategory())) {
                medCatList.add(med.getMedicineCategory());
            }
        }
        return medCatList;
    }

    public void addMedicine(Medicine med) {
        medicineList.add(med);
    }

}
