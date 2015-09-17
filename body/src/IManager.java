/**
 * Created by biospore on 9/17/15.
 */
public interface IManager {
    void addTask(ITask task);
    ITask getTask();
    boolean isEmpty();
}
