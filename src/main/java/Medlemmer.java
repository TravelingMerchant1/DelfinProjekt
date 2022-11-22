public class Medlemmer {

    private String navn;
    private int alder;
    private String køn;
    private boolean aktivitetsForm;
    private boolean hold;
    private boolean konkurrenceSvømmer;

    public Medlemmer(String navn, int alder, String køn, boolean aktivitetsForm, boolean hold, boolean konkurrenceSvømmer) {
        this.navn = navn;
        this.alder = alder;
        this.køn = køn;
        this.aktivitetsForm = aktivitetsForm;
        this.hold = hold;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getKøn() {
        return køn;
    }

    public void setKøn(String køn) {
        this.køn = køn;
    }

    public boolean isAktivitetsForm() {
        return aktivitetsForm;
    }

    public void setAktivitetsForm(boolean aktivitetsForm) {
        this.aktivitetsForm = aktivitetsForm;
    }

    public boolean isHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public boolean isKonkurrenceSvømmer() {
        return konkurrenceSvømmer;
    }

    public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer) {
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }
}
