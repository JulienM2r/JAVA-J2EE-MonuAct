package bddControl.dao;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import bddControl.Entity.Commentaire;
//import bddControl.Entity.IpConnue;
import bddControl.Entity.MonumentBdd;

@Repository
public class MonumentBddRepository implements MonumentBddDao{

	@PersistenceContext
	private EntityManager em;
	
	public MonumentBdd getbyCode(String code) {
		return em.find(MonumentBdd.class, code);
	}
	
	public MonumentBdd addMonumentBdd(MonumentBdd m) {
		em.persist(m);
		return m;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<MonumentBdd> getListMonuments() {
		Query req = em.createQuery("from MonumentBDD"); // JPQL
		return Collections.checkedList(req.getResultList(), MonumentBdd.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
