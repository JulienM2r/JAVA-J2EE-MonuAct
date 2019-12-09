package org.o7planning.thymeleaf.dao;

import java.io.IOException;
import java.net.MalformedURLException;

import org.o7planning.thymeleaf.model.IP;
import org.springframework.stereotype.Service;

@Service
public class IpService {
	
		
	
	private java.util.Scanner scanner;




	public IP getIpService () throws Exception, IOException {
		IP ips;	
		scanner = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8");
		System.out.println("My c");
		
		try(java.util.Scanner s = scanner.useDelimiter("\\A")) {
	        while s.hasNext(){
	        	return ips = new IP(s.next().split("\\A")[0]);
	        }
			System.out.println("My current IPV4 address is " + s.next().split("\\A")[0]);
	         ips = new IP(s.next().split("\\A")[0]);       
	        
	    } catch (Exception e) {
	    	try(java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api6.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
		        System.out.println("My current IPV6 address is " + s.next());
		        return new IP(s.next());       
		        
		    } catch (Exception f) {
		    	f.printStackTrace();
		    	return ips = new IP();
		    }
		    
	    		        
	    }
		
	}
	
	
	
		
	public static void main(String[] args) throws Exception {
		IpService s = new IpService();
		System.out.println(s.getIpService().getIp());
		
	}
}

