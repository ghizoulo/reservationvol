package reservation.metier.user;



import java.util.List;

import reservation.model.User;

public interface UserManager {
	public List<User> list() throws Exception;
    public User authenticate(User user) throws Exception;
    public void add(User user) throws Exception;
    public void update(User user) throws Exception;
    public void delete(User user);
    public List<User> find(String keyword) throws Exception;
}
