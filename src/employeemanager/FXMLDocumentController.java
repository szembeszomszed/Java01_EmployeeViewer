/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author mate
 */
public class FXMLDocumentController implements Initializable {

  @FXML
  private Label label;
  @FXML
  private TableView<?> employeeTable;
  @FXML
  private TableColumn<?, ?> idColumn;
  @FXML
  private TableColumn<?, ?> nameColumn;
  @FXML
  private TableColumn<?, ?> emailColumn;
  @FXML
  private Button addButton;
  @FXML
  private Button editButton;
  @FXML
  private Button deleteButton;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
