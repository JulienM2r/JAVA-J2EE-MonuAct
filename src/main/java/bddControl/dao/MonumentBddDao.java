package bddControl.dao;

import java.util.Collection;
import org.springframework.stereotype.Repository;
//import bddControl.Entity.IpConnue;
import bddControl.Entity.MonumentBdd;

@Repository
public interface MonumentBddDao {
	
	public MonumentBdd getbyCode(String code);
	
	public MonumentBdd addMonumentBdd(MonumentBdd m);
	
	public Collection<MonumentBdd> getListMonuments();
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
