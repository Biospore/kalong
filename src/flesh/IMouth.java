package flesh;

import mind.IFlashback;
import org.w3c.dom.Document;
import java.util.Collection;

public interface IMouth{
    public Document eatXML(String xml);
    public Collection<IFlashback> eatSearch(String xml);
    public Collection<IFlashback> eatList(String xml);
}
