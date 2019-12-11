package bddControl.dao;

import java.util.Collection;
import java.util.List;
import bddControl.Entity.Commentaire;
import bddControl.Entity.IpConnue;


public interface IpConnueDao {
	
	public List<IpConnue> getListIp();
	public IpConnue getbyIP(String ip);	
	public Collection<Commentaire> getCommentaires(IpConnue ip);
	public IpConnue addIP(IpConnue ip);			
	public void addVisite(String codeRdf, String ip);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
