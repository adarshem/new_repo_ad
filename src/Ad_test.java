import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class Ad_test {

	public static void main(String[] args) {
	}

	static void selectItem(String itemName) {
		System.err.println("");
	}

	public void stopAppiumServer() throws InterruptedException, IOException {
		final String operatingSystemtype = System.getProperty("os.name");
		Process process;
		if (operatingSystemtype.contains("WIN")) {
			process = Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			process.waitFor();
			process.destroy();
		} else {
			process = Runtime.getRuntime().exec("killall node");
			process.waitFor();
			process.destroy();
		}
	}

	private void startAppiumServer(final String deviceName, final String OSVersion, final String udid,
			final String platformName, final String browser) throws IOException, InterruptedException {
		String port = "";
		String bootStrapPort = "";
		String chromeDriverPort = "";
		try {
			stopAppiumServer();

			ServerSocket socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			port = Integer.toString(socket.getLocalPort());
			socket.close();

			socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			bootStrapPort = Integer.toString(socket.getLocalPort());
			socket.close();

			socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			chromeDriverPort = Integer.toString(socket.getLocalPort());
			socket.close();
		} catch (Exception e) {

		}
	}
}
// if (new ValidationActionHelper().isAccuRateManifestXMLExist()) {
// hostIP = xmlr.readXMLData(AutomationConstants.FRAMEWORK_PROPERTIES_NODE_PATH,
// AutomationConstants.HOST_IP);
// } else {
// hostIP =
// PropertiesDataHandler.getProperty(AutomationConstants.FRAMEWORK_PROPERTIES,
// AutomationConstants.HOST_IP);
// }
// boolean success = false;
// if (osName.equals(AutomationConstants.SYSTEM_OS_WIN)) {
// if (hostIP == null || hostIP.equals("")) {
// if (new ValidationActionHelper().isAccuRateManifestXMLExist()) {
// System.out.println(AutomationConstants.HOST_URL_ERROR_IDE);
// return;
// } else {
// System.out.println(AutomationConstants.HOST_URL_ERROR);
// return;
// }
// }
// if (!new File(System.getProperty("user.dir") + "\\Appium_logs").exists()) {
// (new File(System.getProperty("user.dir") + "\\Appium_logs")).mkdir();
// }
//
// try {
// CommandLine command = new CommandLine(getNodePath());
// command.addArgument(getJSPath());
// command.addArgument("--address");
// command.addArgument(hostIP);

//
//
// command.addArgument("--port");
// command.addArgument(port);
// command.addArgument("--bootstrap-port");
// command.addArgument(bootStrapPort);
// command.addArgument("--chromedriver-port");
// command.addArgument(chromeDriverPort);
// command.addArgument("--udid");
// command.addArgument(udid);
// command.addArgument("--log");
// command.addArgument(System.getProperty("user.dir") +
// "\\Appium_logs\\appiumLogs_"
// + getCurrentDateAndTime() + ".txt");
// command.addArgument("--no-reset");
// command.addArgument("--command-timeout");
// command.addArgument("180");
// final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
// final PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
// final DefaultExecuteResultHandler resultHandler = new
// DefaultExecuteResultHandler();
// final DefaultExecutor executor = new DefaultExecutor();
// executor.setStreamHandler(streamHandler);
// executor.execute(command, resultHandler);
// boolean flagStop = true;
// while (flagStop) {
// Thread.sleep(4000);
// String result = outputStream.toString();
// System.out.println(result);
// if (result.contains("debug")
// || result.contains(AutomationConstants.APPIUM_INTERFACE_LISTENER_STARTED)) {
// System.out.println(AutomationConstants.APPIUM_START_SUCCESS_MSG);
// success = true;
// break;
// } else {
// System.out.println(AutomationConstants.WAITING_FOR_APPIUM_TO_START);
// }
// }
// } catch (Exception e) {
// throw new AutomationException(getExceptionMessage(), e);
// }
//
// } else {
// if (!new File(System.getProperty("user.dir") + "//Appium_logs").exists()) {
// (new File(System.getProperty("user.dir") + "//Appium_logs")).mkdir();
// }
//
// final List<String> argumentList = new ArrayList<String>();
// argumentList.add(getNodePath());
// argumentList.add(getJSPath());
// argumentList.add("--address");
// argumentList.add(hostIP);
// argumentList.add("--port");
// argumentList.add(port);
// argumentList.add("--bootstrap-port");
// argumentList.add(bootStrapPort);
// argumentList.add("--chromedriver-port");
// argumentList.add(chromeDriverPort);
// argumentList.add("--udid");
// argumentList.add(udid);
// argumentList.add("--log");
// argumentList.add(System.getProperty("user.dir") +
// "//Appium_logs//appiumLogs_" + getCurrentDateAndTime()
// + ".txt");
// if ("safari".equalsIgnoreCase(browser)) {
// argumentList.add("--safari");
// argumentList.add("--webkit-debug-proxy-port");
// argumentList.add("27753");
// }
//
// String devicevitals = null;
// String runAuto = null;
//
// if (new ValidationActionHelper().isAccuRateManifestXMLExist()) {
// devicevitals =
// xmlr.readXMLData(AutomationConstants.FRAMEWORK_PROPERTIES_NODE_PATH,
// AutomationConstants.NEED_DEVICE_VITALS);
// runAuto =
// xmlr.readXMLData(AutomationConstants.FRAMEWORK_PROPERTIES_NODE_PATH,
// AutomationConstants.RUN_AUTOMATION_IN);
// } else {
// final Properties props = PropertiesDataHandler
// .getAllProperties(AutomationConstants.FRAMEWORK_PROPERTIES);
// devicevitals = props.getProperty(AutomationConstants.NEED_DEVICE_VITALS);
// runAuto =
// PropertiesDataHandler.getProperty(AutomationConstants.FRAMEWORK_PROPERTIES,
// AutomationConstants.RUN_AUTOMATION_IN);
// }
//
// if (devicevitals.equalsIgnoreCase("Yes") &&
// runAuto.equalsIgnoreCase("RVSDeviceFarm")) {
// if (platformName.equalsIgnoreCase("iOS")) {
// String appName = null;
// String traceTemplate = null;
// try {
// traceTemplate = System.getProperty("user.dir") + "/"
// + AutomationConstants.IOS_TRACETEMPLATEPATH;
// } catch (Exception lException) {
// traceTemplate = "";
// lException = new Exception(AutomationConstants.TRACE_TEMPLATE_MISSING);
// lException.printStackTrace();
// }
// try {
// argumentList.add("--tracetemplate");
// argumentList.add(traceTemplate);
// argumentList.add("--trace-dir");
// String device_vitals_folder = System.getProperty("user.dir")
// + AutomationConstants.DEVICE_VITALS_FOLDER;
// argumentList.add(device_vitals_folder);
// } catch (Exception e) {
// e.printStackTrace();
// }
// try {
//
// if (new ValidationActionHelper().isAccuRateManifestXMLExist()) {
// appName =
// xmlr.readXMLData(AutomationConstants.FRAMEWORK_PROPERTIES_NODE_PATH,
// AutomationConstants.IOS_APPNAME);
// } else {
// appName =
// PropertiesDataHandler.getProperty(AutomationConstants.FRAMEWORK_PROPERTIES,
// AutomationConstants.IOS_APPNAME);
// }
//
// if (appName == null || appName.equalsIgnoreCase("")) {
// throw new AutomationException(AutomationConstants.IOS_APPNAME_MISSING);
// }
// } catch (Exception e) {
// throw new AutomationException(AutomationConstants.IOS_APPNAME_MISSING);
// }
// }
// }
//
// argumentList.add("--no-reset");
// final ProcessBuilder prcessBuilder = new ProcessBuilder(argumentList);
// final Process process = prcessBuilder.start();
// BufferedReader outputreader = new BufferedReader(new
// InputStreamReader(process.getInputStream()));
// BufferedReader errorreader = new BufferedReader(new
// InputStreamReader(process.getErrorStream()));
// String singleLine;
// while ((singleLine = outputreader.readLine()) != null) {
// System.out.println(singleLine);
// if (singleLine.contains("debug")
// ||
// singleLine.contains(AutomationConstants.APPIUM_INTERFACE_LISTENER_STARTED)) {
// System.out.println(AutomationConstants.APPIUM_START_SUCCESS_MSG);
// success = true;
// break;
// }
// }
// if (!success) {
// while ((singleLine = errorreader.readLine()) != null) {
// System.out.println(singleLine);
// }
// System.out.println(AutomationConstants.APPIUM_ERROR + port);
// port = "";
// }
// }
//
// if (success) {
// loadAppiumCapabilities(deviceName, OSVersion, port, udid, platformName,
// browser);
// }
// } catch (Exception e) {
// throw new AutomationException(getExceptionMessage(), e);
// }
//
// }
