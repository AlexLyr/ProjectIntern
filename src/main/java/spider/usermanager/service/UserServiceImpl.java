package spider.usermanager.service;

import spider.usermanager.dao.UserDao;
import spider.usermanager.modeldata.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SPIDER on 20.06.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static int startPos=-5;
    private static int quantity=5;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
    @Transactional
    public List<User> listUsersByName(String name) {
        List<User> list=this.userDao.listUsers();
        List<User> listName=new ArrayList<>();
        for(User user: list){
            if(user.getName().equals(name))
                listName.add(user);
        }
        return listName;
    }
    @Transactional
    public List<User> listUsersPart(){
        List<User> list=this.userDao.listUsers();
        List<User> listPart=new ArrayList<>();
        startPos+=5;
        if(startPos>=list.size())
            startPos=0;
        for(int i=startPos;i<(startPos+quantity);i++){
            if(i>=list.size())
                return listPart;
            listPart.add(list.get(i));
        }
        return listPart;
    }

    @Transactional
    public List<User> listUsersPrevious() {
        List<User> list=this.userDao.listUsers();
        List<User> listPart=new ArrayList<>();
        startPos-=5;
        if(startPos<0)
            startPos=list.size();

        for(int i=startPos-quantity;i<(startPos);i++){
            if(i<0)
                i=0;
            listPart.add(list.get(i));
        }
        return listPart;
    }

}
