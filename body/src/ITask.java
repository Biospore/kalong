/**
 * Created by biospore on 9/17/15.
 */
public interface ITask {
    void setTask(String task);
    String getTask();

    void setId(long id);
    long getId();

    void setType(String type);
    String getType();

    void setData(Object data);
    Object getData();
}
