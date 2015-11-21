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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCES")
public class Assurance {
	private int id;
	private int tarif;
	private TypeAssurance type;
	private boolean deleted = false;
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	public Assurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assurance(int tarif, TypeAssurance type, boolean deleted) {
		super();
		this.tarif = tarif;
		this.type = type;
		this.deleted = deleted;
	}

	public Assurance(int id, int tarif, TypeAssurance type, boolean deleted) {
		super();
		this.id = id;
		this.tarif = tarif;
		this.type = type;
		this.deleted = deleted;
	}
	
	public Assurance(int tarif, TypeAssurance type, boolean deleted, Set<Reservation> reservations) {
		super();
		this.tarif = tarif;
		this.type = type;
		this.deleted = deleted;
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
	
	@Column(name = "TARIF", nullable = false)
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	
	@Enumerated(EnumType.STRING)
	public TypeAssurance getType() {
		return type;
	}
	public void setType(TypeAssurance type) {
		this.type = type;
	}
	
	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@OneToMany(mappedBy = "assurance")
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
