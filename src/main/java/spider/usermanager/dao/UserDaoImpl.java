package spider.usermanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import spider.usermanager.modeldata.User;

import java.util.List;

/**
 * Created by SPIDER on 20.06.2017.
 */

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger= LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully added! User info: "+user);
    }

    public void updateUser(User user) {
     Session session=this.sessionFactory.getCurrentSession();
     session.update(user);
     logger.info("User successfully updated! User info: "+user);
    }

    public void deleteUser(int id) {
    Session session=this.sessionFactory.getCurrentSession();
    User user =(User) session.load(User.class,new Integer(id));
    if(user!=null){
        session.delete(user);
    }
        logger.info("User successfully deleted! User info: "+user);
    }

    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user=(User)session.load(User.class,new Integer(id));
           logger.info("User successfully loaded! User info: "+user);
        return user;
    }


@SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session=this.sessionFactory.getCurrentSession();
    Criteria criteria=session.createCriteria(User.class);
        List<User> userList=criteria.list();
     for(User user:userList){
         logger.info("User list "+user);
     }
     return userList;
    }

}
