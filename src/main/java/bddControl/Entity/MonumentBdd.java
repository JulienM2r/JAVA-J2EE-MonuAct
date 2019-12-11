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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	
	@OneToMany(mappedBy="Monument")
	private Collection<Commentaire> momumentCommentaires;
	public void addCommentaires(Commentaire c) {momumentCommentaires.add(c) ;}
	public Collection<Commentaire> getCommentaires() {return momumentCommentaires;}
	
	@ManyToMany(mappedBy="codeRDF",fetch=FetchType.LAZY)
	private Collection<MonumentBdd> monumentsVisites;
	public void addMonumentBdd(MonumentBdd m) {monumentsVisites.add(m) ;}
	public Collection<MonumentBdd> getMonuments() {return monumentsVisites;}
	
	
	public MonumentBdd() {
	}

	public MonumentBdd(String codeRDF) {

		this.codeRDF = codeRDF;		
	}



	

	
	
}
