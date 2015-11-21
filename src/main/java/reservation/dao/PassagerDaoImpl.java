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

import reservation.model.Passager;

@Repository
@Transactional
public class PassagerDaoImpl implements PassagerDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Passager> list() throws Exception {
		logger.info("JdbcPassagerDao: Getting list of all passagers");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Passager");
        @SuppressWarnings("unchecked")
		List<Passager> passagers = query.list();
        
        if (passagers.size() > 0) {
            return passagers;
        } else {
            throw new Exception("JdbcPassagerDao: No passagers found in the database");
        }
	}

	@Override
	public void add(Passager a) throws Exception {
		logger.info("JdbcPassagerDao: Adding a passager ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcPassagerDao: Adding a passager with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcPassagerDao: Passager doesn't added... ");
        }
	}

	@Override
	public void update(Passager a) throws Exception {
		logger.info("JdbcPassagerDao: Updating a passager");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcPassagerDao: Updating a passager with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcPassagerDao: Passager doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcPassagerDao: Deleting passager...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Passager set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcPassagerDao: Deleting a passager with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcPassagerDao: Passager doesn't deleted... ");
        }
	}

	@Override
	public List<Passager> find(String key) throws Exception {
		logger.info("JdbcPassagerDao: finding passagers...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Passager WHERE type LIKE :key OR tarif LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Passager> passagers = query.list();
            logger.info("JdbcPassagerDao: Finding a passager with success ... ");
            return passagers;
        } catch (Exception e) {
        	logger.info("JdbcPassagerDao: No passagers found in the database");
            throw e;
        }
	}

	@Override
	public Passager getPassagerById(int id) throws Exception {
		logger.info("JdbcPassagerDao: find Passager by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Passager c=(Passager) session.get(Passager.class,id);
		return c;
	}

}
