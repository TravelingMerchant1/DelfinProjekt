import java.util.Comparator;

public class TræningsresultaterComparator implements Comparator<Medlemmer> {
    public int compare(Medlemmer p1, Medlemmer p2) {
        return Double.compare(p1.getTræningsresultater(), p2.getTræningsresultater());
    }
}
