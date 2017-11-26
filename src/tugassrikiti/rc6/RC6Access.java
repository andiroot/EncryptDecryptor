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

    public String getKeyText() {
        return keyText;
    }

    public void setKeyText(String keyText) {
        this.keyText = keyText;
    }
    public byte[] encrypting(){
        byte[]data=this.getDataText().getBytes();
        byte[]key=this.getKeyText().getBytes();
        return RC6.encrypt(data, key);
    }
    public String utf8Charset(){
        byte[] utf8=new String(this.encrypting()).getBytes(StandardCharsets.UTF_8);
        return new String(Base64.getEncoder().encode(utf8));
        
    }
    public String utf16Charset(){
        byte[] utf16=new String(this.encrypting()).getBytes(StandardCharsets.UTF_16);
        return new String(Base64.getEncoder().encode(utf16));
        
    }
    public String usAsciiCharset(){
        byte[] usAscii=new String(this.encrypting()).getBytes(StandardCharsets.US_ASCII);
        return new String(Base64.getEncoder().encode(usAscii));
        
    }
    public String utf16LeCharset(){
        byte[] utf16Le=new String(this.encrypting()).getBytes(StandardCharsets.UTF_16LE);
        return new String(Base64.getEncoder().encode(utf16Le));
        
    }
    public String utf16BeCharset(){
        byte[] utf16Be=new String(this.encrypting()).getBytes(StandardCharsets.UTF_16BE);
        return new String(Base64.getEncoder().encode(utf16Be));
        
    }
    public String iso8859Charset(){
        byte[] iso8859=new String(this.encrypting()).getBytes(StandardCharsets.ISO_8859_1);
        return new String(Base64.getEncoder().encode(iso8859));
        
    }
}
