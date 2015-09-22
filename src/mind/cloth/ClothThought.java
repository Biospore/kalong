package mind.cloth;

import injuries.ThoughtWithoutTask;
import mind.IThought;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothThought implements IThought {
    private String task;
    private String type;
    private String data;

    @Override
    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String getTask() throws ThoughtWithoutTask {
        if (this.task != null){
            return this.task;
        }
        else{
            throw new ThoughtWithoutTask();
        }
    }

    @Override
    public void setType(String type) {
        this.type = type;

    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return this.data;
    }
}
