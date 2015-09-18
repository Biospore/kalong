package heart;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by biospore on 9/17/15.
 */
public interface IEngine{
    void addProfile(String login, String password);
    IProfile getProfile(String login);
    boolean deleteProfile(String login);
    Set<IProfile> getProfilesList();

    boolean setActiveProfile(String login);
    IProfile getActiveProfile();

    Collection<IEntry> getList();
    void updateList(TreeMap<Long, IEntry> list);

    Collection<IEntry> searchLocal(String title);
    void search(String title);

    void addEntry(IEntry entry);
    void deleteEntry(IEntry entry);
    void updateEntry(IEntry entry);

    IEntry getEntry(long id);

    void saveLocalData();
}
