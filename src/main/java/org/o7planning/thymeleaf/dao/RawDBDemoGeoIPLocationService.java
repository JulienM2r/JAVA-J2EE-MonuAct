package org.o7planning.thymeleaf.dao;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import org.o7planning.thymeleaf.dao.*;

import org.o7planning.thymeleaf.model.GeoIP;
import org.springframework.stereotype.Service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

@Service
public class RawDBDemoGeoIPLocationService {
	private DatabaseReader dbReader;

    public RawDBDemoGeoIPLocationService() throws IOException {
        File database = new File("/home/e20180012679/workspace/GeoLite2-City_20191112/GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public GeoIP getLocation(String ip)
      throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude =
          response.getLocation().getLatitude().toString();
        String longitude =
          response.getLocation().getLongitude().toString();
        return new GeoIP(ip, cityName, latitude, longitude);
    }
    
}
