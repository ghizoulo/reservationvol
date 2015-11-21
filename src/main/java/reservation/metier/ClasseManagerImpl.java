package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.ClasseDaoInter;
import reservation.model.Classe;

@Service("classeServiceImpl")
public class ClasseManagerImpl implements ClasseManager {

	@Autowired
    private ClasseDaoInter classeDao;
	
	@Override
	public List<Classe> list() throws Exception {
		return classeDao.list();
	}

	@Override
	public void add(Classe a) throws Exception {
		classeDao.add(a);
	}

	@Override
	public void update(Classe a) throws Exception {
		classeDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		classeDao.delete(id);
	}

	@Override
	public List<Classe> find(String key) throws Exception {
		return classeDao.find(key);
	}

	@Override
	public Classe getClasseById(int id) throws Exception {
		return classeDao.getClasseById(id);
	}

}
