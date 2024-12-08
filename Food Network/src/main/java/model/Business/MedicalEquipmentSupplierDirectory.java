package model.Business;

import model.MedicalEquipment.MedicalEquipmentSupplier;

import java.util.ArrayList;
import model.MedicalEquipment.MedicalEquipment;
import org.bson.types.ObjectId;

public class MedicalEquipmentSupplierDirectory {
    private ArrayList<MedicalEquipmentSupplier> medicalEquipmentSupplierList;

    public MedicalEquipmentSupplierDirectory() {
        medicalEquipmentSupplierList = new ArrayList();
    }

}
