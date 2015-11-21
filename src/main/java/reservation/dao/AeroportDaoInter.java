package reservation.dao;

import java.util.List;

import reservation.model.Aeroport;


public interface AeroportDaoInter {
	public List<Aeroport> list() throws Exception;
    public void add(Aeroport a) throws Exception;
    public void update(Aeroport a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Aeroport> find(String key) throws Exception;
    public Aeroport getAeroportById(int id) throws Exception;
}
