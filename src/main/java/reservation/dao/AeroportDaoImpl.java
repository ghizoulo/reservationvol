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
import reservation.model.Aeroport;

@Repository
@Transactional
public class AeroportDaoImpl implements AeroportDaoInter {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	    
	@Override
	public List<Aeroport> list() throws Exception {
		logger.info("JdbcAeroportDao: Getting list of all aeroports");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Aeroport");
        @SuppressWarnings("unchecked")
		List<Aeroport> aeroports = query.list();
        
        if (aeroports.size() > 0) {
            return aeroports;
        } else {
            throw new Exception("JdbcAeroportDao: No aeroports found in the database");
        }
	}

	@Override
	public void add(Aeroport a) throws Exception {
		logger.info("JdbcAeroportDao: Adding a aeroport ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcAeroportDao: Adding a aeroport with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcAeroportDao: Aeroport doesn't added... ");
        }
	}

	@Override
	public void update(Aeroport a) throws Exception {
		logger.info("JdbcAeroportDao: Updating a aeroport");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcAeroportDao: Updating a aeroport with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcAeroportDao: Aeroport doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcAeroportDao: Deleting aeroport...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Aeroport set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcAeroportDao: Deleting a aeroport with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcAeroportDao: Aeroport doesn't deleted... ");
        }
	}

	@Override
	public List<Aeroport> find(String key) throws Exception {
		logger.info("JdbcAeroportDao: finding aeroports...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Aeroport WHERE nom LIKE :key OR ville LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Aeroport> aeroports = query.list();
            logger.info("JdbcAeroportDao: Finding a aeroport with success ... ");
            return aeroports;
        } catch (Exception e) {
        	logger.info("JdbcAeroportDao: No aeroports found in the database");
            throw e;
        }
	}

	@Override
	public Aeroport getAeroportById(int id) throws Exception {
		logger.info("JdbcAeroportDao: find Aeroport by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Aeroport c=(Aeroport) session.get(Aeroport.class,id);
		return c;
	}

}
