package mind;

import java.io.Serializable;
/**
 *В общем виде хранит информацию о конкретной записи.
*/
public interface IFlashback extends Serializable{
    void setId(long id);
    long getId();
    void setTitle(String title);
    String getTitle();
    void setType(String type);
    String getType();
}
