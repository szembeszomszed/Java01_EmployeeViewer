package com.rmate.employeemanager.service;

import com.rmate.employeemanager.model.Department;
import static com.rmate.employeemanager.service.Service.DRIVER;
import static com.rmate.employeemanager.service.Service.PASSWORD;
import static com.rmate.employeemanager.service.Service.URL;
import static com.rmate.employeemanager.service.Service.USER;
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
public class DepartmentService extends Service {

  public static List<Department> getDepartments() {
    List<Department> departments = new ArrayList<>();
    
  String query = "SELECT DISTINCT "
          + "       D.DEPARTMENT_ID, "
          + "       DEPARTMENT_NAME, "
          + "       (SELECT COUNT(E2.EMPLOYEE_ID) FROM EMPLOYEES E2 WHERE E2.DEPARTMENT_ID = D.DEPARTMENT_ID) AS NUMBER_OF_EMPLOYEES"
          + "     FROM "
          + "       DEPARTMENTS D, EMPLOYEES E1"
          + "     WHERE "
          + "       D.DEPARTMENT_ID = E1.DEPARTMENT_ID"
          + "     ORDER BY "
          + "       DEPARTMENT_NAME";

    try {
      Class.forName(DRIVER);
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);

      while (rs.next()) {
        Department department = new Department();

        department.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
        department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
        department.setNumberOfEmployees(rs.getInt("NUMBER_OF_EMPLOYEES"));

        departments.add(department);
      }

      con.close();
    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println("exception @getDepartments: " + ex);
    }

    return departments;
  }
}
