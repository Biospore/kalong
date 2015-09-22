package mind;

import java.io.Serializable;

public interface IPersonality extends Serializable{
    int getLocalId();
    void setId(long id);
    long getId();
    void setLogin(String login);
    String getLogin();
    void setPassword(String password);
    String getPassword();
    void setType(String type);
    String getType();
}
