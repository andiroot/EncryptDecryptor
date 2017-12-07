/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.rc6;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author andi
 */
public class RC6Access {
    private String dataText;
    private String keyText;
    public String getDataText() {
        return dataText;
    }
    public void setDataText(String dataText) {
        this.dataText = dataText;
    }

    public String getKeyText(){
        return keyText;
    }

    public void setKeyText(String keyText) {
        this.keyText = keyText;
    }
    public byte[] encrypting(){
        byte[]data=this.getDataText().getBytes(StandardCharsets.UTF_8);
        byte[]key=this.getKeyText().getBytes(StandardCharsets.UTF_8);
        byte[]encode=Base64.getEncoder().encode(RC6.encrypt(data, key));
        return encode;
    }
    public byte[] decrypting(){
        try{
            byte[]decodedData=Base64.getDecoder().decode(this.getDataText().getBytes(StandardCharsets.UTF_8));
            byte[]decrypted=RC6.decrypt(decodedData,this.getKeyText().getBytes(StandardCharsets.UTF_8));
            return decrypted;
        }
        catch(IllegalArgumentException ex){
            return null;
        }
    }
}
