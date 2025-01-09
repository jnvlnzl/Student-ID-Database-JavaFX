package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button studentAttendanceButton;

    @FXML
    private Button studentListButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleStudentAttendanceButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StudentAttendance.fxml"));
            Parent dashboardRoot = fxmlLoader.load();

            Stage dashboardStage = new Stage();
            dashboardStage.setTitle("Student Attendance Dashboard");
            dashboardStage.setScene(new Scene(dashboardRoot));
            dashboardStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleStudentListButtonClick() {
    }
}