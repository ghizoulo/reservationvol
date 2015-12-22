package reservation.metier.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservation.dao.UserDao;
import reservation.model.User;

@Service("userServiceImpl")
public class UserManagerImpl implements UserManager {

	@Autowired
    private UserDao UserDao;
	
	@Override
	public List<User> list() throws Exception {
		return UserDao.list();
	}

	@Override
	public User authenticate(User user) throws Exception {
		return UserDao.authenticate(user);
	}

	@Override
	public void add(User user) throws Exception {
		UserDao.add(user);
	}

	@Override
	public void update(User user) throws Exception {
		UserDao.update(user);
	}

	@Override
	public void delete(User user) {
		UserDao.delete(user);
	}

	@Override
	public List<User> find(String keyword) throws Exception {
		return UserDao.find(keyword);
	}

}
