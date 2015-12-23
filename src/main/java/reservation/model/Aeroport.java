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
@Table(name = "AEROPORTS")
public class Aeroport {
	private int id;
	private String nom;
	private String ville;
	private boolean deleted = false;
	private Set<Vol> volDeparts = new HashSet<Vol>();
	private Set<Vol> volArrivees = new HashSet<Vol>();
	private Set<InfoEscale> infoEscales = new HashSet<InfoEscale>();

	public Aeroport() {
		super();
	}

	public Aeroport(int id, String nom, String ville, boolean deleted) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.deleted = deleted;
	}

	public Aeroport(String nom, String ville, boolean deleted) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.deleted = deleted;
	}

	public Aeroport(String nom, String ville, boolean deleted, Set<Vol> volDeparts, Set<Vol> volArrivees,
			Set<InfoEscale> infoEscales) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.deleted = deleted;
		this.volDeparts = volDeparts;
		this.volArrivees = volArrivees;
		this.infoEscales = infoEscales;
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

	@Column(name = "NOM", nullable = false, length = 50)
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

	@OneToMany(mappedBy = "aeroportDepart")
	public Set<Vol> getVolDeparts() {
		return volDeparts;
	}

	public void setVolDeparts(Set<Vol> volDeparts) {
		this.volDeparts = volDeparts;
	}

	@OneToMany(mappedBy = "aeroportArrivee")
	public Set<Vol> getVolArrivees() {
		return volArrivees;
	}

	public void setVolArrivees(Set<Vol> volArrivees) {
		this.volArrivees = volArrivees;
	}

	@OneToMany(mappedBy = "aeroport")
	public Set<InfoEscale> getInfoEscales() {
		return infoEscales;
	}

	public void setInfoEscales(Set<InfoEscale> infoEscales) {
		this.infoEscales = infoEscales;
	}

	@Column(name = "VILLE", nullable = false, length = 50)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
