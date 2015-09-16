import java.io.IOException;

/**
 * Created by biospore on 9/10/15 (2:19 AM).
 */
public interface IMyAnimeListAPI extends Runnable{
    void setProfile(IProfile profile);
    String searchEntry(String name, String type) throws IOException;
    void addEntry(long id, String data, String type);
    void updateEntry(long id, String data, String type);
    void deleteEntry(long id, String data, String type);
    String getList(String type) throws IOException;
}