package reservation.metier;

import java.util.List;

import reservation.model.Assurance;

public interface AssuranceManager {
	public List<Assurance> list() throws Exception;
    public void add(Assurance a) throws Exception;
    public void update(Assurance a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Assurance> find(String key) throws Exception;
    public Assurance getAssuranceById(int id) throws Exception;
}
