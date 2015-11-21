package reservation.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import reservation.model.Reservation;

@Repository
@Transactional
public class ReservationDaoImpl implements ReservationDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Reservation> list() throws Exception {
		logger.info("JdbcReservationDao: Getting list of all reservations");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Reservation");
        @SuppressWarnings("unchecked")
		List<Reservation> reservations = query.list();
        
        if (reservations.size() > 0) {
            return reservations;
        } else {
            throw new Exception("JdbcReservationDao: No reservations found in the database");
        }
	}

	@Override
	public void add(Reservation a) throws Exception {
		logger.info("JdbcReservationDao: Adding a reservation ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcReservationDao: Adding a reservation with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcReservationDao: Reservation doesn't added... ");
        }
	}

	@Override
	public void update(Reservation a) throws Exception {
		logger.info("JdbcReservationDao: Updating a reservation");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcReservationDao: Updating a reservation with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcReservationDao: Reservation doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcReservationDao: Deleting reservation...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Reservation set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcReservationDao: Deleting a reservation with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcReservationDao: Reservation doesn't deleted... ");
        }
	}

	@Override
	public List<Reservation> find(String key) throws Exception {
		logger.info("JdbcReservationDao: finding reservations...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Reservation WHERE type LIKE :key OR tarif LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Reservation> reservations = query.list();
            logger.info("JdbcReservationDao: Finding a reservation with success ... ");
            return reservations;
        } catch (Exception e) {
        	logger.info("JdbcReservationDao: No reservations found in the database");
            throw e;
        }
	}

	@Override
	public Reservation getReservationById(int id) throws Exception {
		logger.info("JdbcReservationDao: find Reservation by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Reservation c=(Reservation) session.get(Reservation.class,id);
		return c;
	}

}
