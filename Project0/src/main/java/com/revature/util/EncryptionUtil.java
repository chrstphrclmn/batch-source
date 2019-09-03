package com.revature.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class EncryptionUtil {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    private EncryptionUtil() {
    	
    	throw new IllegalStateException("Utility Class.");
    }
 
    public static void setKey(String myKey) {
    	
        MessageDigest sha = null;
        
        try {
        	
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");          
        }
        
        catch (NoSuchAlgorithmException e) {
        	
        	LoggerUtil.log.warn(e.getMessage());
        }
        
        catch (UnsupportedEncodingException e) {
        	
        	LoggerUtil.log.warn(e.getMessage());
        }
    }
 
    public static String encrypt(String strToEncrypt, String key) {
    	
        try {
        	
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        
        catch (Exception e) {
        	
        	LoggerUtil.log.warn(e.toString());
        }
        
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String key) {
    	
        try {
        	
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        
        catch (Exception e) {
        	
        	LoggerUtil.log.warn(e.getMessage());
        }
        
        return null;
    }
}
