package reservation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SIEGES")
public class Siege {
	private int id;
	private boolean cote_fenetre;
	private PositionSiege position;
	private RangSiege rang;
	private boolean deleted = false;
	private Classe classe;
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	public Siege() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Siege(int id, boolean cote_fenetre, PositionSiege position, RangSiege rang, boolean deleted, Classe classe) {
		super();
		this.id = id;
		this.cote_fenetre = cote_fenetre;
		this.position = position;
		this.rang = rang;
		this.deleted = deleted;
		this.classe = classe;
	}
	public Siege(boolean cote_fenetre, PositionSiege position, RangSiege rang, boolean deleted, Classe classe) {
		super();
		this.cote_fenetre = cote_fenetre;
		this.position = position;
		this.rang = rang;
		this.deleted = deleted;
		this.classe = classe;
	}
	public Siege(boolean cote_fenetre, PositionSiege position, RangSiege rang, Classe classe) {
		super();
		this.cote_fenetre = cote_fenetre;
		this.position = position;
		this.rang = rang;
		this.classe = classe;
	}
	public Siege(boolean cote_fenetre, PositionSiege position, RangSiege rang, boolean deleted, Classe classe,
			Set<Reservation> reservations) {
		super();
		this.cote_fenetre = cote_fenetre;
		this.position = position;
		this.rang = rang;
		this.deleted = deleted;
		this.classe = classe;
		this.reservations = reservations;
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
	
	@Column(name = "COTE_FENETRE", nullable = false)
	public boolean isCote_fenetre() {
		return cote_fenetre;
	}
	public void setCote_fenetre(boolean cote_fenetre) {
		this.cote_fenetre = cote_fenetre;
	}
	
	@Enumerated(EnumType.STRING)
	public PositionSiege getPosition() {
		return position;
	}
	public void setPosition(PositionSiege position) {
		this.position = position;
	}
	
	@Enumerated(EnumType.STRING)
	public RangSiege getRang() {
		return rang;
	}
	public void setRang(RangSiege rang) {
		this.rang = rang;
	}
	
	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID", nullable = false)
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	@OneToMany(mappedBy = "siege")
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
