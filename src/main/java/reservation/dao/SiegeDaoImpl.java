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

import reservation.model.Siege;

@Repository
@Transactional
public class SiegeDaoImpl implements SiegeDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Siege> list() throws Exception {
		logger.info("JdbcSiegeDao: Getting list of all sieges");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Siege");
        @SuppressWarnings("unchecked")
		List<Siege> sieges = query.list();
        
        if (sieges.size() > 0) {
            return sieges;
        } else {
            throw new Exception("JdbcSiegeDao: No sieges found in the database");
        }
	}

	@Override
	public void add(Siege a) throws Exception {
		logger.info("JdbcSiegeDao: Adding a siege ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcSiegeDao: Adding a siege with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcSiegeDao: Siege doesn't added... ");
        }
	}

	@Override
	public void update(Siege a) throws Exception {
		logger.info("JdbcSiegeDao: Updating a siege");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcSiegeDao: Updating a siege with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcSiegeDao: Siege doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcSiegeDao: Deleting siege...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Siege set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcSiegeDao: Deleting a siege with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcSiegeDao: Siege doesn't deleted... ");
        }
	}

	@Override
	public List<Siege> find(String key) throws Exception {
		logger.info("JdbcSiegeDao: finding sieges...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Siege WHERE type LIKE :key OR tarif LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Siege> sieges = query.list();
            logger.info("JdbcSiegeDao: Finding a siege with success ... ");
            return sieges;
        } catch (Exception e) {
        	logger.info("JdbcSiegeDao: No sieges found in the database");
            throw e;
        }
	}

	@Override
	public Siege getSiegeById(int id) throws Exception {
		logger.info("JdbcSiegeDao: find Siege by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Siege c=(Siege) session.get(Siege.class,id);
		return c;
	}

}
