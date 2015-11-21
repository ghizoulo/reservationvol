package reservation.metier;

import java.util.List;

import reservation.model.Classe;

public interface ClasseManager {
	public List<Classe> list() throws Exception;
    public void add(Classe a) throws Exception;
    public void update(Classe a) throws Exception;
    public void delete(int id) throws Exception;
    public List<Classe> find(String key) throws Exception;
    public Classe getClasseById(int id) throws Exception;
}
