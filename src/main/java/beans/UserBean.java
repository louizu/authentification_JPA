package beans;

import Entity.User;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import service.UserService;

import java.io.Serializable;
@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 2L;
    private String msg_success = "";
    private String msg_error = "";
    private User user=new User();
    private UserService service=new UserService();

    public UserBean() {
    }

    public String getMsg_success() {
        return msg_success;
    }

    public void setMsg_success(String msg_success) {
        this.msg_success = msg_success;
    }

    public String getMsg_error() {
        return msg_error;
    }

    public void setMsg_error(String msg_error) {
        this.msg_error = msg_error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }


    public void sauthentifier(String login,String mdp) {
        if (service.findUserService(login, mdp)) {
            msg_success = "Vous Etes bien connecte!";
            msg_error="";
        } else {
            msg_error = "Votre Connexion est echouee!";
            msg_success="";
        }
    }


}
