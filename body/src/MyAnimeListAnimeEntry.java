import java.io.Serializable;

/**
 * Created by biospore on 9/13/15.
 */


public class MyAnimeListAnimeEntry implements IEntry{
    private long id;
    private String title;
    private String titleEng;
    private String synonyms;
    private int seriesType;
    private int seriesEpisodes;
    private int seriesStatus;
    private float seriesScore;
    private String seriesStarts;
    private String seriesEnds;
    private String imageURL;
    private boolean imageLoaded;
    private String imagePath;

    private int watchedEpisodes;
    private String startDate;
    private String finishDate;
    private int score;
    private int status;
    private boolean rewatching;
    private String tags;

    private String url;
    private String synopsis;

    public MyAnimeListAnimeEntry(){
        this.id = 0;
        this.title = "";
        this.titleEng = "";
        this.synonyms = "";
        this.synopsis = "";
        this.seriesType = 0;
        this.seriesEpisodes = 0;
        this.seriesStatus = 0;
        this.score = 0;
        this.seriesScore = 0;
        this.seriesStarts = "0000-00-00";
        this.seriesEnds = "0000-00-00";
        this.imageURL = "";
        this.imageLoaded = false;
        this.imagePath = "";
        this.watchedEpisodes = 0;
        this.startDate = "0000-00-00";
        this.finishDate = "0000-00-00";
        this.status = 0;
        this.rewatching = false;
        this.tags = "";
        this.url = "";
    }

    public void show(){
        System.out.println();
        System.out.println("Title: " + this.title);
        System.out.println("Synonyms: " + this.synonyms);
        System.out.println("Id: " + this.id);
        System.out.println("Start Date: " + this.seriesStarts);
        System.out.println("End Date " + this.seriesEnds);
        System.out.println("Image URL: " + this.imageURL);
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitleEng(String title){
        this.titleEng = title;
    }

    public String getTitleEng(){
        return this.titleEng;
    }

    public void setSynonyms(String synonyms){
        this.synonyms = synonyms;
    }

    public String getSynonyms(){
        return this.synonyms;
    }

    public int getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(int seriesType) {
        this.seriesType = seriesType;
    }

    public int getSeriesEpisodes() {
        return seriesEpisodes;
    }

    public void setSeriesEpisodes(int seriesEpisodes) {
        this.seriesEpisodes = seriesEpisodes;
    }

    public int getSeriesStatus() {
        return seriesStatus;
    }

    public void setSeriesStatus(int seriesStatus) {
        this.seriesStatus = seriesStatus;
    }

    public float getSeriesScore() {
        return seriesScore;
    }

    public void setSeriesScore(float seriesScore) {
        this.seriesScore = seriesScore;
    }

    public String getSeriesStarts() {
        return seriesStarts;
    }

    public void setSeriesStarts(String seriesStarts) {
        this.seriesStarts = seriesStarts;
    }

    public String getSeriesEnds() {
        return seriesEnds;
    }

    public void setSeriesEnds(String seriesEnds) {
        this.seriesEnds = seriesEnds;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public void setWatchedEpisodes(int watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRewatching() {
        return rewatching;
    }

    public void setRewatching(boolean rewatching) {
        this.rewatching = rewatching;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
