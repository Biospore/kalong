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
 *  search_entry name type
 *  get_list type
 *  add_entry id xml_data type
 *  update_entry id xml_data type
 *  delete_entry id xml_data type
 */
