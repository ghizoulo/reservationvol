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

import reservation.model.Vol;

@Repository
@Transactional
public class VolDaoImpl implements VolDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Vol> list() throws Exception {
		logger.info("JdbcVolDao: Getting list of all vols");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Vol");
        @SuppressWarnings("unchecked")
		List<Vol> vols = query.list();
        
        if (vols.size() > 0) {
            return vols;
        } else {
            throw new Exception("JdbcVolDao: No vols found in the database");
        }
	}

	@Override
	public void add(Vol a) throws Exception {
		logger.info("JdbcVolDao: Adding a vol ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcVolDao: Adding a vol with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcVolDao: Vol doesn't added... ");
        }
	}

	@Override
	public void update(Vol a) throws Exception {
		logger.info("JdbcVolDao: Updating a vol");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcVolDao: Updating a vol with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcVolDao: Vol doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcVolDao: Deleting vol...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Vol set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcVolDao: Deleting a vol with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcVolDao: Vol doesn't deleted... ");
        }
	}

	@Override
	public List<Vol> find(String key) throws Exception {
		logger.info("JdbcVolDao: finding vols...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Vol WHERE type LIKE :key OR tarif LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Vol> vols = query.list();
            logger.info("JdbcVolDao: Finding a vol with success ... ");
            return vols;
        } catch (Exception e) {
        	logger.info("JdbcVolDao: No vols found in the database");
            throw e;
        }
	}

	@Override
	public Vol getVolById(int id) throws Exception {
		logger.info("JdbcVolDao: find Vol by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Vol c=(Vol) session.get(Vol.class,id);
		return c;
	}

}
