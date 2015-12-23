package reservation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservation.dao.AeroportDaoInter;
import reservation.dao.AssuranceDaoInter;
import reservation.dao.CompagnieDaoInter;
import reservation.dao.ReservationDaoInter;
import reservation.dao.VolDaoInter;

@Service("dashboardServiceImpl")
public class DashboardManagerImpl implements DashboardManager {

	@Autowired
    private CompagnieDaoInter compagnieDao;
	@Autowired
    private AssuranceDaoInter assuranceDao;
	@Autowired
    private AeroportDaoInter aeroportDao;
	@Autowired
    private ReservationDaoInter reservationDao;
	@Autowired
    private VolDaoInter volDao;
	
	@Override
	public int getAssurancesNbr() {
		try {
			return assuranceDao.list().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getAeroportsNbr() {
		try {
			return aeroportDao.list().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getVolsNbr() {
		try {
			return volDao.list().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getCompagniesNbr() {
		try {
			return compagnieDao.list().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getReservationsNbr() {
		try {
			return reservationDao.list().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
