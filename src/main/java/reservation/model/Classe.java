package reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Classe {
	private int id;
	private TypeClasse nomClasse;
	private int prix;
	private boolean deleted = false;
	private Vol vol;
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(TypeClasse nomClasse, int prix, boolean deleted) {
		super();
		this.nomClasse = nomClasse;
		this.prix = prix;
		this.deleted = deleted;
	}
	public Classe(int id, TypeClasse nomClasse, int prix, boolean deleted) {
		super();
		this.id = id;
		this.nomClasse = nomClasse;
		this.prix = prix;
		this.deleted = deleted;
	}
	
	public Classe(TypeClasse nomClasse, int prix, boolean deleted, Vol vol) {
		super();
		this.nomClasse = nomClasse;
		this.prix = prix;
		this.deleted = deleted;
		this.vol = vol;
	}
	public Classe(int id, TypeClasse nomClasse, int prix, boolean deleted, Vol vol) {
		super();
		this.id = id;
		this.nomClasse = nomClasse;
		this.prix = prix;
		this.deleted = deleted;
		this.vol = vol;
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
	
	@Enumerated(EnumType.STRING)
	public TypeClasse getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(TypeClasse nomClasse) {
		this.nomClasse = nomClasse;
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
	
	@ManyToOne
	@JoinColumn(name = "VOL_ID", nullable = false)
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
}
