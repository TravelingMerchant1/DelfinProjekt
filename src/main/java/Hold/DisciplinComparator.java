package Hold;

import Datahandler.Medlem;

import java.util.Comparator;

public class DisciplinComparator implements Comparator<Medlem> {
        public int compare(Medlem p1, Medlem p2) {
        return p1.getDisciplin().compareTo(p2.getDisciplin());
    }
}