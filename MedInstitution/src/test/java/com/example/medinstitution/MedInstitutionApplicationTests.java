package com.example.medinstitution;

import com.example.medinstitution.models.Patient;
import com.example.medinstitution.utilities.APIInterface;
import com.example.medinstitution.utilities.RequestBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MedInstitutionApplicationTests {

    @Test
    void contextLoads() {

    }

//    @Test
//    void registrationUsers() throws IOException {
//        Patient patient = new Patient(0l,
//                "Павлов",
//                "Павел",
//                "Павлович",
//                "Pavel!123",
//                "Qwert!123",
//                "26.07.1985");
//        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
//        Call<Patient> newPatient = api.registerPatient(patient);
//        String status = "";
//        if(newPatient.execute().isSuccessful()){
//            status = HttpStatus.OK.toString();
//        }
//        assertEquals("200 OK", status);
//    }
}
