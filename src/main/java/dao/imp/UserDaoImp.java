package dao.imp;
import dao.UserDao;

import Entity.User;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.sql.SQLException;

@Stateless
public class UserDaoImp implements UserDao {
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
    EntityManager em = emfactory.createEntityManager();


    public UserDaoImp() {
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean findUser(String login,String mdp) {
        try {

            User user = em.createQuery("SELECT u FROM user u WHERE u.login = :login AND u.password = :password", User.class)
                    .setParameter("login", login)
                    .setParameter("password", mdp)
                    .getSingleResult();

            // Si un utilisateur correspondant est trouvé, retourner true
            return user != null;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

//        System.out.println("*******************************"+login);
//        System.out.println(mdp);
//        return true;
  }
    @PreDestroy
    public void cleanUp() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emfactory != null && emfactory.isOpen()) {
            emfactory.close();
        }
    }

}




