package Comparator;

import java.util.Comparator;

public class HoldComparator implements Comparator<Medlem> {
    public int compare(Medlem p1, Medlem p2) {
        return p1.getHold().compareTo(p2.getHold());
    }
}
