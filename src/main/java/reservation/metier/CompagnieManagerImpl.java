package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.CompagnieDaoInter;
import reservation.model.Compagnie;

@Service("compagnieServiceImpl")
public class CompagnieManagerImpl implements CompagnieManager {

	@Autowired
    private CompagnieDaoInter compagnieDao;
	
	@Override
	public List<Compagnie> list() throws Exception {
		return compagnieDao.list();
	}

	@Override
	public void add(Compagnie a) throws Exception {
		compagnieDao.add(a);
	}

	@Override
	public void update(Compagnie a) throws Exception {
		compagnieDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		compagnieDao.delete(id);
	}

	@Override
	public List<Compagnie> find(String key) throws Exception {
		return compagnieDao.find(key);
	}

	@Override
	public Compagnie getCompagnieById(int id) throws Exception {
		return compagnieDao.getCompagnieById(id);
	}

}
