
import java.util.Arrays;
import java.util.Properties;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Copyright (C) 2014 QuickMobile
 * 
 * BaseTestCase extends Base. It is extended by test case classes; Mobile and
 * RPC will be implemented later.
 * 
 * @author Xuemei Zhang
 * @version 1.0
 * @since 2014-06-01
 * 
 */
public abstract class BaseTestCase {

	private static int count = 0;
	private static int succCount = 0;
	private static int failCount = 0;

	// full class name
	protected String className = this.getClass().getCanonicalName();

	// to get config file name
	protected String configFileName = className.substring(className.lastIndexOf("quickmobile.") + 12).trim();
	private Properties prop = ConfigureHelper.loadProperties(getConfigfileName());

	public String getConfigfileName() {
		int index = configFileName.lastIndexOf(".");
		String str = new StringBuilder(configFileName).replace(index, index + 1, "/").toString();
		return str;

	}

	// get property for each test case: property name is the same as the test
	// case class name;
	public String getPropValue(String name) {
		String rtn = prop.getProperty(name.trim());

		return rtn;
	}

	public String[] getPropList(String name) {
		String[] list = null;
		list = prop.getProperty(name).split(";");

		return list;
	}

	public static int getCount() {
		return count;
	}

	public static int getSuccCount() {
		return succCount;
	}

	public static int getFailCount() {
		return failCount;
	}

	@Rule
	public TestName name = new TestName();

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void starting(Description d) {
			count++;
		}

		@Override
		protected void failed(Throwable e, Description d) {

			failCount++;
		}

		@Override
		protected void succeeded(Description d) {

			succCount++;
		}
	};

}