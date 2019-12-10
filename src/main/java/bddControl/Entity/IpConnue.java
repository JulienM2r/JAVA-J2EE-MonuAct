package bddControl.Entity;

import java.io.Serializable;
import java.util.Collection;

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
public class IpConnue implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	private String IP;
	
	
	@ManyToMany(mappedBy="code",fetch=FetchType.LAZY)
	private Collection<MonumentBdd> monumentsBdd;
	
	public IpConnue() {
	}

	public IpConnue(String ip) {

		this.IP = ip;		
	}



	

	public Collection<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(Collection<Monument> monuments) {
		this.monuments = monuments;
	}
	
}
