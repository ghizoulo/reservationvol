package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservation.dao.SiegeDaoInter;
import reservation.model.Siege;

@Service("siegeServiceImpl")
public class SiegeManagerImpl implements SiegeManager {

	@Autowired
    private SiegeDaoInter siegeDao;
	
	@Override
	public List<Siege> list() throws Exception {
		return siegeDao.list();
	}

	@Override
	public void add(Siege a) throws Exception {
		siegeDao.add(a);
	}

	@Override
	public void update(Siege a) throws Exception {
		siegeDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		siegeDao.delete(id);
	}

	@Override
	public List<Siege> find(String key) throws Exception {
		return siegeDao.find(key);
	}

	@Override
	public Siege getSiegeById(int id) throws Exception {
		return siegeDao.getSiegeById(id);
	}

}
