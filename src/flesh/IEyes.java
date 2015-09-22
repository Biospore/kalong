package flesh;

import mind.IPersonality;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IEyes extends Runnable{
    void setPersonality(IPersonality personality);
    String searchRemoteFlashback(String regexp, String type) throws IOException;
    String getAllFlashbacks(String type) throws IOException;
    void addRemoteFlashback(long id, String type, String data);
    void deleteRemoteFlashback(long id, String type);
    void updateRemoteFlashback(long id, String type, String data);
}
