package com.example.medinstitution.utilities;

import com.example.medinstitution.models.*;
import com.example.medinstitution.models.plugs.Registation_Info;
import com.example.medinstitution.models.views.read_all_receptions;
import com.example.medinstitution.models.views.read_all_registrations;
import jakarta.annotation.Resource;
import org.apache.juli.logging.Log;
import org.jetbrains.annotations.PropertyKey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import javax.print.Doc;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface APIInterface {

    @GET("/AdminPanel/addBackup")
    public Call<ResponseEntity<String>> getBackup();

    @GET("/SysAdminMenu")
    public Call<List<Loggers>> getLoggers();

    //------------отделение---------------
    @GET("/getDepartmentMed")
    public Call<List<DepartmentMed>> getListDepartment();

    @GET("/getDepartmentMed/{id}")
    public Call<DepartmentMed> getDepartmentId(@Path("id") Long id);

    @POST("/addDepartmentMed")
    public Call<DepartmentMed> addDepartment(@Body DepartmentMed departmentMed);

    @POST("/updateDepartmentMed/{id}")
    public Call<DepartmentMed> updateDepartment(@Path("id") Long id, @Body DepartmentMed departmentMed);

    @DELETE("/deleteDepartmentMed/{id}")
    public Call<DepartmentMed> deleteDepartment(@Path("id") Long id);
    //------------------------------------

    //------------диагнозы---------------
    @GET("/getDiagnosis")
    public Call<List<Diagnosis>> getListDiagnosis();

    @GET("/getDiagnosis/{id}")
    public Call<Diagnosis> getDiagnosisId(@Path("id") Long id);

    @POST("/addDiagnosis")
    public Call<Diagnosis> addDiagnosis(@Body Diagnosis diagnosis);

    @POST("/updateDiagnosis/{id}")
    public Call<Diagnosis> updateDiagnosis(@Path("id") Long id, @Body Diagnosis diagnosis);

    @DELETE("/deleteDiagnosis/{id}")
    public Call<Diagnosis> deleteDiagnosis(@Path("id") Long id);
    //------------------------------------

    //------------документы---------------
    @GET("/getDocument")
    public Call<List<Document>> getDocument();

    @GET("/getDocument/{id}")
    public Call<Document> getDocumentId(@Path("id") Long id);

    @POST("/addDocument")
    public Call<Document> addDocument(@Body Document document);
    //------------------------------------

    //------------образование---------------
    @GET("/getEducation")
    public Call<List<Education>> getListEducation();

    @GET("/getEducation/{id}")
    public Call<Education> getEducationId(@Path("id") Long id);

    @POST("/addEducation")
    public Call<Education> addEducation(@Body Education education);

    @POST("/updateEducation/{id}")
    public Call<Education> updateEducation(@Path("id") Long id, @Body Education education);

    @DELETE("/deleteEducation/{id}")
    public Call<Education> deleteEducation(@Path("id") Long id);
    //------------------------------------

    //------------образование сотрудника---------------
    @GET("/getEducationEmployee")
    public Call<List<Education_Employee>> getListEducationEmployee();

    @GET("/getEducationEmployee/{id}")
    public Call<Education_Employee> getEducationEmployeeId(@Path("id") Long id);

    @POST("/addEducationEmployee")
    public Call<Education_Employee> addEducationEmployee(@Body Education_Employee educationEmployee);

    @POST("/updateEducationEmployee/{id}")
    public Call<Education_Employee> updateEducationEmployee(@Path("id") Long id, @Body Education_Employee educationEmployee);

    @DELETE("/deleteEducationEmployee/{id}")
    public Call<Education_Employee> deleteEducationEmployee(@Path("id") Long id);
    //------------------------------------

    //------------сотрудник---------------
    @GET("/getEmployee")
    public Call<List<Employee>> getListEmployee();

    @GET("/getEmployee/{id}")
    public Call<Employee> getEmployeeId(@Path("id") Long id);

    @POST("/addEmployee")
    public Call<Employee> addEmployee(@Body Employee employee);

    @POST("/updateEmployee/{id}")
    public Call<Employee> updateEmployee(@Path("id") Long id, @Body Employee employee);

    @DELETE("/deleteEmployee/{id}")
    public Call<Employee> deleteEmployee(@Path("id") Long id);
    //------------------------------------

    //------------отделение сотрудника---------------
    @GET("/getEmployeeDepMed")
    public Call<List<Employee_Dep_Med>> getListEmployeeDepMed();

    @GET("/getEmployeeDepMed/{id}")
    public Call<Employee_Dep_Med> getEmployeeDepMedId(@Path("id") Long id);

    @POST("/addEmployeeDepMed")
    public Call<Employee_Dep_Med> addEmployeeDepMed(@Body Employee_Dep_Med employeeDepMed);

    @POST("/updateEmployeeDepMed/{id}")
    public Call<Employee_Dep_Med> updateEmployeeDepMed(@Path("id") Long id, @Body Employee_Dep_Med employeeDepMed);

    @DELETE("/deleteEmployeeDepMed/{id}")
    public Call<Employee_Dep_Med> deleteEmployeeDepMed(@Path("id") Long id);
    //------------------------------------

    //------------справка---------------
    @GET("/getMedReference")
    public Call<List<Med_Reference>> getListMedReference();

    @GET("/getMedReference/{id}")
    public Call<Med_Reference> getMedReferenceId(@Path("id") Long id);

    @POST("/addMedReference")
    public Call<Med_Reference> addMedReference(@Body Med_Reference medReference);

    @POST("/updateMedReference/{id}")
    public Call<Med_Reference> updateMedReference(@Path("id") Long id, @Body Med_Reference medReference);

    @DELETE("/deleteMedReference/{id}")
    public Call<Med_Reference> deleteMedReference(@Path("id") Long id);
    //------------------------------------

    //------------мед карта---------------
    @GET("/getMedicalCard")
    public Call<List<Medical_Card>> getListMedicalCard();

    @GET("/getMedicalCard/{id}")
    public Call<Medical_Card> getMedicalCardId(@Path("id") Long id);

    @POST("/addMedicalCard")
    public Call<Medical_Card> addMedicalCard(@Body Medical_Card medicalCard);

    @POST("/updateMedicalCard/{id}")
    public Call<Medical_Card> updateMedicalCard(@Path("id") Long id, @Body Medical_Card medicalCard);

    @DELETE("/deleteMedicalCard/{id}")
    public Call<Medical_Card> deleteMedicalCard(@Path("id") Long id);
    //------------------------------------

    //------------пациент---------------
    @GET("/getPatient")
    public Call<List<Patient>> getListPatient();

    @GET("/getPatient/{id}")
    public Call<Patient> getPatient(@Path("id") Long id);

    @POST("/registerPatient")
    public Call<Patient> registerPatient(@Body Patient patient);

    @POST("/updatePatient/{id}")
    public Call<Patient> updatePatient(@Path("id") Long id, @Body Patient patient);

    @DELETE("/deletePatient/{id}")
    public Call<Patient> deletePatient(@Path("id") Long id);
    //------------------------------------

    //------------мед карта пациента---------------
    @GET("/getPatientMedCard")
    public Call<List<Patient_Med_Card>> getListPatientMedCard();

    @GET("/getPatientMedCard/{id}")
    public Call<Patient_Med_Card> getPatientMedCardId(@Path("id") Long id);

    @POST("/addPatientMedCard")
    public Call<Patient_Med_Card> addPatientMedCard(@Body Patient_Med_Card patientMedCard);

    @POST("/updatePatientMedCard/{id}")
    public Call<Patient_Med_Card> updatePatientMedCard(@Path("id") Long id, @Body Patient_Med_Card patientMedCard);

    @DELETE("/deletePatientMedCard/{id}")
    public Call<Patient_Med_Card> deletePatientMedCard(@Path("id") Long id);
    //------------------------------------

    //------------должность---------------
    @GET("/getPosition")
    public Call<List<Position>> getListPosition();

    @GET("/getPosition/{id}")
    public Call<Position> getPositionId(@Path("id") Long id);

    @POST("/addPosition")
    public Call<Position> addPosition(@Body Position bodyPosition);

    @POST("/updatePosition/{id}")
    public Call<Position> updatePosition(@Path("id") Long id, @Body Position bodyPosition);

    @DELETE("/deletePosition/{id}")
    public Call<Position> deletePosition(@Path("id") Long id);
    //------------------------------------

    //------------должность сотрудника---------------
    @GET("/getPositionEmployee")
    public Call<List<Position_Employee>> getListPosEmp();

    @GET("/getPositionEmployee/{id}")
    public Call<Position_Employee> getPosEmpId(@Path("id") Long id);

    @POST("/addPositionEmployee")
    public Call<Position_Employee> addPosEmp(@Body Position_Employee posEmp);

    @POST("/updatePositionEmployee/{id}")
    public Call<Position_Employee> updatePositionEmployee(@Path("id") Long id, @Body Position_Employee positionEmployee);

    @DELETE("/deletePositionEmp/{id}")
    public Call<Position_Employee> deletePosEmp(@Path("id") Long id);
    //------------------------------------

    //------------прием---------------
    @GET("/getReception")
    public Call<List<Reception>> getListReception();

    @GET("/getReception/{id}")
    public Call<Reception> getReceptionId(@Path("id") Long id);

    @POST("/addReception")
    public Call<Reception> addReception(@Body Reception reception);

    @POST("/updateReception/{id}")
    public Call<Reception> updateReception(@Path("id") Long id, @Body Reception reception);

    @DELETE("/deleteReception/{id}")
    public Call<Reception> deleteReception(@Path("id") Long id);

    @GET("/getAllReceptionView")
    public Call<List<read_all_receptions>> readAllReceptions();
    //------------------------------------

    //------------запись---------------
    @GET("/getRegistration/{id}")
    public Call<Registration> returnRegistrationId(@Path("id") Long id);

    @POST("/updateRegPatient/{id}")
    public Call<Registration> updateRegPatient(@Path("id") Long id, @Query("idUser") Long idUser);

    @POST("/updateRegistrations/{id}")
    public Call<Registration> updateRegistration(@Path("id") Long id, @Body Registration registration);

    @GET("/getAllRegistrationsView")
    public Call<List<read_all_registrations>> readAllRegistrations();

    @GET("/getRegistration")
    public Call<List<Registration>> getListRegistrarions();

    @GET("/getFreeRegistration")
    public Call<List<Registration>> getRegistrarions();
    //------------------------------------

    @GET("/getLogIn")
    public Call<Map<String, Object>> returnLogIn(@Query("login") String login, @Query("password") String password);






}
