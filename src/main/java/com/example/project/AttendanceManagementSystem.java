package com.example.project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class AttendanceManagementSystem extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        List<Student> studentsList = fetchStudentsFromDataSource();

        ObservableList<Student> observableStudents = FXCollections.observableList(studentsList);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentList.fxml"));
        Parent root = loader.load();

        StudentListController studentListController = loader.getController();
        studentListController.setStudentsList(observableStudents);

        primaryStage.setTitle("Attendance Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private List<Student> fetchStudentsFromDataSource() {
        List<Student> students = List.of(
                new Student(1, "student1", "pw1"),
                new Student(2, "student2", "pw2"),
                new Student(3, "student3", "pw3")
        );
        return students;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
