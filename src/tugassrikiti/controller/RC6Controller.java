/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import tugassrikiti.rc6.RC6Access;

/**
 * FXML Controller class
 *
 * @author andi
 */
public class RC6Controller implements Initializable {
    @FXML
    private JFXRadioButton utf8CharsetRadio;

    @FXML
    private ToggleGroup charset;

    @FXML
    private JFXRadioButton utf16beCharsetRadio;

    @FXML
    private JFXRadioButton utf16CharsetRadio;

    @FXML
    private JFXRadioButton utf16leCharsetRadio;

    @FXML
    private JFXRadioButton isoCharsetRadio;

    @FXML
    private JFXRadioButton asciiCharsetRadio;

    @FXML
    private JFXButton decryptButton;

    @FXML
    private JFXButton encryptButton;
    
    @FXML
    private JFXTextArea plaintextArea;

    @FXML
    private JFXTextArea chipertextArea;
    
    Alert alert=new Alert(AlertType.WARNING);
    String contentAlert="Pilih salah satu encoding";
    @FXML
    private JFXTextField keyTextField;
    RC6Access rc6=new RC6Access();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    public boolean keyValidation(){
        return keyTextField.getCharacters().length() %4==0;
        
    }

    @FXML
    void handleKeyTextField(ActionEvent event) {

    }

    @FXML
    void handleUtf16CharsetRadio(ActionEvent event) {
        if(charset.getSelectedToggle()!=null){
            if(utf16CharsetRadio.isSelected()){
                System.out.println("utf16");
                plaintextArea.setText(utf16CharsetRadio.getText());
            }
        }
    }

    @FXML
    void handleUtf16beCharsetRadio(ActionEvent event) {
        if(charset.getSelectedToggle()!=null){
            if(utf16beCharsetRadio.isSelected()){
                System.out.println("utf16 be");
                plaintextArea.setText(utf16beCharsetRadio.getText());
            }
        }
    }

    @FXML
    void handleUtf16leCharsetRadio(ActionEvent event) {
        if(charset.getSelectedToggle()!=null){
            if(utf16leCharsetRadio.isSelected()){
                System.out.println("utf16 le");
                plaintextArea.setText(utf16leCharsetRadio.getText());
            }
        }
    }
    @FXML
    void handleAsciiCharsetRadio(ActionEvent event) {
        if(charset.getSelectedToggle()!=null){
            if(asciiCharsetRadio.isSelected()){
                System.out.println("ascii");
                plaintextArea.setText(asciiCharsetRadio.getText());
            }
        }
    }
    @FXML
    void handleUtf8CharsetRadio(ActionEvent event) {
        if(charset.getSelectedToggle()!=null){
            if(utf8CharsetRadio.isSelected()){
                System.out.println("utf8");
                plaintextArea.setText(utf8CharsetRadio.getText());
            }
        }
    }
     @FXML
    void handleIsoCharsetRadio(ActionEvent event) {
         if(charset.getSelectedToggle()!=null){
            if(isoCharsetRadio.isSelected()){
                System.out.println("iso");
                plaintextArea.setText(isoCharsetRadio.getText());
            }
        }
         else{
            
         }
    }
    public void handleButtonAction(){
        
        if(charset.getSelectedToggle()==null){
            alert.setTitle("Warteg !! *eh Warning !");
            alert.setHeaderText("Pilih Encoding");
            alert.setContentText("Pilih salah satu encodingnya ya kidz !!");
            alert.showAndWait();
        }
    }
    public void handleKeyTextField(){
        if(!keyValidation()){
            System.out.println("karakter kurang euy");
        }
        else{
            System.out.println("bisa");
        }
    }
    
    
    
}
