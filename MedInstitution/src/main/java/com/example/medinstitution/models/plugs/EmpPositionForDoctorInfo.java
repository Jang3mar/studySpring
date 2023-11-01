package com.example.medinstitution.models.plugs;
import com.example.medinstitution.models.Patient;

import java.io.IOException;

public class EmpPositionForDoctorInfo {
    public String patientFIO;
    public String date;
    public String time;

    public EmpPositionForDoctorInfo(Patient patient, String date, String time) throws IOException {
        if(patient != null)
            patientFIO = patient.getSecond_Patient()+" "+patient.getFirst_Patient()+" "+patient.getMiddle_Patient();
        else patientFIO = "Не занято";
        this.date = date;
        this.time = time;
    }
}
