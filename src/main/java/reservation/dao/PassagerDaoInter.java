package reservation.dao;

import java.util.List;

import reservation.model.Passager;

public interface PassagerDaoInter {
	public List<Passager> list() throws Exception;
    public void add(Passager a) throws Exception;
    public void update(Passager a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Passager> find(String key) throws Exception;
    public Passager getPassagerById(int id) throws Exception;
}
