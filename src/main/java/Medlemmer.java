import java.time.LocalDate;

public class Medlemmer {

    private String navn;
    private String efternavn;
    private int alder;
    private String køn;
    private boolean aktivitetsForm;
    private boolean konkurrenceSvømmer;

    private int medlemsNummer;

    public Medlemmer(String navn, String efternavn, int alder, String køn, boolean aktivitetsForm, boolean konkurrenceSvømmer, int medlemsNummer) {
        this.navn = navn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.køn = køn;
        this.aktivitetsForm = aktivitetsForm;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.medlemsNummer = medlemsNummer;
    }

    public Medlemmer() {

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
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

    public boolean isKonkurrenceSvømmer() {
        return konkurrenceSvømmer;
    }

    public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer) {
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }

    public int getMedlemsNummer() {
        return medlemsNummer;
    }

    public void setMedlemsNummer(int medlemsNummer) {
        this.medlemsNummer = medlemsNummer;
    }

}
