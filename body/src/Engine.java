import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public boolean deleteProfile(String login) {
        for (IProfile profile : profiles){
            if (profile.getLogin().equals(login)){
                profiles.remove(profile);
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<IProfile> getProfilesList() {
        return this.profiles;
    }

    @Override
    public boolean setActiveProfile(String login) {
        for (IProfile profile : profiles){
            if (profile.getLogin().equals(login)){
                this.activeProfile = profile;
                return true;
            }
        }
        return false;
    }

    @Override
    public IProfile getActiveProfile() {
        return this.activeProfile;
    }

    @Override
    public Collection<IEntry> getList() {
        return this.localData.getAllEntries();
    }

    @Override
    public void updateList(TreeMap<Long, IEntry> list) {
        this.localData.mergeLists(list);
    }

    @Override
    public Collection<IEntry> searchLocal(String title) {
        Collection<IEntry> localList = this.localData.getAllEntries();
        Collection<IEntry> correctEntries = new ArrayList<IEntry>();
        Pattern pattern = Pattern.compile("(.*)(" + title + ")(.*)");
        for (IEntry entry: localList){
            Matcher matcher = pattern.matcher(entry.getTitle());
            if (matcher.find()){
                correctEntries.add(entry);
            }
        }
        return correctEntries;
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
        return this.localData.getEntry(id);
    }
    @Override
    public void saveLocalData() {

    }
}
