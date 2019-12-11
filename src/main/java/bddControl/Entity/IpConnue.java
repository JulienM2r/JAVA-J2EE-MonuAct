package bddControl.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private String IP;
	
	@OneToMany(mappedBy="IP")	
	private Collection<Commentaire> commentaires;
	public void addCommentaires(Commentaire c) {commentaires.add(c) ;}
	public Collection<Commentaire> getCommentaires() {return commentaires;}
	
		
	@ManyToMany(mappedBy="codeRDF",fetch=FetchType.LAZY)
	@JoinTable(name = "Visite", joinColumns = @JoinColumn(name = "IP"),
    inverseJoinColumns = @JoinColumn(name = "codeRDF"))
	private Collection<MonumentBdd> monumentsVisites;
	public void addMonumentBdd(MonumentBdd m) {monumentsVisites.add(m) ;}
	public Collection<MonumentBdd> getMonuments() {return monumentsVisites;}
	
	public IpConnue() {
	}

	public IpConnue(String ip) {

		this.IP = ip;		
	}



	


	
}
