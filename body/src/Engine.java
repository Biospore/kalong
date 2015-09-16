import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by biospore on 9/15/15.
 */
public class Engine implements IEngine{
    private IMyAnimeListAPI malapi;
    private MyAnimeListXMLParser xmlparser;
    private Set<IProfile> profiles;
    private IProfile activeProfile;
    private ILocalData localData;
    private final IManager manager;

    public Engine(){
        manager = new Manager();
    }

    public void run(){

    }

    @Override
    public void addProfile(String login, String password) {
        IProfile profile = new MyAnimeListProfile();
        profile.setLogin(login);
        profile.setPassword(password);
        this.profiles.add(profile);
    }

    public void verifyProfile(IProfile profile) {
        ITask task = new MyAnimeListTask();
        task.setTask("verify_profile");
        task.setData(profile);
        synchronized (manager) {
            manager.addTask(task);
        }
    }

    @Override
    public IProfile getProfile(String login) {
        for (IProfile profile: this.profiles){
            if (profile.getLogin().equals(login)){
                return profile;
            }
        }
        return null;
    }

    @Override
    public Set<IProfile> getProfilesList() {
        return this.profiles;
    }

    @Override
    public void setActiveProfile(IProfile profile) {
        this.activeProfile = profile;
    }

    @Override
    public IProfile getActiveProfile() {
        return this.activeProfile;
    }

    @Override
    public TreeMap<Long, IEntry> getList() {
        return this.localData.getAllEntries();
    }

    @Override
    public void updateList(TreeMap<Long, IEntry> list) {
        this.localData.mergeLists(list);
    }

    @Override
    public IEntry searchLocal(String title) {
        TreeMap<Long, IEntry> localList = this.localData.getAllEntries();
        Collection<IEntry> entries =  localList.values();
        for (IEntry entry: entries){
            if (entry.getTitle().equals(title)){
                return entry;
            }
        }
        return null;
    }

    @Override
    public void search(String title) {
        ITask task = new MyAnimeListTask();
        task.setTask("search");
        task.setData(title);
        synchronized (manager) {
            manager.addTask(task);
        }
    }

    @Override
    public void addEntry(IEntry entry) {
        ITask task = new MyAnimeListTask();
        task.setTask("add");
        task.setData(entry);
        synchronized (manager) {
            manager.addTask(task);
        }

    }

    @Override
    public void deleteEntry(IEntry entry) {
        ITask task = new MyAnimeListTask();
        task.setTask("delete");
        task.setData(entry);
        synchronized (manager) {
            manager.addTask(task);
        }
    }

    @Override
    public void updateEntry(IEntry entry) {
        ITask task = new MyAnimeListTask();
        task.setTask("update");
        task.setData(entry);
        synchronized (manager) {
            manager.addTask(task);
        }
    }

    @Override
    public IEntry getEntry(long id) {
        return this.localData.getAllEntries().get(id);
    }
    @Override
    public void saveLocalData() {

    }
}
