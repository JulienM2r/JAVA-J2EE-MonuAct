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
public class CommentaireRepository {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public Collection<Commentaire> getCommentairesbyIP(IpConnue ip) {
		Query req = em.createQuery("select c from Commentaire c where c.ip =: x"); // JPQL
		req.setParameter("x", ip); 
		
		return Collections.checkedList(req.getResultList(), Commentaire.class);
	}
	
	public Commentaire addCommentaire(Commentaire c) {
		em.persist(c);
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Commentaire> getListCommentaires() {
		Query req = em.createQuery("from Commentaire"); // JPQL
		return Collections.checkedList(req.getResultList(), Commentaire.class);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Commentaire> getListCommentairesByMonument(MonumentBdd m) {
		Query req = em.createQuery("select c from Commentaire c where c.Monument =: x"); // JPQL
		req.setParameter("x", m);
		return Collections.checkedList(req.getResultList(), Commentaire.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	

}
