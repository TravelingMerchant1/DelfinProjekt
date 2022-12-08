package Medlemmer;

import java.util.Comparator;

public class bedsteTidComperator implements Comparator<KonkurrenceSvømmer> {

public int compare(Medlemmer.KonkurrenceSvømmer ob1, Medlemmer.KonkurrenceSvømmer ob2)
{
    if (ob1.getTid() < ob2.getTid() )
        return -1;
    else if (ob1.getTid() > ob2.getTid())
        return 1;
    else
        return 0;
}


}
