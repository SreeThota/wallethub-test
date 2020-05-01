package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reader {
	
	private String filePath = "./Properties/BaseProperties.properties";
	InputStream stream = null;
	Properties properties = null;

	public Reader() {

		try {
			properties = new Properties();
			stream = new FileInputStream(new File(filePath));
			try {
				properties.load(stream);
			} catch (IOException e) {
				System.out.println("Unable to load file data");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the file in specified path");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				System.out.println("Unable to close the reader connection");
			}
		}
	}

	public String getBaseUrl() {

		String s = null;
		try {
			s =  properties.getProperty("facebookurl");
		} catch (Exception e) {
			System.out.println("Unable to find property ApqpStageUrl");
		}
		return s;
	}
	
	public String getFbUserName() {

		String s = null;
		try {
			s =  properties.getProperty("usernameForFacebook");
		} catch (Exception e) {
			System.out.println("Unable to find property ApqpStageUrl");
		}
		return s;
	}
	
	public String getFbPassword() {

		String s = null;
		try {
			s =  properties.getProperty("passwordForFacebook");
		} catch (Exception e) {
			System.out.println("Unable to find property ApqpStageUrl");
		}
		return s;
	}
	
	public String getWalletHubUserName() {

		String s = null;
		try {
			s =  properties.getProperty("walletHubUserName");
		} catch (Exception e) {
			System.out.println("Unable to find property walletHubUserName");
		}
		return s;
	}
	
	public String getWalletHubPassword() {

		String s = null;
		try {
			s =  properties.getProperty("walletHubPassword");
		} catch (Exception e) {
			System.out.println("Unable to find property walletHubPassword");
		}
		return s;
	}
	
	public String getWalletHubUrl() {

		String s = null;
		try {
			s =  properties.getProperty("walletHubUrl");
		} catch (Exception e) {
			System.out.println("Unable to find property walletHubUserName");
		}
		return s;
	}
	
	public String getRatingToPost() {

		String s = null;
		try {
			s =  properties.getProperty("rating");
		} catch (Exception e) {
			System.out.println("Unable to find property rating");
		}
		return s;
	}

}
