package org.o7planning.thymeleaf.dao;

import java.io.IOException;
import java.net.MalformedURLException;

import org.o7planning.thymeleaf.model.IP;
import org.springframework.stereotype.Service;

@Service
public class IpService {
	
		
	
	private java.util.Scanner scanner;


	public IP getIpService () throws Exception {
		IP ips = new IP();	
//		scanner = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8");
//		System.out.println("My c");
		
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
		    //System.out.println(s.useDelimiter("\\A").next());
		    
		    ips.setIp(s.useDelimiter("\\A").next());
		} catch (Exception f) {
		    f.printStackTrace();
		}
		
		
	    return ips;		        
	    
		
	}
	
	
	
		
//	public static void main(String[] args) throws Exception {
//		IpService s = new IpService();
//		System.out.println("test :" + s.getIpService().getIp());
//		
//	}
}

