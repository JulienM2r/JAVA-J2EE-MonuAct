package bddControl.metier;

import bddControl.Entity.*;
//import bddControl.dao.CommentaireRepository;
//import bddControl.dao.IpConnueRepository;
//import bddControl.dao.MonumentBddRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IbddMetiers {
///////Partie IpConnue		
	public Collection<IpConnue> getListIp();
	public IpConnue getbyIP(String ip);	
//	public Collection<Commentaire> getCommentaires(IpConnue ip);
	public IpConnue addIP(IpConnue ip);			
//	public void addVisite(String codeRdf, String ip);
	
///////Partie Commentaires	
//	public Collection<Commentaire> getCommentairesbyIP(IpConnue ip1);	
	public Commentaire addCommentaire(Commentaire c);	
	public Collection<Commentaire> getListCommentaires();	
//	public Collection<Commentaire> getListCommentairesByMonument(MonumentBdd m1);	
	
///////Partie MonumentBdd
	
	public MonumentBdd getbyCode(String code);	
	public MonumentBdd addMonumentBdd(MonumentBdd m);	
	public Collection<MonumentBdd> getListMonuments();
	
}