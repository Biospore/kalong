package mind.cloth;

import mind.IOpinion;
import mind.IThought;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothOpinion implements IOpinion {
    PriorityQueue<ClothThought> thoughts;

    @Override
    public void addThought(String task, String type, String data) {
        ClothThought thought = new ClothThought();
        thought.setTask(task);
        thought.setType(type);
        thought.setData(data);
        synchronized (this){
            this.thoughts.add(thought);
        }
    }

    @Override
    public IThought getThought() {
        ClothThought thought;
        synchronized (this){
            thought = this.thoughts.remove();
        }
        return thought;
    }

    @Override
    public Collection<ClothThought> getAllThoughts() {
        synchronized (this){
            return this.thoughts;
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (this){
            return this.thoughts.isEmpty();
        }
    }
}
