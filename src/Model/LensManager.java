package Model;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LensManager implements Iterable<Lens> {
    List<Lens> lenses = new ArrayList<>();

    public void add(Lens lens)
    {
        lenses.add(lens);
    }

    public int getIndex(Lens lens)
    {
        return lenses.indexOf(lens);
    }

    @Override
    public Iterator<Lens> iterator()
    {
        return lenses.iterator();

    }

}
