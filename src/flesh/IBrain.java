package flesh;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

import injuries.NoFlashbackFound;
import injuries.NoPersonalityFound;
import injuries.WrongType;
import mind.IThought;
import mind.IPersonality;
import mind.IFlashback;
import mind.cloth.ClothThought;

public interface IBrain{
    void addThought(String task, String type, String data);
    Collection<?> getAllThoughts();

    void addPersonality(String login, String password);
    void deletePersonality(int id) throws NoPersonalityFound;
    IPersonality getPersonality(int id) throws NoPersonalityFound;
    Collection<?> getAllPersonalities();
    void setActivePersonality(int id) throws NoPersonalityFound;
    IPersonality getActivePersonality() throws NoPersonalityFound;

    void addFlashback(IFlashback data) throws WrongType;
    IFlashback getFlashback(long id, String type) throws NoFlashbackFound, WrongType;
    void deleteFlashback(long id, String type) throws NoFlashbackFound, WrongType;
    Collection<?> getAllFlashbacks(String type) throws WrongType;

    Collection<?> searchFlashback(String regexp, String type) throws WrongType;
    Collection<?> searchPersonality(String regexp);

    void addRemoteFlashback(long id, String type);
    void deleteRemoteFlashback(long id, String type);
    void updateRemoteFlashback(long id, String type);
    Collection<?> getAllRemoteFlashbacks(String type);
    Collection<?> searchRemoteFlashback(String regexp, String type);
}
