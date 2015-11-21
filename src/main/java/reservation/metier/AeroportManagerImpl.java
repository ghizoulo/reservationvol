package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservation.dao.AeroportDaoInter;
import reservation.model.Aeroport;

@Service("aeroportServiceImpl")
public class AeroportManagerImpl implements AeroportManager {

	@Autowired
    private AeroportDaoInter aeroportDao;
	
	@Override
	public List<Aeroport> list() throws Exception {
		return aeroportDao.list();
	}

	@Override
	public void add(Aeroport a) throws Exception {
		aeroportDao.add(a);
	}

	@Override
	public void update(Aeroport a) throws Exception {
		aeroportDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		aeroportDao.delete(id);
	}

	@Override
	public List<Aeroport> find(String key) throws Exception {
		return aeroportDao.find(key);
	}

	@Override
	public Aeroport getAeroportById(int id) throws Exception {
		return aeroportDao.getAeroportById(id);
	}

}
