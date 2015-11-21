package reservation.dao;

import java.util.List;

import reservation.model.InfoEscale;

public interface InfoEscaleDaoInter {
	public List<InfoEscale> list() throws Exception;
    public void add(InfoEscale a) throws Exception;
    public void update(InfoEscale a) throws Exception;
    public void delete(int id) throws Exception;
    public List<InfoEscale> find(String key) throws Exception;
    public InfoEscale getInfoEscaleById(int id) throws Exception;
}
