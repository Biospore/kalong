import java.io.IOException;

/**
 * Created by biospore on 9/10/15.
 */
public interface IAPI {
    /*
    * Should use :
    *    StringBuilder
    *    -Socket
    *    Some XML parser
    *    +java.net.URL
    *    +java.net.HttpURLConnection
    *    URL url = new URL(str)
    *    HttpURLConnection conn = (HttpURLConnection ) url.openConnection()
    *    conn.setMethod()
    *    conn.setProperty()
    * Need methods:
    *    getProfile
    *    -doRequest
    *    -getResponse
    *
    * API->StringBuilder->String->Parser->DB
    * Additional Exceptions
    *
    * */
    void setProfile(String login, String passw);
    String searchEntry(String name, String type) throws IOException;
    void addEntry(String name, String type);
    void updateEntry(String name, String type);
    void deleteEntry(String name, String type);
    String getList(String type) throws IOException;
}