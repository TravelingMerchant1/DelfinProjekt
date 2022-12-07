package Hold;

import Datahandler.Medlem;

public class KonkurrenceSvømmer extends Medlem {
    private double tid;

    public KonkurrenceSvømmer(String navn, String efternavn, int alder, String køn, int medlemsNummer, double tid){
        super(navn, efternavn, alder, køn, medlemsNummer);
        this.tid = tid;
    }

    public double getTid() {
        return tid;
    }

    public void setTid(double tid) {
        this.tid = tid;
    }


}
