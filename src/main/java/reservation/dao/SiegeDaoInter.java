package reservation.dao;

import java.util.List;

import reservation.model.Siege;

public interface SiegeDaoInter {
	public List<Siege> list() throws Exception;
    public void add(Siege a) throws Exception;
    public void update(Siege a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Siege> find(String key) throws Exception;
    public Siege getSiegeById(int id) throws Exception;
}
