/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.nope;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author andi
 */
public class NewClass {
    
    public static void main (String[]args){
        String a="old crow medicine show";
        byte[]y=a.getBytes(StandardCharsets.UTF_8);
        String b=Base64.getEncoder().encodeToString(y);
        System.out.println(b);
        
        /*final String s = "old crow medicine show";
        final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        System.out.println(s + " => " + encoded);
        */
    }
}
