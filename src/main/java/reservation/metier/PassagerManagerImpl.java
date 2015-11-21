package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.PassagerDaoInter;
import reservation.model.Passager;

@Service("passagerServiceImpl")
public class PassagerManagerImpl implements PassagerManager {

	@Autowired
    private PassagerDaoInter passagerDao;
	
	@Override
	public List<Passager> list() throws Exception {
		return passagerDao.list();
	}

	@Override
	public void add(Passager a) throws Exception {
		passagerDao.add(a);
	}

	@Override
	public void update(Passager a) throws Exception {
		passagerDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		passagerDao.delete(id);
	}

	@Override
	public List<Passager> find(String key) throws Exception {
		return passagerDao.find(key);
	}

	@Override
	public Passager getPassagerById(int id) throws Exception {
		return passagerDao.getPassagerById(id);
	}

}
