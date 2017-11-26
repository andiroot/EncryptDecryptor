/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.rc6;


import tugassrikiti.rc6.RC6;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author andi
 */
public class TugasSrikiti extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RC6 rc6=new RC6();
        Scanner sc=new Scanner(System.in);
        System.out.print("Masukan Text euy :");
        String text;
        text=sc.nextLine();
        System.out.print("Key :");
        String key;
        key=sc.nextLine();
        byte[]data=text.getBytes();
        byte[]keys=key.getBytes();
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(keys));
        byte[]print=RC6.encrypt(data, keys);
       
        //byte[]encode=Base64.getEncoder().encode(print);
        //String a=Base64.getEncoder().encodeToString(print);
        System.out.println(new String(print));
        System.out.println(Arrays.toString(print));
        //System.out.println(new String(print).getBytes(StandardCharsets.UTF_8));
        byte[] utf8=new String(print).getBytes(StandardCharsets.UTF_8);
        byte[] utf16=new String(print).getBytes(StandardCharsets.UTF_16);
        byte[] ascii=new String(print).getBytes(StandardCharsets.US_ASCII);
        byte[] iso8859=new String(print).getBytes(StandardCharsets.ISO_8859_1);
        byte[] utf16be=new String(print).getBytes(StandardCharsets.UTF_16BE);
        byte[] utf16le=new String(print).getBytes(StandardCharsets.UTF_16LE);
        System.out.println(new String(Base64.getEncoder().encode(utf8)));
        System.out.println(new String(Base64.getEncoder().encode(utf16)));
        System.out.println(new String(Base64.getEncoder().encode(ascii)));
        System.out.println(new String(Base64.getEncoder().encode(iso8859)));
        System.out.println(new String(Base64.getEncoder().encode(utf16be)));
        System.out.println(new String(Base64.getEncoder().encode(utf16le)));
        System.exit(0);
        //byte[]   bytesEncoded = Base64.encodeBase64(str .getBytes());
        //System.out.println("ecncoded value is " + new String(bytesEncoded ));
        //jadi kalo input <=4 char error euy,
    }
}//pakek base64 , charset UTF-8
//��B�� Xg�è�FZ�