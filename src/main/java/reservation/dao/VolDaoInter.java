package reservation.dao;

import java.util.List;

import reservation.model.Vol;

public interface VolDaoInter {
	public List<Vol> list() throws Exception;
    public void add(Vol a) throws Exception;
    public void update(Vol a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Vol> find(String key) throws Exception;
    public Vol getVolById(int id) throws Exception;
}
