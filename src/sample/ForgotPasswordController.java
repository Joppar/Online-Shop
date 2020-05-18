package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ForgotPasswordController {

    @FXML
    private TextField userName;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private Label invalidName;
    @FXML
    private Label invalidEmail;
    @FXML
    private Label invalidPassword;

    public void handleForgotPasswordButton() {

        if (name.getText().isEmpty()) {
            invalidName.setVisible(true);
        } else invalidName.setVisible(false);

        if (userName.getText().isEmpty()) {
            invalidEmail.setVisible(true);
        } else {
            if (!Customer.validateEmail(userName.getText())) {
                invalidEmail.setText("Invalid Email Address");
                invalidEmail.setVisible(true);
            } else {
                invalidEmail.setVisible(false);
            }
        }

        if (password.getText().isEmpty()) {
            invalidPassword.setVisible(true);
        } else {
            if (!Customer.validatePassword(password.getText())) {
                invalidPassword.setText("Invalid Password");
                invalidPassword.setVisible(true);
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        " • Password must contain at least 2 non-alphabetic characters\n" +
                                " • Password must be at least 8 characters long");
                alert.showAndWait();
            } else invalidPassword.setVisible(false);
        }
    }
}
