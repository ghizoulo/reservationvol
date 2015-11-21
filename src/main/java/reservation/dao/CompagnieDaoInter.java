package reservation.dao;

import java.util.List;

import reservation.model.Compagnie;

public interface CompagnieDaoInter {
	public List<Compagnie> list() throws Exception;
    public void add(Compagnie a) throws Exception;
    public void update(Compagnie a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Compagnie> find(String key) throws Exception;
    public Compagnie getCompagnieById(int id) throws Exception;
}
