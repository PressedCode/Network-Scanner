package Util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacAddressScanner {
	//uses IP to find a devices MacAddress
	public static String ReturnMacAddress(String IP) {
		String MacAddress;
		byte[] MacAddressRaw;
		InetAddress ip;
		
		try {
			ip = InetAddress.getByName(IP);
			MacAddressRaw = NetworkInterface.getByInetAddress(ip).getHardwareAddress();			
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < MacAddressRaw.length; i++) {
				sb.append(String.format("%02X%s", MacAddressRaw[i], (i < MacAddressRaw.length - 1) ? "-" : "")).toString();
	        }
			MacAddress = sb.toString();
		} catch (Exception e1) {MacAddress = null;}
		
		return MacAddress;
	}
}
