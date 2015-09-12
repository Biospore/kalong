/**
 * Created by biospore on 9/11/15.
 */

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API implements IAPI {
    private String login;
    private String encprofile;
    private StringBuilder sb;
    /*
    * type:
    *   0 - anime
    *   1 - manga
    * */
    public API(){
        this.sb = new StringBuilder();
    }

    @Override
    public void setProfile(String login, String passw) {
        this.login = login;
        this.sb.delete(0, this.sb.length());
        this.sb.append(login);
        this.sb.append(":");
        this.sb.append(passw);
        this.encprofile = Base64.encode(this.sb.toString().getBytes());
    }

    @Override
    public String searchEntry(String name, String type) throws IOException{
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/api/");
        sb.append(type);
        sb.append("/search.xml?q=");
        sb.append(name.replace(" ", "+"));

        HttpURLConnection conn = this.getConnection(sb.toString());
        conn.setRequestMethod("GET");
        this.sb.delete(0, this.sb.length());
        sb.append("Basic ");
        sb.append(this.encprofile);
        conn.setRequestProperty("Authorization", sb.toString());

        return this.getAnswer(conn);
    }

    @Override
    public String getList(String type) throws IOException {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/malappinfo.php?u=");
        sb.append(this.login);
        sb.append("&status=all&type=");
        sb.append(type);
        HttpURLConnection conn = this.getConnection(sb.toString());

        conn.setRequestMethod("GET");

        return this.getAnswer(conn);
    }

    @Override
    public void addEntry(String name, String type) {


    }

    @Override
    public void updateEntry(String name, String type) {

    }

    @Override
    public void deleteEntry(String name, String type) {

    }

    private String getAnswer(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputs;
            this.sb.delete(0, this.sb.length());
            while ((inputs = br.readLine()) != null){
                sb.append(inputs);
            }
            br.close();
        }
        else{
            throw new HTTPException(conn.getResponseCode());
        }
        return sb.toString();
    }

    private HttpURLConnection getConnection(String url) throws IOException {
        URL uaddr = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) uaddr.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestProperty("User-Agent", "kalong/0.1.0");

        return conn;
    }
}
