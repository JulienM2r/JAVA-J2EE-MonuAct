package bddControl.Entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class MonumentBdd implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Id
	private String codeRDF;
	
	
//	@OneToMany(mappedBy="Monument")
//	private Collection<Commentaire> momumentCommentaires;
//	public void addCommentaires(Commentaire c) {momumentCommentaires.add(c) ;}
//	public Collection<Commentaire> getCommentaires() {return momumentCommentaires;}
	
//	@ManyToMany(mappedBy= "id",fetch=FetchType.LAZY)
//	private Collection<IpConnue> visitesBy;
//	public void addIp(IpConnue ip) {visitesBy.add(ip) ;}
//	public Collection<IpConnue> getIps() {return visitesBy;}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodeRDF() {
		return codeRDF;
	}
	public void setCodeRDF(String codeRDF) {
		this.codeRDF = codeRDF;
	}
//	public Collection<Commentaire> getMomumentCommentaires() {
//		return momumentCommentaires;
//	}
//	public void setMomumentCommentaires(Collection<Commentaire> momumentCommentaires) {
//		this.momumentCommentaires = momumentCommentaires;
//	}
//	public Collection<IpConnue> getVisitesBy() {
//		return visitesBy;
//	}
//	public void setVisitesBy(Collection<IpConnue> visitesBy) {
//		this.visitesBy = visitesBy;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MonumentBdd() {
	}

	public MonumentBdd(String codeRDF) {

		this.codeRDF = codeRDF;		
	}



	

	
	
}
