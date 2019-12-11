package bddControl.metier;

import bddControl.Entity.*;
import bddControl.dao.CommentaireRepository;
import bddControl.dao.IpConnueRepository;
import bddControl.dao.MonumentBddRepository;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class bddMetiers {
	
	private CommentaireRepository daoC;
	private IpConnueRepository daoIp;
	private MonumentBddRepository daoM;	
	

	public void setDaoC(CommentaireRepository daoC) {
		this.daoC = daoC;
	}
	public void setDaoIp(IpConnueRepository daoIp) {
		this.daoIp = daoIp;	
	}
	public void setDaoM(MonumentBddRepository daoM) {
		this.daoM = daoM;
	}
///////Partie IpConnue		
	public IpConnue addIP(IpConnue ip) {		
		return daoIp.addIP(ip);
	}
	public Commentaire addCommentaire(Commentaire c) {
		return daoC.addCommentaire(c);
	}	
	public void addVisite(String codeRdf, String ip) {
		daoIp.addVisite(codeRdf, ip);
	}
	public List<IpConnue> getListIp() {		
		return daoIp.getListIp();
	}
	
///////Partie MonumentBdd
	
	public MonumentBdd addMonumentBdd(MonumentBdd m) {
		return daoM.addMonumentBdd(m);
	}	
	
	
	public void addCommentaires(Commentaire c) {momumentCommentaires.add(c) ;}
	public Collection<Commentaire> getCommentaires() {return momumentCommentaires;}
	
	
	public void addMonumentBdd(MonumentBdd m) {monumentsVisites.add(m) ;}
	public Collection<MonumentBdd> getMonuments() {return monumentsVisites;}
	
	
	
	
}