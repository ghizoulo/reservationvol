package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.InfoEscaleDaoInter;
import reservation.model.InfoEscale;

@Service("infoEscaleServiceImpl")
public class InfoEscaleManagerImpl implements InfoEscaleManager {

	@Autowired
    private InfoEscaleDaoInter infoEscaleDao;
	
	@Override
	public List<InfoEscale> list() throws Exception {
		return infoEscaleDao.list();
	}

	@Override
	public void add(InfoEscale a) throws Exception {
		infoEscaleDao.add(a);
	}

	@Override
	public void update(InfoEscale a) throws Exception {
		infoEscaleDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		infoEscaleDao.delete(id);
	}

	@Override
	public List<InfoEscale> find(String key) throws Exception {
		return infoEscaleDao.find(key);
	}

	@Override
	public InfoEscale getInfoEscaleById(int id) throws Exception {
		return infoEscaleDao.getInfoEscaleById(id);
	}

}
