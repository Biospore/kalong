import java.util.PriorityQueue;

/**
 * Created by biospore on 9/17/15.
 */
public class Manager implements IManager {
    private PriorityQueue<ITask> tasksList;

    @Override
    public void addTask(ITask task) {
        tasksList.add(task);
    }

    @Override
    public ITask getTask() {
        return tasksList.remove();
    }

    @Override
    public boolean isEmpty() {
        return tasksList.isEmpty();
    }
}
