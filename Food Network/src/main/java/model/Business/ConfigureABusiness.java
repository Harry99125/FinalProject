package model.Business;

import database.DataBaseConnection;
import model.Hospital.Hospital;
import model.FoodProcessItem.FoodProcessItemDirectory;
import model.Personnel.Researcher;
import model.Pharmacy.Pharmacy;
import model.TrainingCenter.TrainingCenter;

public class ConfigureABusiness {
    public static Business initialize() {
        Business business = new Business();
        
      
//        conenct to database
        DataBaseConnection dbConnection = DataBaseConnection.connectToDatabase();
//        add new user
//        business.addUser("Jane","password",dbConnection);

//TODO always check if person exists before creating
        //Adminstrator admin = business.createAdminstrator("Jane");
        //Hospital hospital = business.getHospitaldirectory().createHospital("Heleena Hospital", "Heleena");
        //Pharmacy pharmacy = business.getPharmacydirectory().createPharmacy("Paradise Pharmacy", "prashad", "5000 Paradise Road", "1234567890", "paradise@mail");
        //TrainingCenter trainingCenter = business.getTrainingcenterdirectory().createTrainingCenter("Training Center", "Trina", "90 Tramway Road", "1234567890", "trina@mail");
        //MedicalEquipmentSupplier medicalEquipmentSupplier = business.getMedicalequipmentsupplierdirectory().createMedicalEquipmentSupplier("Medical Equipment Supplier", "Molly", "100 Medical Equipment Road", "1234567890", "molly@mail");
        //Researcher researcher = business.getResearchdirectory().createResearcher( "Rita");
        return business;
    }
}
