import java.io.Serializable;

/**
 * Created by biospore on 9/17/15.
 */
public interface IEntry extends Serializable {
    void setId(long id);
    long getId();
    void setTitle(String title);
    String getTitle();
}
