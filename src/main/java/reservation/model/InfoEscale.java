package reservation.model;

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
	private String heureArrivee;
	private String heureDepart;
	private Vol vol;
	private Aeroport aeroport;
	
	public InfoEscale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoEscale(String heureArrivee, String heureDepart) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
	}
	public InfoEscale(int id, String heureArrivee, String heureDepart) {
		super();
		this.id = id;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
	}
	
	public InfoEscale(String heureArrivee, String heureDepart, Vol vol) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.vol = vol;
	}
	
	
	public InfoEscale(String heureArrivee, String heureDepart, Aeroport aeroport) {
		super();
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.aeroport = aeroport;
	}
	public InfoEscale(String heureArrivee, String heureDepart, Vol vol, Aeroport aeroport) {
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
	public String getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	@Column(name = "HEURE_DEPART", nullable = false)
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
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
