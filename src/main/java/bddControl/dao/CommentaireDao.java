package bddControl.dao;

import java.util.List;
import bddControl.Entity.Commentaire;


public interface CommentaireDao {
	
	public Commentaire getbyIP(long numCom);
	
	public Commentaire addCommentaire(Commentaire c);
	
	public List<Commentaire> getListCommentaires();
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
