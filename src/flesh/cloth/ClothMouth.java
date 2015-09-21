package flesh.cloth;

import flesh.IMouth;
import mind.IFlashback;
import org.w3c.dom.Document;

import java.util.Collection;

/**
 * Created by biospore on 9/21/15.
 */
public class ClothMouth implements IMouth {
    @Override
    public Document eatXML(String xml) {
        return null;
    }

    @Override
    public Collection<IFlashback> eatSearch(String xml) {
        return null;
    }

    @Override
    public Collection<IFlashback> eatList(String xml) {
        return null;
    }
}
