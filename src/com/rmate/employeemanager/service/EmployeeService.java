package com.rmate.employeemanager.service;

import com.rmate.employeemanager.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * created by mate 
 */
public class EmployeeService extends Service {
  
  public static List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList<>();    
    String query = "SELECT "
            +         "EMPLOYEE_ID, "
            +         "FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME, "
            +         "EMAIL,"
            +         "HIRE_DATE "
            +       "FROM "
            +         "EMPLOYEES";
    
    try {            
      Class.forName(DRIVER);
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
      
      while (rs.next()) {
        Employee employee = new Employee();
        
        employee.setId(rs.getInt("EMPLOYEE_ID"));
        employee.setName(rs.getString("EMP_NAME"));
        employee.setEmail(rs.getString("EMAIL"));
        employee.setHireDate(rs.getDate("HIRE_DATE"));
        
        employees.add(employee);
      }
      
      con.close();
    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println("exception @getEmployees: " + ex);
    }
    
    return employees;
  }
  
   public static List<Employee> getEmployeesByDepartmentId(int id) {
    List<Employee> employees = new ArrayList<>();    
    String query = "SELECT "
            +         "EMPLOYEE_ID, "
            +         "FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME, "
            +         "EMAIL,"
            +         "HIRE_DATE "
            +       "FROM "
            +         "EMPLOYEES "
            +       "WHERE DEPARTMENT_ID = " + id;
    
    try {            
      Class.forName(DRIVER);
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
      
      while (rs.next()) {
        Employee employee = new Employee();
        
        employee.setId(rs.getInt("EMPLOYEE_ID"));
        employee.setName(rs.getString("EMP_NAME"));
        employee.setEmail(rs.getString("EMAIL"));
        employee.setHireDate(rs.getDate("HIRE_DATE"));
        
        employees.add(employee);
      }
      
      con.close();
    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println("exception @getEmployeesByDepId: " + ex);
    }
    
    return employees;
  }
}
