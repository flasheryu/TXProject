package org.openqa.selenium.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class cpConfig {

//	private static String zBuildRelease = "R22";
	
	public static void writePty() 
	{
		Properties pty = new Properties();
		FileOutputStream file = null;
		try {
			file = new FileOutputStream("config/cpConfig.pty");
			pty.storeToXML(file, "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Properties readPty(String configfile)
	{
		FileInputStream file = null;
		Properties pty = new Properties();
		try {
			file = new FileInputStream(configfile);
			pty.loadFromXML(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pty;
		
	}
	
}
