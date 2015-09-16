import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.TreeMap;

/**
 * Created by biospore on 9/13/15.
 */
public class MyAnimeListXMLParser {
    private MyAnimeListTypes malTypes;

    public MyAnimeListXMLParser(){
        malTypes = new MyAnimeListTypes();
    }
    public static Document loadXMLFromString(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public TreeMap<Long, MyAnimeListAnimeEntry> parseSearch(String xml) throws ParserConfigurationException, IOException, SAXException {
        TreeMap<Long, MyAnimeListAnimeEntry> tempMap = new TreeMap<Long, MyAnimeListAnimeEntry>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("entry");
        for (int tmp = 0; tmp < nList.getLength(); tmp++) {
            Node node = nList.item(tmp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                MyAnimeListAnimeEntry tempMyAnimeListAnimeEntry = new MyAnimeListAnimeEntry();
                tempMyAnimeListAnimeEntry.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setTitleEng(element.getElementsByTagName("english").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSynonyms(element.getElementsByTagName("synonyms").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSeriesEpisodes(Integer.parseInt(element.getElementsByTagName("episodes").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesScore(Float.parseFloat(element.getElementsByTagName("score").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesType(this.malTypes.getSeriesTypeByName(element.getElementsByTagName("type").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesStatus(this.malTypes.getStatusByName(element.getElementsByTagName("status").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesStarts(element.getElementsByTagName("start_date").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSeriesEnds(element.getElementsByTagName("end_date").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSynopsis(element.getElementsByTagName("synopsis").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setImageURL(element.getElementsByTagName("image").item(0).getTextContent());
                tempMap.put(tempMyAnimeListAnimeEntry.getId(), tempMyAnimeListAnimeEntry);
            }
        }
        return tempMap;
    }

    public TreeMap<Long, MyAnimeListAnimeEntry> parseList(String xml) throws ParserConfigurationException, IOException, SAXException {
        TreeMap<Long, MyAnimeListAnimeEntry> tempMap = new TreeMap<Long, MyAnimeListAnimeEntry>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("anime");
        for (int tmp = 0; tmp < nList.getLength(); tmp++){
            Node node = nList.item(tmp);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                MyAnimeListAnimeEntry tempMyAnimeListAnimeEntry = new MyAnimeListAnimeEntry();
                tempMyAnimeListAnimeEntry.setId(Integer.parseInt(element.getElementsByTagName("series_animedb_id").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setTitle(element.getElementsByTagName("series_title").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSynonyms(element.getElementsByTagName("series_synonyms").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSeriesType(Integer.parseInt(element.getElementsByTagName("series_type").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesEpisodes(Integer.parseInt(element.getElementsByTagName("series_episodes").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesStatus(Integer.parseInt(element.getElementsByTagName("series_status").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setSeriesStarts(element.getElementsByTagName("series_start").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setSeriesEnds(element.getElementsByTagName("series_end").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setImageURL(element.getElementsByTagName("series_image").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setWatchedEpisodes(Integer.parseInt(element.getElementsByTagName("my_watched_episodes").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setStartDate(element.getElementsByTagName("my_start_date").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setFinishDate(element.getElementsByTagName("my_finish_date").item(0).getTextContent());
                tempMyAnimeListAnimeEntry.setScore(Integer.parseInt(element.getElementsByTagName("my_score").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setStatus(Integer.parseInt(element.getElementsByTagName("my_status").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setRewatching(Boolean.parseBoolean(element.getElementsByTagName("my_rewatching").item(0).getTextContent()));
                tempMyAnimeListAnimeEntry.setTags(element.getElementsByTagName("my_tags").item(0).getTextContent());
                tempMap.put(tempMyAnimeListAnimeEntry.getId(), tempMyAnimeListAnimeEntry);
            }
        }
        return tempMap;
    }

    private MyAnimeListProfile getInfo(MyAnimeListProfile myAnimeListProfile, String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("myinfo");

        for (int tmp = 0; tmp < nList.getLength(); tmp++) {
            Node node = nList.item(tmp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                myAnimeListProfile.setId(Long.parseLong(element.getElementsByTagName("user_id").item(0).getTextContent()));
                myAnimeListProfile.setWatching(Integer.parseInt(element.getElementsByTagName("user_watching").item(0).getTextContent()));
                myAnimeListProfile.setPlanToWatch(Integer.parseInt(element.getElementsByTagName("user_plantowatch").item(0).getTextContent()));
                myAnimeListProfile.setOnHold(Integer.parseInt(element.getElementsByTagName("user_onhold").item(0).getTextContent()));
                myAnimeListProfile.setDropped(Integer.parseInt(element.getElementsByTagName("user_dropped").item(0).getTextContent()));
                myAnimeListProfile.setCompleted(Integer.parseInt(element.getElementsByTagName("user_completed").item(0).getTextContent()));
                myAnimeListProfile.setTimeSpent(Double.parseDouble(element.getElementsByTagName("user_days_spent_watching").item(0).getTextContent()));
            }
        }
        return myAnimeListProfile;
    }
}
