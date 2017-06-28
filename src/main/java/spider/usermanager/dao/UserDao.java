package spider.usermanager.dao;

import spider.usermanager.modeldata.User;

import java.util.List;

/**
 * Created by SPIDER on 20.06.2017.
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
}
