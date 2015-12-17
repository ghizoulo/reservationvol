package reservation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPAGNIES")
public class Compagnie {
	private int id;
	private String nom;
	private String PhotoName;
	private boolean deleted = false;
	private Set<Vol> vols = new HashSet<Vol>();
	
	public Compagnie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compagnie(String nom, boolean deleted) {
		super();
		this.nom = nom;
		this.deleted = deleted;
	}
	
	public Compagnie(String nom, String photoName, boolean deleted) {
		super();
		this.nom = nom;
		PhotoName = photoName;
		this.deleted = deleted;
	}
	public Compagnie(int id, String nom, boolean deleted) {
		super();
		this.id = id;
		this.nom = nom;
		this.deleted = deleted;
	}
	
	public Compagnie(String nom, boolean deleted, Set<Vol> vols) {
		super();
		this.nom = nom;
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
	
	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@OneToMany(mappedBy = "compagnie")
	public Set<Vol> getVols() {
		return vols;
	}
	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
	
	@Column(name = "PHOTONAME", nullable = true)
	public String getPhotoName() {
		return PhotoName;
	}
	public void setPhotoName(String photoName) {
		PhotoName = photoName;
	}
	
}
