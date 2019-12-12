package bddControl.dao;

import java.util.Collection;
import java.util.Collections;

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

	@PersistenceContext
	private EntityManager em;
	
	public IpConnue getbyIP(String ip) {
		return em.find(IpConnue.class, ip);
	}
	
	public IpConnue addIP(IpConnue ip) {
		em.persist(ip);
		return ip;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Commentaire> getCommentaires(IpConnue ip) {
		Query req = em.createQuery("select c from Commentaire m where c.ip =:x");
		req.setParameter("x", ip.getIP());		
		return Collections.checkedList(req.getResultList(), Commentaire.class);		
		}	
//		Collections.checkedList(sf.getEntries(), SyndEntry.class)
			
//	public void addVisite(String codeRdf, String ip) {
//		// TODO Auto-generated method stub
//		MonumentBdd m = em.find(MonumentBdd.class, codeRdf);
//		IpConnue i = em.find(IpConnue.class, ip);
//		i.addMonumentBdd(m);
//	}
//	
//	public void addMonumentBdd(MonumentBdd m) {
//		monumentsVisites.add(m);
//		m.getIps().add(this);
//	}
//	public void removeMonumentBdd(MonumentBdd m) {
//		monumentsVisites.remove(m);
//		m.getIps().remove(this);
//    }
	@SuppressWarnings("unchecked")
	public Collection<IpConnue> getListIp() {
		Query req = em.createQuery("from IpConnue"); // JPQL
		return Collections.checkedList(req.getResultList(), IpConnue.class);
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
