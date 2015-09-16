import java.util.Set;
import java.util.TreeMap;

/**
 * Created by biospore on 9/17/15.
 */
public interface IEngine extends Runnable {
    public void addProfile(String login, String password);
    public IProfile getProfile(String login);
    public Set<IProfile> getProfilesList();

    public void setActiveProfile(IProfile profile);
    public IProfile getActiveProfile();

    public TreeMap<Long, IEntry> getList();
    public void updateList(TreeMap<Long, IEntry> list);

    public IEntry searchLocal(String title);
    public void search(String title);

    public void addEntry(IEntry entry);
    public void deleteEntry(IEntry entry);
    public void updateEntry(IEntry entry);

    public IEntry getEntry(long id);

    public void saveLocalData();
}
