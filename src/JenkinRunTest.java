import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.PropertiesConfiguration;

public class JenkinRunTest {

	public static void main(String[] args) {

		try {
			// PropertiesConfiguration conf = new PropertiesConfiguration(
			// "D:/NEONWORKSPACE/TryTryTryAgain/config/config.qp");
			// conf.setProperty("base_url", "testsssss");
			//// conf.setProperty("OS_platform", args[1]);
			//// conf.setProperty("version", args[2]);
			// conf.save();
			// // System.out.println("Configuration file (config.qp) has been
			// updated with below values : ");
			// //System.out.println("1. base_url : " + args[0]);
			// //System.out.println("2. OS_platform : " + args[1]);
			// //System.out.println("3. version : " + args[2]);

			try {
				List<String> argumentList = new ArrayList<String>();
				// argumentList.add("adb shell");
				// argumentList.add("ls
				// /sdcard/Android/data/com.quickmobile.app13365/files/Documents/QuickMobile");
				// ProcessBuilder prcessBuilder = new
				// ProcessBuilder(argumentList);
				// Process process = prcessBuilder.start();

				Thread.sleep(1000);
				Process process = Runtime.getRuntime()
						.exec("adb shell ls /sdcard/Android/data/com.quickmobile.app13365/files/Documents/QuickMobile");
				Thread.sleep(1000);
				process.waitFor();
				BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String appDetails = "";
				while ((appDetails = r.readLine()) != null) {
					System.out.println(appDetails);
					if (!appDetails.isEmpty()) {
						argumentList.add(appDetails);
					}
				}

				System.out.println(argumentList);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
