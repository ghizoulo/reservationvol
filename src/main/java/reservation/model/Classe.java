package reservation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Classe {
	private int id;
	private String nom;
	private int prix;
	private boolean deleted = false;
	private Set<Vol> vols = new HashSet<Vol>();
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(String nom, int prix, boolean deleted) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.deleted = deleted;
	}
	public Classe(int id, String nom, int prix, boolean deleted) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.deleted = deleted;
	}
	
	public Classe(String nom, int prix, boolean deleted, Set<Vol> vols) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.deleted = deleted;
		this.vols = vols;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NOM", unique = true, nullable = false, length = 50)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name = "PRIX", nullable = false)
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "CLASSES_VOLS",
	            joinColumns = @JoinColumn(name = "CLASSE_ID"),
	            inverseJoinColumns = @JoinColumn(name = "VOL_ID")
	    )
	public Set<Vol> getVols() {
		return vols;
	}
	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
	
}
