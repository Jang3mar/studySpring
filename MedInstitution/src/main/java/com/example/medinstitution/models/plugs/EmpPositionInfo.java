package com.example.medinstitution.models.plugs;

import com.example.medinstitution.models.Employee;
import com.example.medinstitution.models.Position_Employee;
import com.example.medinstitution.utilities.APIInterface;
import com.example.medinstitution.utilities.RequestBuilder;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class EmpPositionInfo {
    public String empFIO;
    public String empPositions;

    public EmpPositionInfo(Employee employee) throws IOException {
        empFIO = employee.getSecond_Employee()+" "+employee.getFirst_Employee()+" "+employee.getMiddle_Employee();
        APIInterface api = RequestBuilder.buildRequest().create(APIInterface.class);
        List<Position_Employee> empPos = api.getListPosEmp().execute().body();
        empPositions = "";
        for (Position_Employee pe: empPos) {
            empPositions += pe.getID_Pos_Emp().getPosition_Name()+",";
        }
        empPositions = empPositions.substring(0, empPositions.length()-1);
    }
}
