package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField regName;

    @FXML
    private PasswordField regPassword;

    @FXML
    private Button regButton;

    @FXML
    private TextField regLastName;

    @FXML
    private TextField regLogin;

    @FXML
    private TextField regCountry;

    @FXML
    private CheckBox regSexMan;

    @FXML
    private CheckBox regSexWoman;

    @FXML
    void initialize() {
        regButton.setOnAction(event -> {
            regNewUser();
        });
    }

    private void regNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = regName.getText();
        String lastName = regLastName.getText();
        String login = regLogin.getText();
        String password = regPassword.getText();
        String location = regCountry.getText();
        String gender;
        if(regSexMan.isSelected())
            gender = "Male";
        else
            gender = "Female";

        User user = new User(firstName, lastName, login,
                password, location, gender);

        dbHandler.regUpUser(user);
    }
}