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

    public Engine(){
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

    @Override
    public boolean verifyProfile() {
        return false;
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
    }

    @Override
    public void addEntry(IEntry entry) {

    }

    @Override
    public void deleteEntry(long id) {

    }

    @Override
    public void updateEntry(long id) {

    }

    @Override
    public IEntry getEntry(long id) {
        return this.localData.getAllEntries().get(id);
    }
    @Override
    public void saveLocalData() {

    }
}
