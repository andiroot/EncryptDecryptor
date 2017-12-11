/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author andi
 */

public class SidePaneController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private JFXHamburger hamburger;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
   @FXML
    private JFXButton rcButton;

    @FXML
    void handleRc6Button(ActionEvent event) {
        MainController mc=new MainController();
        
    }
    //gua mau insert icon ke button gimana caranya yak zz
    //bisa sih pakek css udh ada contohnya tinggal praktekin
}