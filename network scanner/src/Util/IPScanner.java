package Util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import MultiThreaded_Functions.ScanAllIPs;

public class IPScanner {
	public static ArrayList<String> AllIPsList = new ArrayList<String>();
	public static Hashtable<String, String> ActiveMachineList = new Hashtable<String, String>();
	
	//scans all possible IP addresses on local network to find active devices
	public static ArrayList<String> ScanAll()
	{
		System.out.println("Scanning");
		
		for (int IpTypes = 0; IpTypes < INIT.UserDeviceIP.size(); IpTypes++) {
			for (int NumSize=1; NumSize<=255; NumSize++){
				String host=String.valueOf(INIT.UserDeviceIP.get(IpTypes)).substring(0, INIT.UserDeviceIP.get(IpTypes).length() - INIT.UserDeviceIP.get(IpTypes).split("\\.", 4)[3].length()) + NumSize;
				new MultiThreaded_Functions.ScanAllIPs(host).start();
			}
		}
		
		try {
			Thread.sleep(ScanAllIPs.timeout + 1000);
		} catch (InterruptedException e) {}
		System.out.println("Checked for " + (INIT.UserDeviceIP.size()*254) + " devices");
		System.out.println("Found " + (AllIPsList.size()) + " active devices");
		return AllIPsList;
	}
	
	public static boolean CheckForIP(String IP)
	{
		int timeout = 1000;
		String host = IP;
		
		try {
			if (InetAddress.getByName(host).isReachable(timeout)){
				return true;
		}
			else {
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
