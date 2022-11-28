import java.util.Comparator;

public class HoldComparator implements Comparator<Medlemmer> {
    public int compare(Medlemmer p1, Medlemmer p2) {
        return p1.getHold().compareTo(p2.getHold());
    }
}
