package COMPUTER_TEMPLATE_CLASSES;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import INTERFACES.COMPUTER_TEMPLATE_INTERFACE;
import Util.INIT;
import Util.IPScanner;
import Util.MacAddressScanner;

public class DumbComputer extends DefaultComputer {
	static String IP;
	static String Name = "DEFAULT";
	static ArrayList<String> ActiveUsers = new ArrayList<String>();
	static String MacAddress;
	static ArrayList<String> OpenPorts = new ArrayList<String>();
	
	public DumbComputer(String ip) {
		super(ip);
	}
}
