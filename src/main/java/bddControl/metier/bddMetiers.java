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
public class bddMetiers implements IbddMetiers {
	
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
	@Override
	public Collection<IpConnue> getListIp() {
		return daoIp.getListIp();
	}
	@Override
	public IpConnue getbyIP(String ip) {
		return daoIp.getbyIP(ip);
	}
//	@Override
//	public Collection<Commentaire> getCommentaires(IpConnue ip) {
//		return daoIp.getCommentaires(ip);
//	}
	@Override
	public IpConnue addIP(IpConnue ip) {
		return daoIp.addIP(ip);
	}
//	@Override
//	public void addVisite(String codeRdf, String ip) {
//		daoIp.addVisite(codeRdf, ip);
//	}
///////Partie Commentaires
//	@Override
//	public Collection<Commentaire> getCommentairesbyIP(IpConnue ip) {
//		return daoC.getCommentairesbyIP(ip);
//	}
	@Override
	public Commentaire addCommentaire(Commentaire c) {
		return daoC.addCommentaire(c);
	}
	@Override
	public Collection<Commentaire> getListCommentaires() {
		return daoC.getListCommentaires();
	}
//	@Override
//	public Collection<Commentaire> getListCommentairesByMonument(MonumentBdd m) {
//		return daoC.getListCommentairesByMonument(m);
//	}
///////Partie MonumentBdd
	@Override
	public MonumentBdd getbyCode(String code) {
		return daoM.getbyCode(code);
	}
	@Override
	public MonumentBdd addMonumentBdd(MonumentBdd m) {
		return daoM.addMonumentBdd(m);
	}
	@Override
	public Collection<MonumentBdd> getListMonuments() {
		return daoM.getListMonuments();
	}
	
	
	
	

	

	
}