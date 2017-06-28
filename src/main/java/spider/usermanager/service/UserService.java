package spider.usermanager.service;

import spider.usermanager.modeldata.User;

import java.util.List;

/**
 * Created by SPIDER on 20.06.2017.
 */
public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
    public List<User> listUsersByName(String name);
    public List<User> listUsersPart();

   public List<User> listUsersPrevious();
}
