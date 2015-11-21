package reservation.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INFOESCALES")
public class InfoEscale {
	private int id;
	private Time heureArrivee;
	private Time heureDepart;
	private Vol vol;
	private Aeroport aeroport;
	
	public InfoEscale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoEscale(Time heureArrivee, Time heureDepart) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
	}
	public InfoEscale(int id, Time heureArrivee, Time heureDepart) {
		super();
		this.id = id;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
	}
	
	public InfoEscale(Time heureArrivee, Time heureDepart, Vol vol) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.vol = vol;
	}
	
	
	public InfoEscale(Time heureArrivee, Time heureDepart, Aeroport aeroport) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.aeroport = aeroport;
	}
	public InfoEscale(Time heureArrivee, Time heureDepart, Vol vol, Aeroport aeroport) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.vol = vol;
		this.aeroport = aeroport;
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
	
	@Column(name = "HEURE_ARRIVEE", nullable = false)
	public Time getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	@Column(name = "HEURE_DEPART", nullable = false)
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	@ManyToOne
    @JoinColumn(name = "VOL_ID", nullable = false)  
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	@ManyToOne
    @JoinColumn(name = "AEROPORT_ID", nullable = false)  
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	
}
