package Model;

import java.util.ArrayList;
import java.util.List;

public class LensManager {
    List<Lens> lenses = new ArrayList<>();

    public LensManager(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }
}
