import java.io.Serializable;

/**
 * Created by biospore on 9/17/15.
 */
public interface IProfile extends Serializable {
    void setLogin(String login);
    String getLogin();
    void setPassword(String password);
    String getPassword();
}
