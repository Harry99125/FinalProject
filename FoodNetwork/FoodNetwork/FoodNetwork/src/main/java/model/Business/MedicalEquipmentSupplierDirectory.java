package model.Business;

import model.MedicalEquipment.FoodProcessItemDirectory;

import java.util.ArrayList;
import model.MedicalEquipment.FoodProcessItem;
import org.bson.types.ObjectId;

public class MedicalEquipmentSupplierDirectory {
    private ArrayList<FoodProcessItemDirectory> medicalEquipmentSupplierList;

    public MedicalEquipmentSupplierDirectory() {
        medicalEquipmentSupplierList = new ArrayList();
    }

}
