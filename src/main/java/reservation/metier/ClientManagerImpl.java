package reservation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.dao.ClientDaoInter;
import reservation.model.Client;

@Service("clientServiceImpl")
public class ClientManagerImpl implements ClientManager {

	@Autowired
    private ClientDaoInter clientDao;
	
	@Override
	public List<Client> list() throws Exception {
		return clientDao.list();
	}

	@Override
	public void add(Client a) throws Exception {
		clientDao.add(a);
	}

	@Override
	public void update(Client a) throws Exception {
		clientDao.update(a);
	}

	@Override
	public void delete(int id) throws Exception {
		clientDao.delete(id);
	}

	@Override
	public List<Client> find(String key) throws Exception {
		return clientDao.find(key);
	}

	@Override
	public Client getClientById(int id) throws Exception {
		return clientDao.getClientById(id);
	}

}
