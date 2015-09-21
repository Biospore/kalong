package flesh.cloth;

import flesh.IBrain;
import injuries.NoFlashbackFound;
import injuries.NoPersonalityFound;
import injuries.WrongType;
import mind.IFlashback;
import mind.IPersonality;
import mind.cloth.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothBrain implements IBrain {
    ClothMemory memory;
    final ClothOpinion opinion;


    public ClothBrain(){
        memory = new ClothMemory();
        opinion = new ClothOpinion();
    }

    @Override
    public void addThought(String task, String type, String data) {
        this.opinion.addThought(task, type, data);
    }


    @Override
    public Collection<ClothThought> getAllThoughts() {
        return this.opinion.getAllThoughts();
    }

    @Override
    public void addPersonality(String login, String password) {
        memory.addPersonality(login, password);
    }

    @Override
    public void deletePersonality(int id) throws NoPersonalityFound {
        memory.deletePersonality(id);
    }

    @Override
    public IPersonality getPersonality(int id) throws NoPersonalityFound {
        return memory.getPersonality(id);
    }

    @Override
    public HashSet<ClothPersonality> getAllPersonalities() {
        return memory.getAllPersonalities();
    }

    @Override
    public void setActivePersonality(int id) throws NoPersonalityFound {
        memory.setActivePersonality(id);
    }

    @Override
    public IPersonality getActivePersonality() throws NoPersonalityFound {
        return memory.getActivePersonality();
    }

    @Override
    public void addFlashback(IFlashback data) throws WrongType {
        memory.addFlashback(data);
    }

    @Override
    public IFlashback getFlashback(long id, String type) throws NoFlashbackFound, WrongType {
        return memory.getFlashback(id, type);
    }

    @Override
    public void deleteFlashback(long id, String type) throws NoFlashbackFound, WrongType {
        memory.deleteFlashback(id, type);
    }

    @Override
    public HashSet<ClothFlashback> getAllFlashbacks(String type) throws WrongType {
        return memory.getAllFlashbacks(type);
    }

    @Override
    public HashSet<ClothFlashback> searchFlashback(String regexp, String type) throws WrongType {
        HashSet<ClothFlashback> memoryList = memory.getAllFlashbacks(type);
        HashSet<ClothFlashback> foundList = new HashSet<>();
        Pattern pattern = Pattern.compile("(.*)(" + regexp + ")(.*)");
        for (ClothFlashback flashback: memoryList){
            Matcher matcher = pattern.matcher(flashback.getTitle());
            if (matcher.find()){
                foundList.add(flashback);
            }
        }
        return foundList;
    }

    @Override
    public HashSet<ClothPersonality> searchPersonality(String regexp) {
        HashSet<ClothPersonality> memoryList = memory.getAllPersonalities();
        HashSet<ClothPersonality> foundList = new HashSet<>();
        Pattern pattern = Pattern.compile("(.*)(" + regexp + ")(.*)");
        for (ClothPersonality personality: memoryList){
            Matcher matcher = pattern.matcher(personality.getLogin());
            if (matcher.find()){
                foundList.add(personality);
            }
        }
        return foundList;
    }

    @Override
    public void addRemoteFlashback(long id, String type) {

    }

    @Override
    public void deleteRemoteFlashback(long id, String type) {

    }

    @Override
    public void updateRemoteFlashback(long id, String type) {

    }

    @Override
    public HashSet<IFlashback> getAllRemoteFlashbacks(String type) {
        return null;
    }

    @Override
    public HashSet<IFlashback> searchRemoteFlashback(String regexp, String type) {
        return null;
    }
}
