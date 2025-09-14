package springTask.com.example;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save (User user){
        sessionFactory.getCurrentSession().persist(user);
    }

}
