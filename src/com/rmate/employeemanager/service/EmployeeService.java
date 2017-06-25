package com.rmate.employeemanager.service;

import com.rmate.employeemanager.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.driver.OracleDriver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * created by mate 
 */
public class EmployeeService {
  public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
  public static final String USER = "HR";
  public static final String PASSWORD = "hr";
  public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  
  public static List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList<>();
    
    String query = "SELECT "
            +         "EMPLOYEE_ID, "
            +         "FIRST_NAME || ' ' || LAST_NAME AS empName, "
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
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate hireDate = LocalDate.parse(rs.getString("HIRE_DATE"), formatter);
        
        employee.setId(rs.getInt("EMPLOYEE_ID"));
        employee.setName(rs.getString("empName"));
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
}
