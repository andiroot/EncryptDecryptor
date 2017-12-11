/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author andi
 */
public class MainController implements Initializable{
    @FXML
    private VBox slide;
    @FXML
    public JFXDrawer drawer;//ini udah public tinggal di references dari instance class ini coy. zzz
    @FXML
    private AnchorPane anchor;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //anchor.set
            //System.out.println(drawer.getSidePane());
            //this.mainHamburger.setMouseTransparent(false);
            drawer.setResizableOnDrag(true);
            VBox sidePane=FXMLLoader.load(getClass().getResource("/tugassrikiti/fxml/SidePane.fxml"));
            drawer.setSidePane(sidePane);
            for(Node node :sidePane.getChildren()){
                if(node.getAccessibleText()!=null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
                        switch(node.getAccessibleText()){
                            case "RC6" : 
                                break;
                        }
                    });
                }
            }
            HamburgerBackArrowBasicTransition transition=new HamburgerBackArrowBasicTransition(mainHamburger);
            transition.setRate(-1);
            mainHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                transition.setRate(transition.getRate()*-1);
                transition.play();
                if(drawer.isShown()){
                    drawer.close();
                    
                }
                else{
                    drawer.open();
                }
                
            });
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    @FXML
    private JFXDrawersStack stack;

    @FXML
    public JFXHamburger mainHamburger;
    
    
    @FXML
    public Pane pane;
    @FXML
     void handleHamburger(MouseEvent event) {
        
        
        
        
        
    }
    
    
}
