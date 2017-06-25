/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmate.employeemanager.controller;

import com.rmate.employeemanager.model.Employee;
import com.rmate.employeemanager.service.EmployeeService;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mate
 */
public class MainController implements Initializable {

  @FXML
  private Label label;
  @FXML
  private TableColumn<Employee, Integer> idColumn;
  @FXML
  private TableColumn<Employee, String> nameColumn;
  @FXML
  private TableColumn<Employee, String> emailColumn;
  @FXML
  private Button addButton;
  @FXML
  private Button editButton;
  @FXML
  private Button deleteButton;
  @FXML
  private TableView<Employee> employeeTable;
  @FXML
  private TableColumn<Employee, LocalDate> hireDateColumn;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    updateTable();
    
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
  }

  private void updateTable() {
    ObservableList<Employee> employeeList = FXCollections.observableArrayList(EmployeeService.getEmployees()); 
    employeeTable.setItems(employeeList);
    
  }
  
}
