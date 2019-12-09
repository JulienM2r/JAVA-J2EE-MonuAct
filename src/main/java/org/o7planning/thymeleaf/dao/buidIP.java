package org.o7planning.thymeleaf.dao;



import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
	
public class buidIP {
	public void givenIP__whenFetchingCity__thenReturnsCityData()
			  throws IOException, GeoIp2Exception {
			    String ip = "162.38.151.23";
			    String dbLocation = "/home/e20180012679/workspace/GeoLite2-City_20191112/GeoLite2-City.mmdb";

			    File database = new File(dbLocation);
			    DatabaseReader dbReader = new DatabaseReader.Builder(database)
			      .build();

			    InetAddress ipAddress = InetAddress.getByName(ip);
			    CityResponse response = dbReader.city(ipAddress);

			    String countryName = response.getCountry().getName();
			    String cityName = response.getCity().getName();
			    String postal = response.getPostal().getCode();
			    String state = response.getLeastSpecificSubdivision().getName();
			}
	
}
