package Util;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

public class INIT {
	public static String DefaultGateWay;
	public static ArrayList<String> UserDeviceIP = new ArrayList<String>();

	public static void main(String[] args) {
		FetchDefaultGateWay();
		GetUserDeviceIP();
	}
	
	public static void FetchDefaultGateWay()
	{
		if (Desktop.isDesktopSupported()) {
            try {
                Process process = Runtime.getRuntime().exec("ipconfig");

                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.trim().startsWith("Default Gateway")) {
                            DefaultGateWay = line.substring(line.indexOf(":") + 1).trim();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void GetUserDeviceIP() 
	{
		if (Desktop.isDesktopSupported()) {
            try {
                Process process = Runtime.getRuntime().exec("ipconfig");

                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.trim().startsWith("IPv4 Address")) {
                    		UserDeviceIP.add(line.substring(line.indexOf(":") + 1).trim());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
