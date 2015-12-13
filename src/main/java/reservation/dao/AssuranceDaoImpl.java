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

import reservation.model.Assurance;

@Repository
@Transactional
public class AssuranceDaoImpl implements AssuranceDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Assurance> list() throws Exception {
		logger.info("JdbcAssuranceDao: Getting list of all assurances");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Assurance");
        @SuppressWarnings("unchecked")
		List<Assurance> assurances = query.list();
        
            return assurances;
        
	}

	@Override
	public void add(Assurance a) throws Exception {
		logger.info("JdbcAssuranceDao: Adding a assurance ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcAssuranceDao: Adding a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcAssuranceDao: Assurance doesn't added... ");
        }
	}

	@Override
	public void update(Assurance a) throws Exception {
		logger.info("JdbcAssuranceDao: Updating a assurance");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcAssuranceDao: Updating a assurance with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcAssuranceDao: Assurance doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcAssuranceDao: Deleting assurance...");
        Session session=sessionFactory.getCurrentSession();
      
        try {
            query = session.createQuery("UPDATE Assurance set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcAssuranceDao: Deleting a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcAssuranceDao: Assurance doesn't deleted... ");
        }
	}

	@Override
	public List<Assurance> find(String key) throws Exception {
		logger.info("JdbcAssuranceDao: finding assurances...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Assurance WHERE type LIKE :key OR tarif LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Assurance> assurances = query.list();
            logger.info("JdbcAssuranceDao: Finding a assurance with success ... ");
            return assurances;
        } catch (Exception e) {
        	logger.info("JdbcAssuranceDao: No assurances found in the database");
            throw e;
        }
	}

	@Override
	public Assurance getAssuranceById(int id) throws Exception {
		logger.info("JdbcAssuranceDao: find Assurance by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Assurance c=(Assurance) session.get(Assurance.class,id);
		return c;
	}

}
