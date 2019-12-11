package bddControl.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {
	
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
	
	@ManyToOne
	@JoinColumn (name="ip")
	private IpConnue ip;
	public void setIP(IpConnue i) {ip = i;}
	public IpConnue getIP() {return ip;}
	
	@ManyToOne
	@JoinColumn (name="Monument")
	private MonumentBdd Monument;
	public void setMonument(MonumentBdd m) {Monument = m;}
	public MonumentBdd getMonument() {return Monument;}
	 
	
	private String commentairetext;
	
	private String codeMonument;

	public static void add(Commentaire c) {
		// TODO Auto-generated method stub
		
	}
	public Commentaire(long id, IpConnue iP, MonumentBdd monument, String commentairetext, String codeMonument) {
		this.id = id;
		ip = iP;
		Monument = monument;
		this.commentairetext = commentairetext;
		this.codeMonument = codeMonument;
	}
	public Commentaire() {
	}
	
	
}
