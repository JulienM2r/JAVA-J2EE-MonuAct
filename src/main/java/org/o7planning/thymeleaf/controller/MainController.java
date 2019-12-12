package org.o7planning.thymeleaf.controller;
import org.o7planning.thymeleaf.dao.GetCityLocService;
import org.o7planning.thymeleaf.dao.IpService;
import org.o7planning.thymeleaf.dao.RawDBDemoGeoIPLocationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import bddControl.Entity.*;
import bddControl.metier.IbddMetiers;

import org.o7planning.thymeleaf.dao.ReqMonument;
import org.o7planning.thymeleaf.dao.Req1Monument;
import org.o7planning.thymeleaf.form.PersonForm;
import org.o7planning.thymeleaf.model.GeoIP;
import org.o7planning.thymeleaf.model.Monument;
import org.o7planning.thymeleaf.model.Person;
import org.o7planning.thymeleaf.model.VilleLoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
 
    //private static List<Person> persons = new ArrayList<Person>();
    //private static ArrayList<Monument> monuments = new ArrayList<Monument>();
	@Autowired
	private IbddMetiers metier;
	@Autowired
	private IpService ipService;
	@Autowired
	private RawDBDemoGeoIPLocationService locationService;
	@Autowired
	private GetCityLocService locationVille;
	
    
     
   
    @Autowired
    private ReqMonument reqMonument;
    
    @Autowired
    private Req1Monument req1Monument;
    
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
    
//    @RequestMapping(value = "/index", method = RequestMethod.GET)  
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) throws Exception{    	
    	String latitud = "43.610769";
        String longitud = "3.876716";
    	model.addAttribute("message", message);
        if (ipService.getIpService() != null) {
        	String ips = ipService.getIpService().getIp();
            latitud = locationService.getLocation(ips).getLatitude();
            longitud = locationService.getLocation(ips).getLongitude();
        }    
        List<Monument> monuments = reqMonument.calculerAutour(latitud + " " + longitud);
        
        model.addAttribute("monuments", monuments);
        model.addAttribute("latitud", latitud);
        model.addAttribute("longitud", longitud);
            	
        
        
        return "index";
    }
    
//    @RequestMapping(value = "/carte", method = RequestMethod.GET)  
////  @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//    public String carte(Model model) {    	
//    	model.addAttribute("message", message);
//    	List<Monument> monuments = reqMonument.calculerAutour("3.876716 43.610769");
//    	model.addAttribute("monuments", monuments);
//      
//     
//      return "carte";
//  
//  }
    
    
    @RequestMapping(value = { "/monumentDetail/{code}" }, method = RequestMethod.GET)
    public String monumentList(Model model, @PathVariable String code) {
    	Map<String, String> unMonument = req1Monument.getMonumentRDF(code);    	
        model.addAttribute("unMonument", unMonument);
//        MonumentBdd m = metier.getbyCode(code);
//        Collection<Commentaire> Commentaires = metier.getListCommentairesByMonument(m);
//        model.addAttribute("Commentaires", Commentaires); 
        return "monumentDetail";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
    	
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        
        return "addPerson";
    } 
    

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)    
    public String index2(Model model, @RequestParam(value = "ipAddress", required = false) String ipAddress, @RequestParam(value = "ville", required = false) String ville) throws Exception {    	
    	if (ipAddress != null) {
    		model.addAttribute("ip", locationService.getLocation(ipAddress));
    		System.out.println(locationService.getLocation(ipAddress).getCity() + " / " + locationService.getLocation(ipAddress).getLatitude());
    	}    		
    	else if (ville != null) {
    		model.addAttribute("ville", locationVille.getLocation(ville));}
    		System.out.println(locationVille.getLocation(ville).getLatitude()); 
    	return "index";
    	}
        
}
