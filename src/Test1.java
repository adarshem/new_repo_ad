import java.util.Properties;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		Properties prop = ConfigureHelper.loadProperties("config.qp");

		String s = prop.getProperty("script_timeout");
		System.out.println(s);
	}
}
	