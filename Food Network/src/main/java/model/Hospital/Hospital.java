package model.Hospital;

import com.mongodb.client.MongoDatabase;
import model.Personnel.*;
import model.TrainingCenter.TrainingCenter;

import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;
import service.HospitalService;

public class Hospital {
    private ObjectId hospitalId;
    private String hospitalAdminId;
    private String hospitalName;
    private String hospitalLocation;
    private String hospitalContact;
    private String hospitalEmail;
    private String hospitalManagerName;
    private HospitalService hospitalService = new HospitalService();
    
    public Hospital(Document organization,  Document userLogin) {
        this.hospitalId = organization.getObjectId("_id");
        this.hospitalAdminId = organization.getString("hospitalAdminId");
        this.hospitalName = organization.getString("hospitalName");
        this.hospitalLocation = organization.getString("hospitalLocation");
        this.hospitalContact = organization.getString("hospitalContact");
        this.hospitalEmail = organization.getString("hospitalEmail");
        this.hospitalManagerName = organization.getString("hospitalManagerName");
    }

    public ObjectId getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(ObjectId hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalAdminId() {
        return hospitalAdminId;
    }

    public void setHospitalAdminId(String hospitalAdminId) {
        this.hospitalAdminId = hospitalAdminId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public String getHospitalContact() {
        return hospitalContact;
    }

    public void setHospitalContact(String hospitalContact) {
        this.hospitalContact = hospitalContact;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getHospitalManagerName() {
        return hospitalManagerName;
    }

    public void setHospitalManagerName(String hospitalManagerName) {
        this.hospitalManagerName = hospitalManagerName;
    }


    public boolean isMatch(String name) {
        return getName().equals(name);
    }

    private String getName() {
        return hospitalName;
    }


    public String createHospitalAdmin(ObjectId hospitalAdminName) {
        if (hospitalAdminId != null) {
            System.out.println("Hospital Admin already exists");
            return null;
        }
        return hospitalAdminId;
    }

    public String getHospitalAdmin() {
        return hospitalAdminId;
    }

   public Document toDocument() {
        return new Document("hospitalName", hospitalName)
                .append("hospitalLocation", hospitalLocation)
                .append("hospitalContact", hospitalContact)
                .append("hospitalEmail", hospitalEmail)
                .append("hospitalAdminId", hospitalAdminId);
    }
   
   public void updateHospital(Hospital hospital, MongoDatabase database) {
        hospitalService.updateHospital(hospital, database);
    }
    
}
