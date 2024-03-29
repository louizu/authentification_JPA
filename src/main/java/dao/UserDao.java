package dao;

public interface UserDao {
    public boolean findUser(String email, String mdp);
}
