import java.io.Serializable;

/**
 * Created by biospore on 9/14/15.
 */
public class MyAnimeListProfile implements IProfile{
    private long id;
    private String login;
    private String password;
    private double timeSpent;
    private int wathching;
    private int completed;
    private int onHold;
    private int dropped;
    private int planToWatch;

    public MyAnimeListProfile(){
        this.id = 0;
        this.login = "";
        this.password = "";
        this.timeSpent = 0;
        this.wathching = 0;
        this.completed = 0;
        this.onHold = 0;
        this.dropped = 0;
        this.planToWatch = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getWatching() {
        return wathching;
    }

    public void setWatching(int wathching) {
        this.wathching = wathching;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getOnHold() {
        return onHold;
    }

    public void setOnHold(int onHold) {
        this.onHold = onHold;
    }

    public int getDropped() {
        return dropped;
    }

    public void setDropped(int dropped) {
        this.dropped = dropped;
    }

    public int getPlanToWatch() {
        return planToWatch;
    }

    public void setPlanToWatch(int planToWatch) {
        this.planToWatch = planToWatch;
    }
}
