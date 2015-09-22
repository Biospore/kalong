package mind.cloth;

import mind.IPersonality;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothPersonality implements IPersonality {
    private static int instanceCounter = 0;
    private int localId = 0;
    private long id = 0;
    private String login;
    private String password;
    private String type;

    public ClothPersonality(){
        instanceCounter++;
        this.id = instanceCounter;
    }

    @Override
    public int getLocalId() {
        return this.localId;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
