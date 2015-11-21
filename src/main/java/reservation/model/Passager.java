package reservation.model;

import java.util.Date;
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
@Table(name = "PASSAGERS")
public class Passager {
	private int id;
	private String nom;
	private String prenom;
	private String num_passport;
	private Date dateExpiration;
	private String nationalite;
	private boolean deleted = false;
	private Set<Reservation> reservations = new HashSet<Reservation>();

	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passager(String nom, String prenom, boolean deleted) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.deleted = deleted;
	}

	public Passager(int id, String nom, String prenom, boolean deleted) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.deleted = deleted;
	}

	public Passager(String nom, String prenom, Set<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.reservations = reservations;
	}

	public Passager(String num_passport, Date dateExpiration, String nationalite, Set<Reservation> reservations) {
		super();
		this.num_passport = num_passport;
		this.dateExpiration = dateExpiration;
		this.nationalite = nationalite;
		this.reservations = reservations;
	}

	public Passager(String num_passport, Date dateExpiration, String nationalite) {
		super();
		this.num_passport = num_passport;
		this.dateExpiration = dateExpiration;
		this.nationalite = nationalite;
	}

	public Passager(int id, String num_passport, Date dateExpiration, String nationalite) {
		super();
		this.id = id;
		this.num_passport = num_passport;
		this.dateExpiration = dateExpiration;
		this.nationalite = nationalite;
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

	@Column(name = "PRENOM", nullable = false, length = 50)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "NUM_PASSPORT", unique = true, nullable = true, length = 50)
	public String getNum_passport() {
		return num_passport;
	}

	public void setNum_passport(String num_passport) {
		this.num_passport = num_passport;
	}

	@Column(name = "DATE_EXPIRATION", nullable = true)
	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	@Column(name = "NATIONALITE", nullable = true, length = 50)
	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@OneToMany(mappedBy = "passager")
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
}
