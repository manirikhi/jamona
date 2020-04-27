package com.ems.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {
	public static void main(String[] args) {
		System.out.println(getHash("123@"));
	}
	public static String getHash(final String hash){
		StringBuilder sb = new StringBuilder();
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(hash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
       return sb.toString();
	}
}
