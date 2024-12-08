package model.Business;

import model.FoodProcessItem.FoodProcessItemDirectory;

import java.util.ArrayList;
import model.FoodProcessItem.FoodProcessItem;
import org.bson.types.ObjectId;

public class MedicalEquipmentSupplierDirectory {
    private ArrayList<FoodProcessItemDirectory> medicalEquipmentSupplierList;

    public MedicalEquipmentSupplierDirectory() {
        medicalEquipmentSupplierList = new ArrayList();
    }

}
