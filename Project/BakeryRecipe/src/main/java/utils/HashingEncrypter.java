/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Admin
 */
public class HashingEncrypter {
    //Algorithms
    public final static String MD2 = "MD2";
    public final static String MD5 = "MD5";
    public final static String SHA_1 = "SHA-1";
    public final static String SHA_224 = "SHA-224";
    public final static String SHA_256 = "SHA-256";
    public final static String SHA_384 = "SHA-384";
    public final static String SHA_512 = "SHA-512";
    //CharSet
    public final static Charset UTF_8 = StandardCharsets.UTF_8;
    // Get encrypted réult from byte-báed input
    public static byte[] getDigest(String algorithmName, byte[] input) {
        MessageDigest md;
        try { //create háhing encrypt object
            md = MessageDigest.getInstance(algorithmName);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input); //create encrypted result
        return result;
    }
    //Encrypt a source string uding a hashing method
    public static String getHexaDigest(String algorithmName, String src) {
        // Convert Unicode source string to bytes
        byte[] inputBytes = src.getBytes(UTF_8);
        byte[] encryptedBytes = getDigest(algorithmName, inputBytes);
        return bytesToHex(encryptedBytes);
    }
    // Convert a byte array to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        // Using StringBuilder for contain digits
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String apart = String.format("%02x", b);
            sb.append(apart);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String pass = "123456789";
        System.out.println(getHexaDigest(MD5, pass));
    }
 
}
