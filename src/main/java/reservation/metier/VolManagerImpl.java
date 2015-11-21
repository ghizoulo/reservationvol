package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.VolDaoInter;
import reservation.model.Vol;

@Service("volServiceImpl")
public class VolManagerImpl implements VolManager {

	@Autowired
    private VolDaoInter volDao;
	
	@Override
	public List<Vol> list() throws Exception {
		return volDao.list();
	}

	@Override
	public void add(Vol a) throws Exception {
		volDao.add(a);
	}

	@Override
	public void update(Vol a) throws Exception {
		volDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		volDao.delete(id);
	}

	@Override
	public List<Vol> find(String key) throws Exception {
		return volDao.find(key);
	}

	@Override
	public Vol getVolById(int id) throws Exception {
		return volDao.getVolById(id);
	}

}
