package model.MedicalEquipment;


import org.bson.types.ObjectId;

public class MedicalEquipment {

    private ObjectId equipmentID;
    private String equipmentName;
    private String equipmentType;
    private String equipmentDescription;
    private int equipmentPurpose;
    
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getEquipmentPurpose() {
        return equipmentPurpose;
    }

    public void setEquipmentPurpose(int equipmentPurpose) {
        this.equipmentPurpose = equipmentPurpose;
    }
    
    
}