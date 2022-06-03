package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class NetworkSniffer {
	public static void CallNetworkSniffer(String ip, int port) {
		//calls python script that can scan specific ports with admin privelges, gets raw data only
		System.out.println("Starting Network Sniffer");
		
		try {
			String path = "NetworkSniffer.py";
			ProcessBuilder pb = new ProcessBuilder("Python","NetworkSniffer.py", ip, String.valueOf(port)).inheritIO();
			Process p = pb.start();
			p.waitFor();
			BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = bfr.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {System.out.println("Failed to attach proccess"); System.out.println(e);}
	}
}
