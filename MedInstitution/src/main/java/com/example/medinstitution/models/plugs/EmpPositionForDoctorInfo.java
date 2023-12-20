package com.example.medinstitution.models.plugs;
import com.example.medinstitution.models.Patient;

import java.io.IOException;

public class EmpPositionForDoctorInfo {

    public Long id_registration;
    public String patientFIO;
    public String date;
    public String time;

    public EmpPositionForDoctorInfo(Patient patient, String date, String time, Long idReg) throws IOException {
        if(patient != null)
            patientFIO = patient.getSecond_Patient()+" "+patient.getFirst_Patient()+" "+patient.getMiddle_Patient();
        else patientFIO = "Не занято";
        this.date = date;
        this.time = time;
        this.id_registration = idReg;
    }
}
