package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane ap;
    @FXML
    private TextField userName;
    @FXML
    private TextField pass;
    @FXML
    private Label invalidLabel;

    public void handleContactUsLink() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Email - online.shop@email.com\n");
        alert.setHeaderText("Contact Us");
        alert.showAndWait();
    }

    public void handleEnquirySubmit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "We'll get back to you shortly");
        alert.setHeaderText("Thank you");
        alert.showAndWait();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.close();
    }

    public void handleLoginButton(ActionEvent event) throws IOException{
        String userName = this.userName.getText();
        String pass = this.pass.getText();
        if(userName.equals("Admin") && pass.equals("Admin")) {
            Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene dashboardScene = new Scene(dashboard);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(dashboardScene);
            window.show();
        } else
        {
            invalidLabel.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error login");
            alert.setHeaderText("Connection Failure");
            alert.showAndWait();
        }


    }

    public void handleRegisterButton()throws IOException {
        Parent register = FXMLLoader.load(getClass().getResource("../fxml/Register.fxml"));
        Scene registerScene = new Scene(register);
        Stage window = new Stage();
        window.setTitle("Registration");
        window.setResizable(false);
        window.setScene(registerScene);
        window.show();
    }

    public void handleForgotPassword()throws IOException {
        Parent forgotPassword = FXMLLoader.load(getClass().getResource("../fxml/ForgotPassword.fxml"));
        Scene forgotPasswordScene = new Scene(forgotPassword);
        Stage window = new Stage();
        window.setTitle("ForgotPasssword");
        window.setResizable(false);
        window.setScene(forgotPasswordScene);
        window.show();
    }

}

