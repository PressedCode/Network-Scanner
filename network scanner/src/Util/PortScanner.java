package Util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public class PortScanner extends Thread {
	public static String HostName;
	public static int portNumber;
	public static ArrayList<String> OpenPortList = new ArrayList<String>();
	
	public void run() {
		ReturnPortReachablity();
	}
	
	//uses IP address to find out which ports on it are accessible
	public static ArrayList<String> ScanAllPorts(String hostName) {
		System.out.println("Scanning");
		
		HostName = hostName;
		
		for (int PortNumber = 1; PortNumber < 65535; PortNumber++) {
			PortScanner portScanner = new PortScanner();
			portNumber = PortNumber;
		    portScanner.start();
		}
		
		System.out.println("Checked 65,535 ports");
		System.out.println(OpenPortList.size() + " ports are reachable");
		
		return OpenPortList;
	}
	
	private static void ReturnPortReachablity() {
		int timeout=1000;
		
		try {
	          Socket socket = new Socket();
	          socket.connect(new InetSocketAddress(HostName, portNumber), timeout);
	          socket.close();
	          OpenPortList.add(String.valueOf(portNumber));
	        } catch (Exception ex) {
	          
	        }
	}
}
