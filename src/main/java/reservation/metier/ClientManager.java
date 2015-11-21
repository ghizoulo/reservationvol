package reservation.metier;

import java.util.List;

import reservation.model.Client;

public interface ClientManager {
	public List<Client> list() throws Exception;
    public void add(Client a) throws Exception;
    public void update(Client a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Client> find(String key) throws Exception;
    public Client getClientById(int id) throws Exception;
}
