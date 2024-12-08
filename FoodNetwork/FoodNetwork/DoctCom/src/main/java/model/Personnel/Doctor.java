package model.Personnel;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Doctor {
    private ObjectId doctorId;
    private String doctorName;
    private String doctorSpecialization;
    private Boolean isInstructor;
    private Boolean isResidentDoctor;
    private String userId;
    private String hospitalId;
    private PatientDirectory patientDirectory;

    public ObjectId getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(ObjectId doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public Boolean getIsInstructor() {
        return isInstructor;
    }

    public void setIsInstructor(Boolean isInstructor) {
        this.isInstructor = isInstructor;
    }

    public Boolean getIsResidentDoctor() {
        return isResidentDoctor;
    }

    public void setIsResidentDoctor(Boolean isResidentDoctor) {
        this.isResidentDoctor = isResidentDoctor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

//    public Doctor(String doctorName, String doctorSpecialization, Boolean isInstructor, Boolean isResidentDoctor, ) {
//        this.doctorSpecialization = doctorSpecialization;
//        patientDirectory = new PatientDirectory();
//        this.doctorName = doctorName;
//        this.isInstructor = isInstructor;
//        this.isResidentDoctor = isResidentDoctor;
//    }
    
    public Doctor(Document organization, Document userLogin) {
        this.doctorId = organization.getObjectId("_id");
        this.doctorName = organization.getString("doctorName");
        this.doctorSpecialization = organization.getString("doctorSpecialization");
        this.isInstructor = organization.getBoolean("isInstructor", false);
        this.isResidentDoctor = organization.getBoolean("isResidentDoctor", false);
        this.userId = organization.getString("userId");
        this.hospitalId = organization.getString("hospitalId");
        patientDirectory = new PatientDirectory();
    }
    
    public Doctor(){
//        this.doctorId = organization.getObjectId("_id");
//        this.doctorName = organization.getString("doctorName");
//        this.doctorSpecialization = organization.getString("doctorSpecialization");
//        this.isInstructor = organization.getBoolean("isInstructor", false);
//        this.isResidentDoctor = organization.getBoolean("isResidentDoctor", false);
//        this.patientDirectory = new PatientDirectory();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setIsInstructor(boolean b) {
        isInstructor = b;
    }

    public void addNewPatient(Patient p) {
        patientDirectory.addPatient(p);
    }

    public String getSpecialization() {
        return doctorSpecialization;
    }
}
