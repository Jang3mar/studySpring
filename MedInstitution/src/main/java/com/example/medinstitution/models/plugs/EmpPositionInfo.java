package com.example.medinstitution.models.plugs;

import com.example.medinstitution.models.Employee;
import com.example.medinstitution.models.Position_Employee;
import com.example.medinstitution.utilities.APIInterface;
import com.example.medinstitution.utilities.RequestBuilder;

import java.io.IOException;
import java.util.List;

public class EmpPositionInfo {
    public String empFIO;
    public String empPositions;
    public String dateTimeRegistrarion;

    public EmpPositionInfo(Employee employee, String dateTimeRegistrarion) throws IOException {
        empFIO = employee.getSecond_Employee()+" "+employee.getFirst_Employee()+" "+employee.getMiddle_Employee();
        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
        List<Position_Employee> empPos = api.getListPosEmp().execute().body();
        empPos = empPos.stream().filter(ep -> ep.getID_Emp_Pos().getID_Employee() == employee.getID_Employee()).toList();
        empPositions = "";
        for (Position_Employee pe: empPos) {
            empPositions += pe.getID_Pos_Emp().getPosition_Name()+",";
        }
        empPositions = empPositions.substring(0, empPositions.length()-1);
        this.dateTimeRegistrarion = dateTimeRegistrarion;
    }
}
