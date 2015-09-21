package mind;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by biospore on 9/21/15.
 */
public interface IOpinion extends Serializable{
    void addThought(String task, String type, String data);
    IThought getThought();
    Collection<?> getAllThoughts();
    boolean isEmpty();
}
