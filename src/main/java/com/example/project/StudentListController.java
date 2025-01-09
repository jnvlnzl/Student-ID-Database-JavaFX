package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class StudentListController {

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    private ObservableList<Student> students = FXCollections.observableArrayList();

    public void setStudentsList(List<Student> studentsList) {
        students = FXCollections.observableArrayList(studentsList);
        studentTable.setItems(students);
    }

    // This method is automatically called when the FXML file is loaded.
    @FXML
    private void initialize() {
        // Set up the data and link the columns to the Student class properties
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    }
}
