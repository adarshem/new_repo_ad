
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suit for New Test - New Version Creation 2.7 (MD-931)
 * 
 * @author Adarsh
 * @since 2016-01-20
 * @version 1.0
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ Test1.class, Test2.class })
public class TestSuiteVersionCreation {

	private static Logger logger = Logger.getLogger(TestSuiteVersionCreation.class);

	/*
	 * Prepare for setting up tests: 1. Load configuration file for test suite;
	 * 2. Set up WebDriver; 3 Clean up temporary files (optional); 4. User login
	 * (optional);
	 */
	@BeforeClass
	public static void setUp() throws Exception {

//		// prop.setProperty("script_timeout", "ada");
//		Map<String, String> props = new HashMap<String, String>();
//		props.put("script_timeout", "adaaaaaaa");
//		ConfigureHelper.writeProperty("config.qp", props);
//		
		try {
			PropertiesConfiguration conf = new PropertiesConfiguration("config/config.qp");
			conf.setProperty("script_timeout", "11111111111111");
			conf.save();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Tear down test environment: 1. User log out (optional); 2. Close
	 * WebDriver; 3. Clean up temporary files (optional);
	 */
	@AfterClass
	public static void tearDown() throws Exception {

		logger.info("Total test case running:" + BaseTestCase.getCount());
		logger.info("Total Failed:" + BaseTestCase.getFailCount());
		logger.info("Total Succeeded:" + BaseTestCase.getSuccCount());

	}
}
