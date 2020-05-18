package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {

    @FXML
    private TextField userName;
    @FXML
    private TextField name;
    @FXML
    private TextArea address;
    @FXML
    private TextField password;
    @FXML
    private TextField verifyPassword;
    @FXML
    private CheckBox policy;
    @FXML
    private Label invalidName;
    @FXML
    private Label invalidEmail;
    @FXML
    private Label invalidPassword;
    @FXML
    private Label invalidAddress;
    @FXML
    private Label invalidMatch;
    @FXML
    private CheckBox weeklyNews;
    @FXML
    private CheckBox monthlyNews;
    @FXML
    private CheckBox yearlyNews;

    public void handleAddButton() {

        if (name.getText().isEmpty()) {
            invalidName.setVisible(true);
        } else invalidName.setVisible(false);

        if (address.getText().isEmpty()) {
            invalidAddress.setVisible(true);
        } else invalidAddress.setVisible(false);

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
            if (!password.getText().equals(verifyPassword.getText())) {
                invalidMatch.setVisible(true);
            } else {
                invalidMatch.setVisible(false);
                if (!policy.isSelected()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Agree to our terms and conditions to continue");
                    alert.showAndWait();
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Thank you");
    }

}
