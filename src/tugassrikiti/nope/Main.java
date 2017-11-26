/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugassrikiti.nope;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author andi
 */
public class Main {
    private static String algorithm = "RC5";
  
   public static void main(String []args) throws Exception {
      String toEncrypt = "The shorter you live, the longer you're dead!";
  
      System.out.println("Encrypting...");
      byte[] encrypted = encrypt(toEncrypt, "password");
  
      System.out.println("Decrypting...");
      String decrypted = decrypt(encrypted, "password");
     
      System.out.println("Decrypted text: " + decrypted);
   }
  
   public static byte[] encrypt(String toEncrypt, String key) throws Exception {
      // create a binary key from the argument key (seed)
      SecureRandom sr = new SecureRandom(key.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance(algorithm);
      kg.init(sr);
      SecretKey sk = kg.generateKey();
  
      // create an instance of cipher
      Cipher cipher = Cipher.getInstance(algorithm);
  
      // initialize the cipher with the key
      cipher.init(Cipher.ENCRYPT_MODE, sk);
  
      // enctypt!
      byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
  
      return encrypted;
   }
  
   public static String decrypt(byte[] toDecrypt, String key) throws Exception {
      // create a binary key from the argument key (seed)
      SecureRandom sr = new SecureRandom(key.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance(algorithm);
      kg.init(sr);
      SecretKey sk = kg.generateKey();
  
      // do the decryption with that key
      Cipher cipher = Cipher.getInstance(algorithm);
      cipher.init(Cipher.DECRYPT_MODE, sk);
      byte[] decrypted = cipher.doFinal(toDecrypt);
      return new String(decrypted);
   }
}
