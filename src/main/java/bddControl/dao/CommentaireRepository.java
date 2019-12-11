package bddControl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bddControl.Entity.Commentaire;


@Repository
public class CommentaireRepository {

	@Autowired
	private EntityManager em;
	
	public Commentaire getbyIP(long numCom) {
		return em.find(Commentaire.class, numCom);
	}
	
	public Commentaire addCommentaire(Commentaire c) {
		em.persist(c);
		return c;
	}
	
	public List<Commentaire> getListCommentaires() {
		Query req = em.createQuery("from Commentaire"); // JPQL
		return req.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
