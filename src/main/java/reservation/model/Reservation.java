package reservation.model;

import java.util.Date;

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
@Table(name = "RESERVATIONS")
public class Reservation {
	private int id;
	private Date date;
	private int numero;
	private boolean confirm = false;
	private int quantite_bagage;
	private boolean deleted = false;
	private int prix = 0;
	private Client client;
	private Passager passager;
	private Vol vol;
	private Siege siege;
	private Assurance assurance;
	private TypePlat plat;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int id, Date date, int numero, boolean confirm, boolean deleted, Client client,
			Passager passager, Vol vol) {
		super();
		this.id = id;
		this.date = date;
		this.numero = numero;
		this.confirm = confirm;
		this.deleted = deleted;
		this.client = client;
		this.passager = passager;
		this.vol = vol;
	}

	public Reservation(Date date, int numero, boolean confirm, boolean deleted, Client client, Passager passager,
			Vol vol) {
		super();
		this.date = date;
		this.numero = numero;
		this.confirm = confirm;
		this.deleted = deleted;
		this.client = client;
		this.passager = passager;
		this.vol = vol;
	}

	public Reservation(boolean confirm, Siege siege, Assurance assurance, TypePlat plat) {
		super();
		this.confirm = confirm;
		this.siege = siege;
		this.assurance = assurance;
		this.plat = plat;
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

	@Column(name = "DATE", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "NUMERO", unique = true, nullable = false)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Column(name = "QUANTITE_BAGAGE", nullable = true)
	public int getQuantite_bagage() {
		return quantite_bagage;
	}

	public void setQuantite_bagage(int quantite_bagage) {
		this.quantite_bagage = quantite_bagage;
	}

	@Column(name = "CONFIRM", nullable = false)
	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	
	@Column(name = "DELETED", nullable = false)
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	//many reservation to one client
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	@JoinColumn(name = "PASSAGER_ID", nullable = false)
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
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
	@JoinColumn(name = "SIEGE_ID", nullable = true)
	public Siege getSiege() {
		return siege;
	}

	public void setSiege(Siege siege) {
		this.siege = siege;
	}

	@ManyToOne
	@JoinColumn(name = "ASSURANCE_ID", nullable = true)
	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	@Enumerated(EnumType.STRING)
	public TypePlat getPlat() {
		return plat;
	}

	public void setPlat(TypePlat plat) {
		this.plat = plat;
	}

	@Column(name = "PRIX", nullable = true)
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
}
