import java.util.Comparator;

public class DisciplinComparator implements Comparator<Medlemmer> {
        public int compare(Medlemmer p1, Medlemmer p2) {
        return p1.getDisciplin().compareTo(p2.getDisciplin());
    }
}