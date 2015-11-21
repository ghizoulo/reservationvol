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

import reservation.model.Classe;

@Repository
@Transactional
public class ClasseDaoImpl implements ClasseDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Classe> list() throws Exception {
		logger.info("JdbcClasseDao: Getting list of all classes");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Classe");
        @SuppressWarnings("unchecked")
		List<Classe> classes = query.list();
        
        if (classes.size() > 0) {
            return classes;
        } else {
            throw new Exception("JdbcClasseDao: No classes found in the database");
        }
	}

	@Override
	public void add(Classe a) throws Exception {
		logger.info("JdbcClasseDao: Adding a assurance ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcClasseDao: Adding a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcClasseDao: Classe doesn't added... ");
        }
	}

	@Override
	public void update(Classe a) throws Exception {
		logger.info("JdbcClasseDao: Updating a assurance");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcClasseDao: Updating a assurance with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcClasseDao: Classe doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcClasseDao: Deleting assurance...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Classe set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcClasseDao: Deleting a assurance with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcClasseDao: Classe doesn't deleted... ");
        }
	}

	@Override
	public List<Classe> find(String key) throws Exception {
		logger.info("JdbcClasseDao: finding classes...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Classe WHERE nom LIKE :key OR prix LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Classe> classes = query.list();
            logger.info("JdbcClasseDao: Finding a assurance with success ... ");
            return classes;
        } catch (Exception e) {
        	logger.info("JdbcClasseDao: No classes found in the database");
            throw e;
        }
	}

	@Override
	public Classe getClasseById(int id) throws Exception {
		logger.info("JdbcClasseDao: find Classe by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Classe c=(Classe) session.get(Classe.class,id);
		return c;
	}

}
