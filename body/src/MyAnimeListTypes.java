import java.util.TreeMap;

/**
 * Created by biospore on 9/14/15.
 */
public class MyAnimeListTypes {
    private TreeMap<Integer, String> series_types;
    private TreeMap<String, Integer> series_types_reverse;
    private TreeMap<Integer, String> my_status;
    private TreeMap<String, Integer> my_status_reverse;
    private TreeMap<Integer, String> status;
    private TreeMap<String, Integer> status_reverse;
    public MyAnimeListTypes(){
        series_types.put(1, "TV");
        series_types.put(2, "OVA");
        series_types.put(3, "Movie");
        series_types.put(4, "Special");
        series_types.put(5, "ONA");
        series_types.put(6, "Music");

        series_types_reverse.put("TV", 1);
        series_types_reverse.put("OVA", 2);
        series_types_reverse.put("Movie", 3);
        series_types_reverse.put("Special", 4);
        series_types_reverse.put("ONA", 5);
        series_types_reverse.put("Music", 6);

        my_status.put(1, "Watching");
        my_status.put(2, "Completed");
        my_status.put(3, "On-Hold");
        my_status.put(4, "Dropped");
        my_status.put(5, "");
        my_status.put(6, "Plan To Watch");

        my_status_reverse.put("Watching", 1);
        my_status_reverse.put("Completed", 2);
        my_status_reverse.put("On-Hold", 3);
        my_status_reverse.put("Dropped", 4);
        my_status_reverse.put("", 5);
        my_status_reverse.put("Plan To Watch", 6);

        status.put(1, "Currently Airing");
        status.put(2, "Finished Airing");
        status.put(3, "Not yet aired");

        status_reverse.put("Currently Airing", 1);
        status_reverse.put("Finished Airing", 2);
        status_reverse.put("Not yet aired", 3);

    }

    public String getSeriesTypeById(int id){
        return series_types.get(id);
    }

    public int getSeriesTypeByName(String name){
        return series_types_reverse.get(name);
    }

    public String getMyStatusById(int id){
        return my_status.get(id);
    }

    public int getMyStatusByName(String name){
        return my_status_reverse.get(name);
    }

    public String getStatusById(int id){
        return status.get(id);
    }

    public int getStatusByName(String name){
        return status_reverse.get(name);
    }

}
