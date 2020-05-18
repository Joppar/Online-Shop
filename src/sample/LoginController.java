package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

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
            /*Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene dashboardScene = new Scene(dashboard);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(dashboardScene);
            window.show();*/
            Alert alert = new Alert(Alert.AlertType.WARNING, "Soon");
            alert.setHeaderText("Soon");
            alert.showAndWait();
        } else
        {
            invalidLabel.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error login");
            alert.setHeaderText("Connection Failure");
            alert.showAndWait();
        }


    }


}

