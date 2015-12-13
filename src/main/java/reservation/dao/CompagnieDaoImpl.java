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

import reservation.model.Compagnie;

@Repository
@Transactional
public class CompagnieDaoImpl implements CompagnieDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Compagnie> list() throws Exception {
		logger.info("JdbcCompagnieDao: Getting list of all compagnies");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Compagnie");
        @SuppressWarnings("unchecked")
		List<Compagnie> compagnies = query.list();
        
            return compagnies;
        
	}

	@Override
	public void add(Compagnie a) throws Exception {
		logger.info("JdbcCompagnieDao: Adding a compagnie ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcCompagnieDao: Adding a compagnie with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcCompagnieDao: Compagnie doesn't added... ");
        }
	}

	@Override
	public void update(Compagnie a) throws Exception {
		logger.info("JdbcCompagnieDao: Updating a compagnie");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcCompagnieDao: Updating a compagnie with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcCompagnieDao: Compagnie doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcCompagnieDao: Deleting compagnie...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Compagnie set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcCompagnieDao: Deleting a compagnie with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcCompagnieDao: Compagnie doesn't deleted... ");
        }
	}

	@Override
	public List<Compagnie> find(String key) throws Exception {
		logger.info("JdbcCompagnieDao: finding compagnies...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Compagnie WHERE nom LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Compagnie> compagnies = query.list();
            logger.info("JdbcCompagnieDao: Finding a compagnie with success ... ");
            return compagnies;
        } catch (Exception e) {
        	logger.info("JdbcCompagnieDao: No compagnies found in the database");
            throw e;
        }
	}

	@Override
	public Compagnie getCompagnieById(int id) throws Exception {
		logger.info("JdbcCompagnieDao: find Compagnie by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Compagnie c=(Compagnie) session.get(Compagnie.class,id);
		return c;
	}

}
