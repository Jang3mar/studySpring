package com.example.medapi.DAO;

import com.example.medapi.modifies.Crypto;

import javax.management.Query;
import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class AllDAO {
    private static final String url = "jdbc:mysql://localhost:3306/medInst";
    private static final String user = "root";
    private static final String password = "";

    public Connection getConnections(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
        catch (Exception e){}
        return null;
    }

    public static Statement state;
    public <T> void addToTable(String tableName, T object){
        if(tableName.toLowerCase() == "loggers") return;
        Long id = 1l;
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    String fieldValue = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    field[0].setAccessible(true);
                    String querySel = "SELECT " + field[0].getName() + " FROM " + tableName + " ORDER BY " + field[0].getName() + " DESC";
                    Statement stateQuery = connection.createStatement();
                    ResultSet resState = stateQuery.executeQuery(querySel);
                    if (resState.next()){
                        id = resState.getLong(1) + 1l;
                    }
                    field[0].set(object, id);
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + ",";
                        if (fields.getName().toLowerCase().contains("login") ||
                                fields.getName().toLowerCase().contains("password") ||
                                fields.getName().toLowerCase().contains("series_passport") ||
                                fields.getName().toLowerCase().contains("num_passport") ||
                                fields.getName().toLowerCase().contains("num_cmi")) {
                            fieldValue += "'" + Crypto.encrypt(fields.get(object).toString()) + "'" + ",";
                        }
                        else{
                            fieldValue += "'" + fields.get(object) + "'" + ",";
                        }
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    fieldValue = fieldValue.substring(0, fieldValue.length() - 1);
                    Logger.getAnonymousLogger().info(field.length + "");
                    String query = "INSERT INTO " + tableName + " (" + fieldName + ")" + " VALUES (" + fieldValue + ")";
                    Logger.getAnonymousLogger().info(query);
                    querySel = "SELECT id_log FROM Loggers ORDER BY id_log DESC";
                    stateQuery = connection.createStatement();
                    resState = stateQuery.executeQuery(querySel);
                    if (resState.next()){
                        id = resState.getLong(1) + 1l;
                    }
                    state.executeUpdate(query);
                    String queryLog = "INSERT INTO Loggers (id_Log, log_Name, date_Name) values (" + id + ", '" + query.replace('(', ' ').replace(')', ' ').replace(',', ' ').replace('\'', ' ') + "','" + LocalDateTime.now().toString() + "')";
                    state.executeUpdate(queryLog);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        try{
            connection.close();
        } catch (SQLException e){Logger.getAnonymousLogger().warning(e.getMessage());}
    }

    public <T> void updateToTable(String tableName, T object, Long id){
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        if (fields.getName().toLowerCase().contains("login") ||
                                fields.getName().toLowerCase().contains("password") ||
                                fields.getName().toLowerCase().contains("series_passport") ||
                                fields.getName().toLowerCase().contains("num_passport") ||
                                fields.getName().toLowerCase().contains("num_cmi")) {
                            fieldName += fields.getName() + "='" + Crypto.encrypt(fields.get(object).toString()) + "',";
                        }
                        else{
                            fieldName += fields.getName() + "='" + fields.get(object) + "',";
                        }
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    Logger.getAnonymousLogger().info(field.length + "");
                    String query = "UPDATE " +  tableName + " SET " + fieldName + " WHERE " + field[0].getName() + " = " + id;
                    query = query.replace("'null'", "null");
                    Logger.getAnonymousLogger().info(query);
                    state.executeUpdate(query);
                    String querySel = "SELECT id_log FROM Loggers ORDER BY id_log DESC";
                    state = connection.createStatement();
                    ResultSet resState = state.executeQuery(querySel);
                    if (resState.next()){
                        id = resState.getLong(1) + 1l;
                    }
                    state.executeUpdate(query);
                    String queryLog = "INSERT INTO Loggers (id_Log, log_Name, date_Name) values (" + id + ", '" + query.replace('(', ' ').replace(')', ' ').replace(',', ' ').replace('\'', ' ') + "','" + LocalDateTime.now().toString() + "')";
                    state.executeUpdate(queryLog);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        try{
            connection.close();
        } catch (SQLException e){Logger.getAnonymousLogger().warning(e.getMessage());}
    }

    public <T> ResultSet selectToTable(String tableName, Class<?> returnClass){
        Class<?> newClass = returnClass;
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    String fieldName = "";
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    for (Field fields : field) {
                        fields.setAccessible(true);
                        fieldName += fields.getName() + ",";
                    }
                    fieldName = fieldName.substring(0, fieldName.length() - 1);
                    state = connection.createStatement();
                    String query = "SELECT "+ fieldName +" FROM " + tableName;
                    Logger.getAnonymousLogger().info(query);
                    ResultSet res = state.executeQuery(query);
                    return res;
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        try{
            connection.close();
        } catch (SQLException e){Logger.getAnonymousLogger().warning(e.getMessage());}
        return null;
    }

    public <T> void deleteToTable(String tableName, T object){
        Class<?> newClass = object.getClass();
        Connection connection = getConnections();
        try {
            try {
                if (connection != null) {
                    state = connection.createStatement();
                    Field[] field = newClass.getDeclaredFields();
                    Logger.getAnonymousLogger().info(field.length + "");
                        field[0].setAccessible(true);
                    String query = "DELETE FROM " + tableName + " WHERE " + field[0].getName() + " = " + field[0].get(object);
                    Logger.getAnonymousLogger().info(query);
                    state.executeUpdate(query);
                    String querySel = "SELECT id_log FROM Loggers ORDER BY id_log DESC";
                    state = connection.createStatement();
                    ResultSet resState = state.executeQuery(querySel);
                    Long id = 1l;
                    if (resState.next()){
                        id = resState.getLong(1) + 1l;
                    }
                    state.executeUpdate(query);
                    String queryLog = "INSERT INTO Loggers (id_Log, log_Name, date_Name) values (" + id + ", '" + query.replace('(', ' ').replace(')', ' ').replace(',', ' ').replace('\'', ' ') + "','" + LocalDateTime.now().toString() + "')";
                    state.executeUpdate(queryLog);
                }
            }
            catch (SQLException e) {Logger.getAnonymousLogger().info(e.getMessage());}
        }
        catch (Exception e){Logger.getAnonymousLogger().info(e.getMessage());}
        try{
            connection.close();
        } catch (SQLException e){Logger.getAnonymousLogger().warning(e.getMessage());}
    }

}
