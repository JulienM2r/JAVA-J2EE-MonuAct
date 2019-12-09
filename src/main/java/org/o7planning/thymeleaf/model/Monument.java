package org.o7planning.thymeleaf.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Monument {
	
//	private Map<String, String> properties = new HashMap<String, String>();
//    private Map<String, Callable<Object>> callables = new HashMap<String, Callable<Object>>();
//    
//    public String getProperty(String key) {
//        return properties.get(key);
//    }
//
//    public void setProperty(String key, String value) {
//        properties.put(key, value);
//    }
//
//    public Object call(String key) throws Exception {
//        Callable<Object> callable = callables.get(key);
//        if (callable != null) {
//            return callable.call();
//        }
//        return null;
//    }
//
//    public void define(String key, Callable<Object> callable) {
//        callables.put(key, callable);
//    }
//	
	
	
	
	private String monument;
	private String monumentLabel;    
    private String heritageLabel;
    private String image;
    private String Long;
    private String Lat;
    
 
    

	public Monument() {
 
    }    
 
    public Monument(String monument, String monumentLabel, String heritageLabel, String image, String l, String lat) {
		this.monument = monument;
		this.monumentLabel = monumentLabel;
		this.heritageLabel = heritageLabel;
		this.image = image;
		Long = l;
		Lat = lat;
	}

	public Monument(String monument, String monumentLabel, String heritageLabel, String l, String lat) {
		this.monument = monument;
		this.monumentLabel = monumentLabel;
		this.heritageLabel = heritageLabel;
		Long = l;
		Lat = lat;
	}
	
	public String getLong() {
		return Long;
	}

	public void setLong(String l) {
		Long = l;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getMonument() {
		return monument;
	}

	public void setMonument(String monument) {
		this.monument = monument;
	}

	public String getMonumentLabel() {
		return monumentLabel;
	}

	public void setMonumentLabel(String monumentLabel) {
		this.monumentLabel = monumentLabel;
	}

	public String getHeritageLabel() {
		return heritageLabel;
	}

	public void setHeritageLabel(String heritageLabel) {
		this.heritageLabel = heritageLabel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	@Override
	public String toString() {
		return "Monument [monument=" + monument + ", monumentLabel=" + monumentLabel + ", heritageLabel="
				+ heritageLabel + ", image=" + image + ", Long=" + Long + ", Lat=" + Lat + "]";
	}

    

	
	
}
