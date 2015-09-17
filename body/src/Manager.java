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

/**
 * Tasks:
 *  verify_profile
 *  set_profile IProfile(data)
 *  search name type
 *  get_list type
 *  add id xml_data type
 *  update id xml_data type
 *  delete id xml_data type
 */
