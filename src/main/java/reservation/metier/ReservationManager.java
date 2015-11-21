package reservation.metier;

import java.util.List;

import reservation.model.Reservation;

public interface ReservationManager {
	public List<Reservation> list() throws Exception;
    public void add(Reservation a) throws Exception;
    public void update(Reservation a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Reservation> find(String key) throws Exception;
    public Reservation getReservationById(int id) throws Exception;
}
