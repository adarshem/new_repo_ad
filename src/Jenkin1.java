import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Jenkin1 {
	public static void main(String[] args) {
		
		
		System.out.println(System.getProperty("user.dir"));
		
		String [] args1 = {"a","a","a","a","a","a","C:/Users/adarshem/Desktop/GiftOfDeed/Mobile_Smoke_TestData.xlsx"};
		try {
			
			copyFileUsingJava7Files(new File("C:/Users/adarshem/Desktop/Mobile_Smoke_TestData.xlsx"),new File(args1[6]));
			
			PropertiesConfiguration conf = new PropertiesConfiguration("D:/NEONWORKSPACE/TryTryTryAgain/config/config.mobiledriver");
			conf.setProperty("appiumURL", args1[0]);
			conf.setProperty("deviceType", args1[1]);
			conf.setProperty("iosDeviceName", args1[2]);
			conf.setProperty("udid", args1[3]);
			conf.setProperty("iosPlatformVersion", args1[4]);
			conf.setProperty("executionOnRemoteServer", args1[5]);
			conf.save();
			System.out.println("Configuration file has been updated with below values : ");
			System.out.println("1. appiumURL : " + args1[0]);
			System.out.println("2. deviceType : " + args1[1]);
			System.out.println("3. iosDeviceName : " + args1[2]);
			System.out.println("4. udid : " + args1[3]);
			System.out.println("5. iosPlatformVersion : " + args1[4]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    //Files.copy(source.toPath(), dest.toPath());
	}

}
