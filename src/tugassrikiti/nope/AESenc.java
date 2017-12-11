/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.nope;

/**
 *
 * @author andi
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AESenc {
  private static final String ALGO = "AES";
  private static final byte[] keyValue =
            new byte[]{'k','u','n','c','i','k','u','n','c','i','l','l','l','t','a','i'};

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     * @throws java.lang.Exception
     */
    public static String encrypt(String data) throws Exception {
        //String keys=new String(keyValue);
        Key key = generateKey();
        //System.out.print(key.getAlgorithm()+" "+key.getFormat()+" "+Arrays.toString(key.getEncoded()));
        Cipher c = Cipher.getInstance(ALGO);
        
        c.init(Cipher.ENCRYPT_MODE, key);
        System.out.println("algo"+c.getBlockSize());
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     * @throws java.lang.Exception
     */
    public static String decrypt(String encryptedData) throws Exception {
        //String keys=new String(keyValue);
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() throws Exception {
        
        final Key key = new SecretKeySpec(keyValue, ALGO);
        //return new SecretKeySpec(keyValue, ALGO);
        System.out.println(new String(key.getEncoded()));
        return key;
    }
    public static void main(String[]args) throws Exception{
        System.out.println(AESenc.encrypt("Tak Tun Tuang"));
        //System.out.println(AESenc.decrypt("yv9szB518adjsqtXckHLHsr/bMwedfGnY7KrV3JByx7K/2zMHnXxp2Oyq1dyQcseyv9szB518adjsqtXckHLHmoF36idE1G+lM/r6zB97y8="));
    }
//128 bit, CBC
}
