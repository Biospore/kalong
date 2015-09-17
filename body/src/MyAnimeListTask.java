import com.sun.javafx.tk.Toolkit;

import java.util.Objects;

/**
 * Created by biospore on 9/17/15.
 */
public class MyAnimeListTask implements ITask {
    private String task;
    private String type;
    private long id;
    private Object data;

    public MyAnimeListTask(){
        this.task = "";
        this.type = "";
        this.id = 0;
        this.data = "";
    }

    @Override
    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String getTask() {
        return task;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }
}
