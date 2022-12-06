package Hold;

import Datahandler.Medlem;

import java.util.Comparator;

public class TræningsresultaterComparator implements Comparator<Medlem> {
    public int compare(Medlem p1, Medlem p2) {
        return Double.compare(p1.getTræningsresultater(), p2.getTræningsresultater());
    }
}
