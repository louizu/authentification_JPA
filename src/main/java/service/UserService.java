package service;

import dao.UserDao;
import dao.imp.UserDaoImp;

public class UserService {
    private UserDao userDao=new UserDaoImp();

    public UserService() {
    }

    public boolean findUserService(String login, String mdp){
        return userDao.findUser(login,mdp);
    }
}
