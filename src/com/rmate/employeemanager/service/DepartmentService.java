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
    String query = "SELECT "
            + "       DEPARTMENT_ID, "
            + "       DEPARTMENT_NAME"
            + "     FROM "
            + "       DEPARTMENTS"
            + "     ORDER BY"
            + "       DEPARTMENT_NAME ASC ";

    try {
      Class.forName(DRIVER);
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);

      while (rs.next()) {
        Department department = new Department();

        department.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
        department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));

        departments.add(department);
      }

      con.close();
    } catch (SQLException | ClassNotFoundException ex) {
      System.out.println("exception @getDepartments: " + ex);
    }

    return departments;
  }
}
