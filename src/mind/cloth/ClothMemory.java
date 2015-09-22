package mind.cloth;

import injuries.NoFlashbackFound;
import injuries.NoPersonalityFound;
import injuries.WrongType;
import mind.IFlashback;
import mind.IMemory;
import mind.IPersonality;

import java.util.HashSet;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothMemory implements IMemory {
    private HashSet<ClothPersonality> personalities;
    private ClothPersonality activePersonality;
    private HashSet<ClothFlashback> animeFlashbacks;
    private HashSet<ClothFlashback> mangaFlashbacks;

    @Override
    public void addPersonality(String login, String password) {
        ClothPersonality personality = new ClothPersonality();
        personality.setLogin(login);
        personality.setPassword(password);
        personalities.add(personality);
    }

    @Override
    public void deletePersonality(int id) throws NoPersonalityFound {
        for (ClothPersonality personality: personalities){
            if (personality.getLocalId() == id){
                personalities.remove(personality);
                return;
            }
        }
        throw new NoPersonalityFound();
    }

    @Override
    public IPersonality getPersonality(int id) throws NoPersonalityFound {
        for (ClothPersonality personality: personalities){
            if (personality.getLocalId() == id){
                return personality;
            }
        }
        throw new NoPersonalityFound();
    }

    @Override
    public HashSet<ClothPersonality> getAllPersonalities() {
        return this.personalities;
    }

    @Override
    public void setActivePersonality(int id) throws NoPersonalityFound {
        for (ClothPersonality personality: personalities){
            if (personality.getLocalId() == id){
                this.activePersonality = personality;
                return;
            }
        }
        throw new NoPersonalityFound();
    }

    @Override
    public IPersonality getActivePersonality() throws NoPersonalityFound {
        if (this.activePersonality == null){
            throw new NoPersonalityFound();
        }
        return this.activePersonality;
    }

    @Override
    public void addFlashback(IFlashback data) throws WrongType {
        HashSet<ClothFlashback> tmpFlashbacks;
        String type = data.getType();
        switch (type) {
            case "anime":
                tmpFlashbacks = this.animeFlashbacks;
                break;
            case "manga":
                tmpFlashbacks = this.mangaFlashbacks;
                break;
            default:
                throw new WrongType();
        }
        tmpFlashbacks.add((ClothFlashback) data);
    }

    @Override
    public IFlashback getFlashback(long id, String type) throws WrongType, NoFlashbackFound {
        HashSet<ClothFlashback> tmpFlashbacks;
        switch (type) {
            case "anime":
                tmpFlashbacks = this.animeFlashbacks;
                break;
            case "manga":
                tmpFlashbacks = this.mangaFlashbacks;
                break;
            default:
                throw new WrongType();
        }
        for (ClothFlashback flashback: tmpFlashbacks){
            if (flashback.getId() == id){
                return flashback;
            }
        }
        throw new NoFlashbackFound();
    }

    @Override
    public void deleteFlashback(long id, String type) throws NoFlashbackFound, WrongType {
        HashSet<ClothFlashback> tmpFlashbacks;
        switch (type) {
            case "anime":
                tmpFlashbacks = this.animeFlashbacks;
                break;
            case "manga":
                tmpFlashbacks = this.mangaFlashbacks;
                break;
            default:
                throw new WrongType();
        }
        for (ClothFlashback flashback: tmpFlashbacks){
            if (flashback.getId() == id){
                tmpFlashbacks.remove(flashback);
                return;
            }
        }
        throw new NoFlashbackFound();
    }

    @Override
    public HashSet<ClothFlashback> getAllFlashbacks(String type) throws WrongType {
        switch (type) {
            case "anime":
                return this.animeFlashbacks;
            case "manga":
                return this.mangaFlashbacks;
            default:
                throw new WrongType();
        }
    }
}
