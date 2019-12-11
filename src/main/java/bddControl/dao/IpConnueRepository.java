package bddControl.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bddControl.Entity.Commentaire;
import bddControl.Entity.IpConnue;
import bddControl.Entity.MonumentBdd;

@Repository
public class IpConnueRepository implements IpConnueDao{

	@Autowired
	private EntityManager em;
	
	public IpConnue getbyIP(String ip) {
		return em.find(IpConnue.class, ip);
	}
	
	public IpConnue addIP(IpConnue ip) {
		em.persist(ip);
		return ip;
	}
	
	public Collection<Commentaire> getCommentaires(IpConnue ip) {
		Query req = em.createQuery("select c from Commentaire m where c.ip =:x");
		req.setParameter("x", ip.getIP());		
		return req.getResultList();
	}	
	
	public void addVisite(String codeRdf, String ip) {
		// TODO Auto-generated method stub
		MonumentBdd m = em.find(MonumentBdd.class, codeRdf);
		IpConnue i = em.find(IpConnue.class, ip);
		i.addMonumentBdd(m);
	}
	public List<IpConnue> getListIp() {
		Query req = em.createQuery("from IpConnue"); // JPQL
		return req.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
