package model.Business;

import model.TrainingCenter.TrainingCenter;

import java.util.ArrayList;
import org.bson.Document;

public class TrainingCenterDirectory {

    private ArrayList<TrainingCenter> trainingCenterList;

    public TrainingCenterDirectory() {
        trainingCenterList = new ArrayList();
    }

    public TrainingCenter createTrainingCenter(String name, String contactPerson, String address, String phone, String email, String adminId, Document userLogin) {
        TrainingCenter trainingCenter = new TrainingCenter(name, contactPerson, address, phone, email, adminId, userLogin);
        trainingCenterList.add(trainingCenter);
        return trainingCenter;
    }
    
}
