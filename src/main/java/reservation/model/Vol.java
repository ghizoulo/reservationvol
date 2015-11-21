package reservation.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VOLS")
public class Vol {
	private int id;
	private Date dateDepart;
	private	Date dateArrivee;
	private Time heureDepart;
	private Time heureArrivee;
	private boolean deleted = false;
	private boolean open = true;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private Compagnie compagnie;
	private Set<Reservation> reservations = new HashSet<Reservation>();
	private Set<InfoEscale> infoEscales = new HashSet<InfoEscale>();
	private Set<Classe> classes = new HashSet<Classe>();

	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vol(Date dateDepart, Date dateArrivee, Time heureDepart, Time heureArrivee, boolean deleted,
			boolean open) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.deleted = deleted;
		this.open = open;
	}

	public Vol(int id, Date dateDepart, Date dateArrivee, Time heureDepart, Time heureArrivee, boolean deleted,
			boolean open) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.deleted = deleted;
		this.open = open;
	}

	public Vol(Date dateDepart, Date dateArrivee, Time heureDepart, Time heureArrivee, boolean deleted, boolean open,
			Aeroport aeroportDepart, Aeroport aeroportArrivee, Compagnie compagnie) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.deleted = deleted;
		this.open = open;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.compagnie = compagnie;
	}

	public Vol(Date dateDepart, Date dateArrivee, Time heureDepart, Time heureArrivee, boolean deleted, boolean open,
			Aeroport aeroportDepart, Aeroport aeroportArrivee, Compagnie compagnie, Set<Reservation> reservations,
			Set<InfoEscale> infoEscales, Set<Classe> classes) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.deleted = deleted;
		this.open = open;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.compagnie = compagnie;
		this.reservations = reservations;
		this.infoEscales = infoEscales;
		this.classes = classes;
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

	@Column(name = "DATE_DEPART", nullable = false)
	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Column(name = "DATE_ARRIVEE", nullable = false)
	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@Column(name = "HEURE_DEPART", nullable = false)
	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	@Column(name = "HEURE_ARRIVEE", nullable = false)
	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@Column(name = "OPEN", nullable = false)
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@OneToMany(mappedBy = "vol")
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@ManyToOne
	@JoinColumn(name = "AEROPORTDEPART_ID", nullable = false)
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	@ManyToOne
	@JoinColumn(name = "AEROPORTARRIVEE_ID", nullable = false)
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	@OneToMany(mappedBy = "vol")
	public Set<InfoEscale> getInfoEscales() {
		return infoEscales;
	}

	public void setInfoEscales(Set<InfoEscale> infoEscales) {
		this.infoEscales = infoEscales;
	}

	@ManyToOne
	@JoinColumn(name = "COMPAGNIE_ID", nullable = false)
	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@ManyToMany(mappedBy = "vols")
	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}
	
}
