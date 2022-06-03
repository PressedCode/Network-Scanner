package COMPUTER_TEMPLATE_CLASSES;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import INTERFACES.COMPUTER_TEMPLATE_INTERFACE;
import Util.INIT;
import Util.IPScanner;
import Util.MacAddressScanner;

public class DefaultComputer implements COMPUTER_TEMPLATE_INTERFACE{
	public static String IP;
	public static String Name = "DEFAULT";
	public static ArrayList<String> ActiveUsers = new ArrayList<String>();
	public static String MacAddress;
	public static ArrayList<String> OpenPorts = new ArrayList<String>();
	
	public DefaultComputer(String ip) {
		IP = ip;
	}
	
	public static void ChangeIP(String ip) {
		IP = ip;
	}
	
	public static void ChangeMacAddress(String macaddress) {
		MacAddress = macaddress;
	}
	
	public static String FetchIP() {
		if (IPScanner.CheckForIP(IP)) {}
		else {
			IP = null;
		}
		return IP;
	}
	
	public static String FetchName() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getByName(IP);
		} catch (UnknownHostException e) {}
		Name = addr.getHostName();
		return Name;
	}
	
	public static ArrayList<String> FetchActiveUsers() {
//		InetAddress addr = null;
//		try {
//			addr = InetAddress.getByName(IP);
//		} catch (UnknownHostException e) {}
//		ActiveUsers.add(System.getProperty("user.name"));
		return ActiveUsers;
	}
	
	public static String FetchMacAddress() {
		MacAddress = MacAddressScanner.ReturnMacAddress(IP);
		return MacAddress;
	}
	
	public static void FetchOpenPorts() {
		OpenPorts = Util.PortScanner.ScanAllPorts(IP);
	}
}
