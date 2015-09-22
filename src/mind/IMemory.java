package mind;

import injuries.NoFlashbackFound;
import injuries.NoPersonalityFound;
import injuries.WrongType;

import java.io.Serializable;
import java.util.Collection;

/**
 *Хранит записи и профили.
*/
public interface IMemory extends Serializable{
    void addPersonality(String login, String password);
    void deletePersonality(int id) throws NoPersonalityFound;
    IPersonality getPersonality(int id) throws NoPersonalityFound;
    Collection<?> getAllPersonalities();
    void setActivePersonality(int id) throws NoPersonalityFound;
    IPersonality getActivePersonality() throws NoPersonalityFound;

    void addFlashback(IFlashback data) throws WrongType;
    IFlashback getFlashback(long id, String type) throws WrongType, NoFlashbackFound;
    void deleteFlashback(long id, String type) throws NoFlashbackFound, WrongType;
    Collection<?> getAllFlashbacks(String type) throws WrongType;
}
