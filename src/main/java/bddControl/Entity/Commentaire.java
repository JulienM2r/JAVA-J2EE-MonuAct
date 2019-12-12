package bddControl.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numCom;
	
//	@ManyToOne	
//	@JoinColumns({@JoinColumn(name = "idCOM", insertable=false, nullable=false, updatable=false), @JoinColumn(name = "numCom", insertable=false, nullable=false, updatable=false)})
//	private IpConnue ip;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumCom() {
		return numCom;
	}
	public void setNumCom(long numCom) {
		this.numCom = numCom;
	}
//	public IpConnue getIp() {
//		return ip;
//	}
//	public void setIp(IpConnue ip) {
//		this.ip = ip;
//	}
	public String getCommentairetext() {
		return commentairetext;
	}
	public void setCommentairetext(String commentairetext) {
		this.commentairetext = commentairetext;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public void setIP(IpConnue i) {ip = i;}
//	public IpConnue getIP() {return ip;}
	
//	@ManyToOne
//	@JoinColumns({@JoinColumn(name = "numCom"), @JoinColumn(name = "id")})
//	private MonumentBdd Monument;
//	public void setMonument(MonumentBdd m) {Monument = m;}
//	public MonumentBdd getMonument() {return Monument;}
	 
	
	private String commentairetext;
	
	

	public Commentaire(String commentairetext) { //IpConnue ip, MonumentBdd monument, 
//		this.ip = ip;
//		this.Monument = monument;
		this.commentairetext = commentairetext;
	}
	public Commentaire() {
	}
	
	
}
