package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.ReservationDaoInter;
import reservation.model.Reservation;

@Service("reservationServiceImpl")
public class ReservationManagerImpl implements ReservationManager {

	@Autowired
    private ReservationDaoInter reservationDao;
	
	@Override
	public List<Reservation> list() throws Exception {
		return reservationDao.list();
	}

	@Override
	public void add(Reservation a) throws Exception {
		reservationDao.add(a);
	}

	@Override
	public void update(Reservation a) throws Exception {
		reservationDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		reservationDao.delete(id);
	}

	@Override
	public List<Reservation> find(String key) throws Exception {
		return reservationDao.find(key);
	}

	@Override
	public Reservation getReservationById(int id) throws Exception {
		return reservationDao.getReservationById(id);
	}

}
