package model.TrainingCenter;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import database.CRUDOperations;
import database.Connection;
import org.bson.Document;
import org.bson.types.ObjectId;
import service.TrainingCenterService;

public class TrainingCenter {

    private ObjectId trainingCenterId;
    private String trainingCenterName;
    private String trainingCenterType;
    private String trainingCenterDescription;
    private String trainingCenterLocation;
    private String trainingCenterContact;
    private String trainingCenterEmail;
    private String trainingCenterAdminId;
    private String trainingCenterMangerName;
    private TrainingCenterService trainingCenterService;
    CRUDOperations crud = new CRUDOperations();
    private CourseDirectory courseDirectory;

    public TrainingCenter(String name, String contactPerson, String address, String phone, String email, String adminId, Document userLogin) {
        this.trainingCenterName = name;
        this.trainingCenterContact = contactPerson;
        this.trainingCenterLocation = address;
        this.trainingCenterEmail = email;
        this.courseDirectory = new CourseDirectory();
        this.trainingCenterAdminId = adminId;
        this.trainingCenterMangerName = userLogin.getString("name");
    }

    public TrainingCenter(Document organization, Document userLogin) {
        this.trainingCenterId = organization.getObjectId("_id");
        this.trainingCenterName = organization.getString("trainingcenterName");
        this.trainingCenterLocation = organization.getString("trainingcenterLocation");
        this.trainingCenterContact = organization.getString("trainingcenterContact");
        this.trainingCenterEmail = organization.getString("trainingcenterEmail");
        this.courseDirectory = new CourseDirectory();
        this.trainingCenterAdminId = organization.getString("trainingcenterAdminId");
        this.trainingCenterMangerName = userLogin.getString("name");
    }

    public ObjectId getTrainingCenterId() {
        return trainingCenterId;
    }

    public CourseDirectory getCourseDirectory() {
        return courseDirectory;
    }

    public Course addCourse(String courseName, String courseNumber, String courseDomain,
            String courseDuration, List<String> courseInstructors, CourseStatus courseStatus) {
        return getCourseDirectory().addNewCourse(courseName, courseNumber, courseDomain, courseDuration, courseInstructors, courseStatus);
    }

    public String getTrainingCenterName() {
        return trainingCenterName;
    }

    public void setTrainingCenterName(String trainingCenterName) {
        this.trainingCenterName = trainingCenterName;
    }

    public String getTrainingCenterType() {
        return trainingCenterType;
    }

    public void setTrainingCenterType(String trainingCenterType) {
        this.trainingCenterType = trainingCenterType;
    }

    public String getTrainingCenterDescription() {
        return trainingCenterDescription;
    }

    public void setTrainingCenterDescription(String trainingCenterDescription) {
        this.trainingCenterDescription = trainingCenterDescription;
    }

    public String getTrainingCenterLocation() {
        return trainingCenterLocation;
    }

    public void setTrainingCenterLocation(String trainingCenterLocation) {
        this.trainingCenterLocation = trainingCenterLocation;
    }

    public String getTrainingCenterContact() {
        return trainingCenterContact;
    }

    public void setTrainingCenterContact(String trainingCenterContact) {
        this.trainingCenterContact = trainingCenterContact;
    }

    public String getTrainingCenterEmail() {
        return trainingCenterEmail;
    }

    public void setTrainingCenterEmail(String trainingCenterEmail) {
        this.trainingCenterEmail = trainingCenterEmail;
    }

    public String getTrainingCenterManagerName() {
        return trainingCenterMangerName;
    }

    public void setTrainingCenterManagerName(String trainingCenterManagerName) {
        this.trainingCenterMangerName = trainingCenterManagerName;
    }

    public void updateTrainingCenter(TrainingCenter trainingcenter, MongoDatabase database) {
        trainingCenterService.updateTrainingCenter(trainingcenter, database);
    }

    public void setTrainingCenterAddress(String text) {
        this.trainingCenterLocation = trainingCenterLocation;
    }

}
