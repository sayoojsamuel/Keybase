package com.onedark.springbootstarter.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Scanner; 
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;


public class GetKeys {
	
	public static String readFromFile(String path, String head) throws IOException {
		File file = new File(path);
		System.out.println("File created");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		System.out.println("BF Reader done!");
		String output = "";
		int i=0;
		//while((output+=br.read())!= null) {System.out.println("read line x");}
		while((output+=br.readLine())!=null) {if (i>20) break;i++;} 
		System.out.println("Reading done");
		return "----- Begin "+head+" Key -----\n"+Base64.getEncoder().encodeToString(output.getBytes())+"\n ----- End "+head+" Key -----\n";
	}

}
