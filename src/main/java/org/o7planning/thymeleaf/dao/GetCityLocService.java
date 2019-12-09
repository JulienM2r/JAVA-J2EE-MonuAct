package org.o7planning.thymeleaf.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.o7planning.thymeleaf.model.VilleLoc;
import org.springframework.stereotype.Service;

@Service
public class GetCityLocService {
	private FileReader c;
	private BufferedReader r;
	 
	
	public GetCityLocService() throws IOException{
    	c = new FileReader("/home/e20180012679/workspace/SpringBootThymeleaf/city_loc.csv"); 
	    r = new BufferedReader(c);
	}
	
	public VilleLoc getLocation(String input) throws IOException{    	
		
		VilleLoc newv = null;
		String line = r.readLine();
        
	    while (line != null) {
            if((line.split(";")[1] == input) || (line.split(";")[1] == input)) {
            	String cityName = line.split(";")[1];
            	String codePostal = line.split(";")[2];
            	String latitude = line.split(";")[5].split(",")[0];
      	        String longitude = line.split(";")[5].split(",")[1];
      	        newv =  new VilleLoc(codePostal, cityName, latitude, longitude);
      	        break;
            }
        } 
        r.close();
        return newv;
    } 
	
}

	
