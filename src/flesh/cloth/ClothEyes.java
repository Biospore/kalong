package flesh.cloth;

import flesh.IEyes;
import mind.IPersonality;
import mind.cloth.ClothPersonality;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothEyes implements IEyes {
    ClothPersonality personality;
    String encryptedPersonality;
    private StringBuilder sb;

    @Override
    public void setPersonality(IPersonality personality) {
        this.personality = (ClothPersonality)personality;
        this.sb.delete(0, this.sb.length());
        this.sb.append(personality.getLogin());
        this.sb.append(":");
        this.sb.append(personality.getPassword());
        this.encryptedPersonality = Base64.getEncoder().encodeToString(this.sb.toString().getBytes());
    }

    @Override
    public String searchRemoteFlashback(String regexp, String type) throws IOException {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/api/");
        sb.append(type);
        sb.append("/search.xml?q=");
        sb.append(regexp.replace(" ", "+"));

        URL uaddr = new URL(sb.toString());

        HttpURLConnection conn = (HttpURLConnection) uaddr.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestProperty("User-Agent", "kalong/0.1.0");

        conn.setRequestMethod("GET");
        this.sb.delete(0, this.sb.length());
        sb.append("Basic ");
        sb.append(this.encryptedPersonality);

        conn.setRequestProperty("Authorization", sb.toString());
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

    @Override
    public String getAllFlashbacks(String type) throws IOException {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/malappinfo.php?u=");
        sb.append(this.personality.getLogin());
        sb.append("&status=all&type=");
        sb.append(type);

        URL uaddr = new URL(sb.toString());

        HttpURLConnection conn = (HttpURLConnection) uaddr.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(false);
        conn.setRequestProperty("User-Agent", "kalong/0.1.0");

        conn.setRequestMethod("GET");

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

    @Override
    public void addRemoteFlashback(long id, String type, String data) {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/api/");
        sb.append(type);
        sb.append("list/add/");
        sb.append(id);
        sb.append(".xml");

    }

    @Override
    public void deleteRemoteFlashback(long id, String type) {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/api/");
        sb.append(type);
        sb.append("list/delete/");
        sb.append(id);
        sb.append(".xml");

    }

    @Override
    public void updateRemoteFlashback(long id, String type, String data) {
        this.sb.delete(0, this.sb.length());
        sb.append("http://myanimelist.net/api/");
        sb.append(type);
        sb.append("list/update/");
        sb.append(id);
        sb.append(".xml");

    }

    @Override
    public void run() {

    }
}
