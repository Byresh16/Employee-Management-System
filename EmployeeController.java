package ui;

import dao.EmployeeDAO;
import model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

public class EmployeeController {
    @FXML private TableView<Employee> table;
    @FXML private TableColumn<Employee,Integer> idCol;
    @FXML private TableColumn<Employee,String> nameCol;
    @FXML private TableColumn<Employee,String> deptCol;
    @FXML private TableColumn<Employee,Double> salCol;
    @FXML private TextField nameField, deptField, salField;

    private final EmployeeDAO dao = new EmployeeDAO();

    @FXML public void initialize() {
        idCol.setCellValueFactory(c->new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()).asObject());
        nameCol.setCellValueFactory(c->new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));
        deptCol.setCellValueFactory(c->new javafx.beans.property.SimpleStringProperty(c.getValue().getDepartment()));
        salCol.setCellValueFactory(c->new javafx.beans.property.SimpleDoubleProperty(c.getValue().getSalary()).asObject());
        table.setItems(dao.getAll());
    }

    @FXML public void addEmployee() {
        try{
            dao.add(new Employee(0,nameField.getText(),deptField.getText(),Double.parseDouble(salField.getText())));
            table.setItems(dao.getAll());
            nameField.clear();deptField.clear();salField.clear();
        }catch(Exception e){e.printStackTrace();}
    }
}
