package model.Personnel;

import java.util.ArrayList;
import org.bson.types.ObjectId;

public class DoctorDirectory {

    private ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        doctorList = new ArrayList();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

//    public Doctor addDoctor(String doctorName, String doctorSpecialization, Boolean isInstructor, Boolean isResidentDoctor) {
//        Doctor doc = new Doctor(doctorName, doctorSpecialization, isInstructor, isResidentDoctor);
//        doctorList.add(doc);
//        return doc;
//    }

    public Doctor getDoctor(String inputName) {
        for (Doctor d : doctorList) {
            if (d.getDoctorName().toString().equalsIgnoreCase(inputName)) {
                return d;
            }
        }
        return null;
    }

    public Doctor assignInstructor(String doctorName) {
        Doctor doc = getDoctor(doctorName);
        doc.setIsInstructor(true);
        return doc;
    }

    public void addPatient(Patient p, Doctor d) {
        d.addNewPatient(p);
    }


    public void addDoctor(Doctor d) {
        doctorList.add(d);
    }
}
