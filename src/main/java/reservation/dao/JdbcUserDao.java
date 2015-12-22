package reservation.dao;

import reservation.model.User;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JdbcUserDao implements UserDao{

    protected final Log logger = LogFactory.getLog(getClass());
    private Query query;
    
    @Autowired
	private SessionFactory sessionFactory;
    
    @Override
    public List<User> list() throws Exception{
        logger.info("JdbcUserDao: Getting list of all users");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM User");
        @SuppressWarnings("unchecked")
		List<User> users = query.list();
        
        return users;
    }
    
    @SuppressWarnings("null")
	@Override
    public User authenticate(User user) throws Exception{
        logger.info("JdbcUserDao: Authenticating...");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("FROM User WHERE login=:login AND password=:password")
                .setParameter("login", user.getLogin())
                .setParameter("password", user.getPassword());
        user=null;
        user = (User) query.uniqueResult();
        
        if(user != null)
            return user;
        else
            throw new Exception("JdbcUserDao: Authenticating failed. No such user with login="+user.getLogin()+" and password="+user.getPassword());
    }

    @Override
    public void add(User user) throws Exception {
        logger.info("JdbcUserDao: Adding user...");
        Session session=sessionFactory.getCurrentSession();
        try{
            session.save(user);
        }catch(Exception e){
            session.clear();
            throw new Exception("JdbcUserDao: The login already exists in the database");
        }
    }

    @Override
    public void update(User user) throws Exception{
        logger.info("JdbcUserDao: Updating user...");
        Session session=sessionFactory.getCurrentSession();
        try{
            session.update(user);
        }catch(Exception e){
            throw new Exception("JdbcUserDao: The login already exists in the database");
        }
    }
    
    @Override
    public void delete(User user){
        logger.info("JdbcUserDao: Deleting user...");
        Session session=sessionFactory.getCurrentSession();
        
        query = session.createQuery("DELETE User WHERE id=:id")
                .setParameter("id", user.getId());
        query.executeUpdate();
    }

    @Override
    public List<User> find(String keyword) throws Exception{
        logger.info("JdbcUserDao: Getting list of all users corresponding to " + keyword);
        Session session=sessionFactory.getCurrentSession();
        query = session.createQuery("FROM User WHERE lastname LIKE :keyword OR firstname LIKE :keyword OR email LIKE :keyword OR login LIKE :keyword OR  role LIKE :keyword")
                .setParameter("keyword", "%"+keyword+"%");
        @SuppressWarnings("unchecked")
		List<User> users = query.list();
        if(users.size() > 0)
            return users;
        else
            throw new Exception("JdbcUserDao: No users found in the database corresponding to " + keyword);
    }    
}
