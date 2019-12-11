package bddControl.dao;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import bddControl.Entity.IpConnue;
import bddControl.Entity.MonumentBdd;

@Repository
public class MonumentBddRepository {

	@Autowired
	private EntityManager em;
	
	public MonumentBdd getbyCode(String code) {
		return em.find(MonumentBdd.class, code);
	}
	
	public MonumentBdd addMonumentBdd(MonumentBdd m) {
		em.persist(m);
		return m;
	}
	
	public List<MonumentBdd> getListMonuments() {
		Query req = em.createQuery("from MonumentBDD"); // JPQL
		return req.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
