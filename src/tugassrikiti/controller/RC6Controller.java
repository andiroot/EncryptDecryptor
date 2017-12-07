/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.TextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tugassrikiti.rc6.RC6Access;

/**
 * FXML Controller class
 *
 * @author andi
 */
public class RC6Controller implements Initializable {
    

    @FXML
    private JFXButton decryptButton;

    @FXML
    private JFXButton encryptButton;
    
    @FXML
    private TextArea plaintextArea;

    @FXML
    private TextArea chipertextArea;
    
    @FXML
    private JFXButton clearButton;
    Alert alert=new Alert(AlertType.ERROR);
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
    public void handleEncryptButtonAction(){   
        if(handleKeyTextField()){
            
            if(plaintextArea.getText().equals("")){
                alert.setTitle("ERROR");
                alert.setContentText("Plaintextnya kosong !");
                alert.show();
            }
            else{
                rc6.setDataText(plaintextArea.getText());
                rc6.setKeyText(keyTextField.getText());
                chipertextArea.setText(new String(rc6.encrypting()));
            }
        }
    }
    public void handleDecryptButtonAction(){
        if(handleKeyTextField()){
            if(chipertextArea.getText().equals("")){
                alert.setTitle("ERROR");
                alert.setContentText("Isi chipertextnya dulu Lah (-_-)");
                alert.show();
            }
            else{
                rc6.setDataText(chipertextArea.getText());
                rc6.setKeyText(keyTextField.getText());
                if(rc6.decrypting()!=null){
                    plaintextArea.setText(new String(rc6.decrypting()));
                }
                else{
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Chipertext ERROR");
                    alert.setContentText("Chipertextnya corrupt,rusak atau key salah !!");
                    alert.show();
                }
            }
        }
    }
    public boolean handlePlainTextField(){
        if(plaintextArea.getText().equals("")){
            alert.setTitle("ERROR");
            alert.setContentText("Plaintextnya kosong !");
            return false;
        }
        return true;
    }
    public boolean handleChiperTextField(){
        if(chipertextArea.getText().equals("")){
            alert.setTitle("ERROR");
            alert.setContentText("Chipertextnya kosong !");
            return false;
        }
        return true;
    }
    public boolean handleKeyTextField(){
        if(!keyValidation()){
            alert.setTitle("ERROR");
            alert.setHeaderText("Error euy ..");
            alert.setContentText("Itu Key-nya invalid !!");
            alert.showAndWait();
            return false;
        }
        if(keyTextField.getText().equals("")){
            alert.setTitle("Warteg !! *eh Warning !");
            alert.setHeaderText("Required Key");
            alert.setContentText("Key-nya di input ya kidz !!");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    public void handleClearButton(){
        keyTextField.setText("");
        plaintextArea.setText("");
        chipertextArea.setText("");
        
    }
    
    
    
}
