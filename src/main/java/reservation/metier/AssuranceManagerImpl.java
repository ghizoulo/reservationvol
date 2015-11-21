package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservation.dao.AssuranceDaoInter;
import reservation.model.Assurance;

@Service("assuranceServiceImpl")
public class AssuranceManagerImpl implements AssuranceManager {

	@Autowired
    private AssuranceDaoInter assuranceDao;
	
	@Override
	public List<Assurance> list() throws Exception {
		return assuranceDao.list();
	}

	@Override
	public void add(Assurance a) throws Exception {
		assuranceDao.add(a);
	}

	@Override
	public void update(Assurance a) throws Exception {
		assuranceDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		assuranceDao.delete(id);
	}

	@Override
	public List<Assurance> find(String key) throws Exception {
		return assuranceDao.find(key);
	}

	@Override
	public Assurance getAssuranceById(int id) throws Exception {
		return assuranceDao.getAssuranceById(id);
	}

}
