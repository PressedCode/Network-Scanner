package MultiThreaded_Functions;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import Util.IPScanner;

public class ScanAllIPs extends Thread{
	public static String host;
	public static int timeout=2000;
	
	public ScanAllIPs(String HOST) {
		host = HOST;
	}
	
	@Override
	public void run() {
		ReturnIPReachablity(host);
	}
	
	//uses multithreading to make network scanning faster
	private static void ReturnIPReachablity(String Host) {
		Socket sock = new Socket();
//		System.out.println(Host);
		try {
//			if (InetAddress.getByName(Host).isReachable(timeout)){
//				IPScanner.AllIPsList.add(Host);
//				IPScanner.ActiveMachineList.put(Host, InetAddress.getByName(Host).getHostName());
//		   }
			
			sock.connect(new InetSocketAddress(Host, 80), timeout);
		    if (sock.isConnected())
		      {
		         sock.close();
		         IPScanner.AllIPsList.add(Host);
		         IPScanner.ActiveMachineList.put(Host, InetAddress.getByName(Host).getHostName());
			}
		} catch (Exception e) {}
	}
}
