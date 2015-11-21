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

import reservation.model.InfoEscale;

@Repository
@Transactional
public class InfoEscaleDaoImpl implements InfoEscaleDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<InfoEscale> list() throws Exception {
		logger.info("JdbcInfoEscaleDao: Getting list of all infoEscales");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM InfoEscale");
        @SuppressWarnings("unchecked")
		List<InfoEscale> infoEscales = query.list();
        
        if (infoEscales.size() > 0) {
            return infoEscales;
        } else {
            throw new Exception("JdbcInfoEscaleDao: No infoEscales found in the database");
        }
	}

	@Override
	public void add(InfoEscale a) throws Exception {
		logger.info("JdbcInfoEscaleDao: Adding a assurance ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcInfoEscaleDao: Adding a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcInfoEscaleDao: InfoEscale doesn't added... ");
        }
	}

	@Override
	public void update(InfoEscale a) throws Exception {
		logger.info("JdbcInfoEscaleDao: Updating a assurance");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcInfoEscaleDao: Updating a assurance with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcInfoEscaleDao: InfoEscale doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcInfoEscaleDao: Deleting assurance...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE InfoEscale set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcInfoEscaleDao: Deleting a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcInfoEscaleDao: InfoEscale doesn't deleted... ");
        }
	}

	@Override
	public List<InfoEscale> find(String key) throws Exception {
		logger.info("JdbcInfoEscaleDao: finding infoEscales...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM InfoEscale WHERE heureArrivee LIKE :key OR heureDepart LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<InfoEscale> infoEscales = query.list();
            logger.info("JdbcInfoEscaleDao: Finding a assurance with success ... ");
            return infoEscales;
        } catch (Exception e) {
        	logger.info("JdbcInfoEscaleDao: No infoEscales found in the database");
            throw e;
        }
	}

	@Override
	public InfoEscale getInfoEscaleById(int id) throws Exception {
		logger.info("JdbcInfoEscaleDao: find InfoEscale by id...");
        Session session=sessionFactory.getCurrentSession();
        
        InfoEscale c=(InfoEscale) session.get(InfoEscale.class,id);
		return c;
	}

}
