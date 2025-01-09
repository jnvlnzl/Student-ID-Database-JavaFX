package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Student student;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // In a real-world scenario, you'd check the username and password against a user database.
        // For demonstration purposes, we'll use a simple mock user.
        String validUsername = "user";
        String validPassword = "password";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            student = new Student(12082832, "student1", true);
            openDashboardWindow();
            System.out.println("Login successful!");
        } else {
            showAlert("Invalid credentials. Please try again.");
        }
    }

    private void openDashboardWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent dashboardRoot = fxmlLoader.load();

            DashboardController dashboardController = fxmlLoader.getController();
            dashboardController.setStudent(student);

            Stage dashboardStage = new Stage();
            dashboardStage.setTitle("Attendance Dashboard");
            dashboardStage.setScene(new Scene(dashboardRoot));
            dashboardStage.show();

            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
