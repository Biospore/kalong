package mind;

import injuries.ThoughtWithoutTask;

import java.io.Serializable;

public interface IThought extends Serializable{
    void setTask(String task);
    String getTask() throws ThoughtWithoutTask;
    void setType(String type);
    String getType();
    void setData(String data);
    String getData();
}
