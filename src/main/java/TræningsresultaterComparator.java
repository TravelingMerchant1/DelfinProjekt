import java.util.Comparator;

public class TræningsresultaterComparator implements Comparator<Medlem> {
    public int compare(Medlem p1, Medlem p2) {
        return Double.compare(p1.getTræningsresultat(), p2.getTræningsresultat());
    }
}
