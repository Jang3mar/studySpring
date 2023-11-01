package com.example.medinstitution.utilities;

import com.example.medinstitution.models.*;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.PropertyKey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface APIInterface {

    @GET("/getPosition")
    public Call<List<Position>> getListPosition();

    @GET("/getEmployee")
    public Call<List<Employee>> getListEmployee();

    @GET("/getPositionEmployee")
    public Call<List<Position_Employee>> getListPosEmp();

    @GET("/getPatient")
    public Call<List<Patient>> getListPatient();

    @GET("/getPosition/{id}")
    public Call<Position> getPositionId(@Path("id") Long id);

    @GET("/getEmployee/{id}")
    public Call<Employee> getEmployeeId(@Path("id") Long id);

    @GET("/getPositionEmployee/{id}")
    public Call<Position_Employee> getPosEmpId(@Path("id") Long id);

    @GET("/getPatient/{id}")
    public Call<Patient> getPatient(@Path("id") Long id);

    @POST("/addPosition")
    public Call<Position> addPosition(@Body Position bodyPosition);

    @POST("/addPositionEmp")
    public Call<Position_Employee> addPosEmp(@Body Position_Employee posEmp);

    @POST("/registerPatient")
    public Call<Patient> registerPatient(@Body Patient patient);

    @GET("/getLogIn")
    public Call<Map<String, Object>> returnLogIn(@Query("login") String login, @Query("password") String password);

    @POST("/updatePosition/{id}")
    public Call<Position> updatePosition(@Path("id") Long id, @Body Position bodyPosition);

    @DELETE("/deletePosition/{id}")
    public Call<Position> deletePosition(@Path("id") Long id);

    @DELETE("/deletePositionEmp/{id}")
    public Call<Position_Employee> deletePosEmp(@Path("id") Long id);

    @DELETE("/deletePatient/{id}")
    public Call<Patient> deletePatient(@Path("id") Long id);

    @GET("/getFreeRegistration")
    public Call<List<Registration>> getRegistrarions();
    @GET("/getRegistration")
    public Call<List<Registration>> getAllRegistrarions();
}
