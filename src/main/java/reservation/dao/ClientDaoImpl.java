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

import reservation.model.Client;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDaoInter {

	protected final Log logger = LogFactory.getLog(getClass());
	private Query query;
	    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Client> list() throws Exception {
		logger.info("JdbcClientDao: Getting list of all clients");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM Client");
        @SuppressWarnings("unchecked")
		List<Client> clients = query.list();
        
        if (clients.size() > 0) {
            return clients;
        } else {
            throw new Exception("JdbcClientDao: No clients found in the database");
        }
	}

	@Override
	public void add(Client a) throws Exception {
		logger.info("JdbcClientDao: Adding a client ... ");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.save(a);
            logger.info("JdbcClientDao: Adding a client with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcClientDao: Client doesn't added... ");
        }
	}

	@Override
	public void update(Client a) throws Exception {
		logger.info("JdbcClientDao: Updating a client");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            session.update(a);
            logger.info("JdbcClientDao: Updating a client with success ... ");
        } catch (Exception e) {
        	session.clear();
            logger.info("JdbcClientDao: Client doesn't updated... ");
        }
	}

	@Override
	public void delete(int id) throws Exception {
		logger.info("JdbcClientDao: Deleting client...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            query = session.createQuery("UPDATE Client set DELETED = true WHERE id=:id")
                    .setParameter("id", id);
            query.executeUpdate();
            logger.info("JdbcClientDao: Deleting a client with success ... ");
        } catch (Exception e) {
            session.clear();
            logger.info("JdbcClientDao: Client doesn't deleted... ");
        }
	}

	@Override
	public List<Client> find(String key) throws Exception {
		logger.info("JdbcClientDao: finding clients...");
        Session session=sessionFactory.getCurrentSession();
        
        try {
            
            query = session.createQuery("FROM Client WHERE nom LIKE :key OR adresse LIKE :key OR mail LIKE :key OR telephone LIKE :key")
                    .setParameter("key", "%" + key + "%");
            @SuppressWarnings("unchecked")
			List<Client> clients = query.list();
            logger.info("JdbcClientDao: Finding a client with success ... ");
            return clients;
        } catch (Exception e) {
        	logger.info("JdbcClientDao: No clients found in the database");
            throw e;
        }
	}

	@Override
	public Client getClientById(int id) throws Exception {
		logger.info("JdbcClientDao: find Client by id...");
        Session session=sessionFactory.getCurrentSession();
        
        Client c=(Client) session.get(Client.class,id);
		return c;
	}

}
