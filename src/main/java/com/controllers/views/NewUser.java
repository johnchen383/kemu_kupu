package com.controllers.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.MainApp;
import com.controllers.ApplicationController;
import com.enums.View;
import com.models.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * This class is the controller for the sigin view.
 */
public class NewUser extends ApplicationController implements Initializable {
    @FXML
    private ImageView backButton;
    @FXML
    private TextField nicknameInput;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private ImageView createAccountButton;

    private void onCreateAccount(){
        User user = new User();
        try {
            String res = user.signup(usernameInput.getText(), passwordInput.getText(), nicknameInput.getText());
            if (res == null){
                //success
                MainApp.setUser(user);
                MainApp.setRoot(View.PROFILE);
            } else {
                //duplicate username
                //TODO: error modal
                usernameInput.clear();
                passwordInput.clear();
                nicknameInput.clear();
                nicknameInput.requestFocus();
            }
        } catch (IOException e){
            System.err.println("Unable to complete request");
        }
    }

    @Override
    protected void start() {
        nicknameInput.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize();

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            MainApp.setRoot(View.SIGNIN);    
        });

        createAccountButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            onCreateAccount(); 
        });

        nicknameInput.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                usernameInput.requestFocus();
            }
        });

        usernameInput.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                passwordInput.requestFocus();
            }
        });

        passwordInput.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                onCreateAccount();
            }
        });


    }

}