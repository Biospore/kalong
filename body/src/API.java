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
    private String encprofile;
    private StringBuilder sb;
    private String sharedlisturl;
    private String searchurl;

    /*
    * type:
    *   0 - anime
    *   1 - manga
    * */
    public API(int type){
        this.sb = new StringBuilder();
        switch (type){
            case 0:
                this.sharedlisturl = "http://myanimelist.net/api/animelist/";
                this.searchurl = "http://myanimelist.net/api/anime/search.xml?q=";
                break;
/*            case 1:
                this.sharedlisturl = "http://myanimelist.net/api/mangalist/";
                this.searchurl = "http://myanimelist.net/api/manga/search.xml?q=";
                break;
*/          default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void setProfile(String login, String passw) {
        this.sb.delete(0, this.sb.length());
        this.sb.append(login);
        this.sb.append(":");
        this.sb.append(passw);
        this.encprofile = Base64.encode(this.sb.toString().getBytes());
    }

    @Override
    public String searchEntry(String name) throws IOException{
        this.sb.delete(0, this.sb.length());
/*        sb.append(this.searchurl);
        sb.append(name.replace(" ", "+"));
        RequestHandler rh = new RequestHandler(sb.toString());
        sb.delete(0, sb.length());
        rh.setType("GET");
        rh.setProperty("Host", "myanimelist.net");
        sb.append("Basic ");
        sb.append(this.encprofile);
        rh.setProperty("Authorization", sb.toString());*/
//        rh.setProperty("Accept", "text/html, inage/gif, image/jpg, *:q=.2, */*; q=.2");
//        rh.connect();
        URL uaddr = new URL(this.searchurl.concat(name.replace(" ", "+")));
        HttpURLConnection conn = (HttpURLConnection) uaddr.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestMethod("GET");
// /        conn.

//        conn.setRequestProperty("Host", "myanimelist.net");
        conn.setRequestProperty("Authorization", "Basic ".concat(this.encprofile));
        conn.setRequestProperty("User-Agent", "kalong/0.1.0");
//        conn.setRequestProperty("Accept", "*/*");

        conn.connect();
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputs;
            while ((inputs = br.readLine()) != null){
                sb.append(inputs.concat("\n"));
            }
            br.close();
        }
        else{
            throw new HTTPException(conn.getResponseCode());
        }

        return sb.toString();// rh.getAnswer();
    }

    @Override
    public String getList() throws IOException {
        this.sb.delete(0, this.sb.length());
        String url = "http://myanimelist.net/malappinfo.php?u=__biospore&status=all&type=anime";
        RequestHandler rh = new RequestHandler(url);
        rh.setType("GET");
        rh.setProperty("Host", "myanimelist.net");
        rh.connect();
        return rh.getAnswer();
    }

    @Override
    public void addEntry(String name) {

    }

    @Override
    public void updateEntry(String name) {

    }

    @Override
    public void deleteEntry(String name) {

    }
}
