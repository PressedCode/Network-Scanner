package MAIN;

import java.util.ArrayList;
import java.util.Arrays;

import COMPUTER_TEMPLATE_CLASSES.DefaultComputer;
import COMPUTER_TEMPLATE_CLASSES.DumbComputer;
import COMPUTER_TEMPLATE_CLASSES.SmartComputer;
import Util.*;

public class Main {
	public static ArrayList<SmartComputer> SmartComputerList = new ArrayList<SmartComputer>();
	public static ArrayList<DumbComputer> DumbComputerList = new ArrayList<DumbComputer>();
	public static ArrayList<DefaultComputer> DefaultComputerList = new ArrayList<DefaultComputer>();
	public static ArrayList<String> IPList = new ArrayList<String>();
	
	public static void main(String[] args) {
		INIT.main(args);
//		IPList = IPScanner.ScanAll();
//		System.out.println(INIT.UserDeviceIP);
		
		NetworkSniffer.CallNetworkSniffer(INIT.UserDeviceIP.get(2), 80);
//		System.out.println(MacAddressScanner.ReturnMacAddress(INIT.UserDeviceIP.get(0)));
//		System.out.println(PortScanner.ScanAllPorts(IPList.get(1)));
		
		System.out.println();
		for (int i = 0; i < IPList.size(); i++) {
			DefaultComputerList.add(new DefaultComputer(String.valueOf(IPList.get(i))));
			System.out.print("(" + DefaultComputerList.get(i).FetchName() + ", " + DefaultComputerList.get(i).FetchActiveUsers() + ", " + DefaultComputerList.get(i).IP + "), ");
		}
	}
}
