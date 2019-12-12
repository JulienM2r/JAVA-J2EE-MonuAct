package bddControl.dao;

import java.util.Collection;
import bddControl.Entity.Commentaire;


public interface CommentaireDao {
	
	public Collection<Commentaire> getCommentairesbyIP(String ip);
	
	public Commentaire addCommentaire(Commentaire c);
	
	public Collection<Commentaire> getListCommentaires();
	
	public Collection<Commentaire> getListCommentairesByMonument(String codeRDF);
	
	
	
	
	
	
	
	
	
	
	
	

	

}
