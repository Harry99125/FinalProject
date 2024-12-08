package model.Personnel;

import java.util.ArrayList;

public class PatientDirectory {
    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<>();
    }

    public boolean findPatient(Patient p) {
        for (Patient patient : patientList) {
            if (patient.getName().equalsIgnoreCase(p.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addPatient(Patient p) {
        if (!findPatient(p)) {
            patientList.add(p);
        } else {
            System.out.println("Patient already exists");
        }
    }
}
