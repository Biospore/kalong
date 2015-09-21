package mind.cloth;

import mind.IFlashback;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothFlashback implements IFlashback {
    private long id;
    private String title;
    private String type;

    @Override
    public void setId(long id) {
        this.id =id;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public String toXML(){
        return null;
    }
}
