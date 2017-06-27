package com.rmate.employeemanager.model;

/**
 *
 * created by mate 
 */
public class Department {
  private int departmentId;
  private String departmentName;
  private int numberOfEmployees;
  
  public Department() { }

  public Department(Integer departmentId, String departmentName, int numberOfEmployees) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.numberOfEmployees = numberOfEmployees;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public void setNumberOfEmployees(int numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
  }  
  

  @Override
  public String toString() {
    return departmentName + " (" + numberOfEmployees + ")";
  }
  

}
