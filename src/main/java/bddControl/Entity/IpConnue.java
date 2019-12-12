package bddControl.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class IpConnue implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Id
	@Column(length=20)
	private String IP;
	
//	@OneToMany //(mappedBy = "Commentaire", cascade = CascadeType.ALL)
//	@JoinColumns({@JoinColumn(name = "idIP", insertable=false, nullable=false), @JoinColumn(name = "IP", insertable=false, nullable=false)})
//	private Collection<Commentaire> commentaires;
//	
		
//	@ManyToMany
//	@JoinTable(name = "Visite", 
//	joinColumns = {@JoinColumn(name = "idIP", nullable=false, updatable=false), @JoinColumn(name = "IP", nullable=false, updatable=false)}, 
//    inverseJoinColumns = {@JoinColumn(name = "codeRDF", nullable=false, updatable=false), @JoinColumn(name = "idM", nullable=false, updatable=false)})
//	private Collection<MonumentBdd> monumentsVisites;
	
//	public void addMonumentBdd(MonumentBdd m) {
//		monumentsVisites.add(m);
//		m.getIps().add(this);
//	}
//	public void removeMonumentBdd(MonumentBdd m) {
//		monumentsVisites.remove(m);
//		m.getIps().remove(this);
//    }
	
	public IpConnue() {
	}

	public IpConnue(String ip) {

		this.IP = ip;		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
//	public Collection<MonumentBdd> getMonumentsVisites() {
//		return monumentsVisites;
//	}
//	public void setMonumentsVisites(Collection<MonumentBdd> monumentsVisites) {
//		this.monumentsVisites = monumentsVisites;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	public void setCommentaires(Collection<Commentaire> commentaires) {
//		this.commentaires = commentaires;
//	}
	


	


	
}
