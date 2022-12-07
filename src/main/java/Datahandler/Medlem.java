package Datahandler;

public abstract class Medlem {

    private String navn;
    private String efternavn;
    private int alder;
    private String køn;
    private boolean konkurrenceSvømmer;
    private String hold;
    private String disciplin;
    private double træningsresultat;
    private boolean studerende;
    private int medlemsNummer;

    public Medlem(String navn, String efternavn, int alder, String køn, boolean konkurrenceSvømmer, String hold, String disciplin, double træningsresultat, boolean studerende, int medlemsNummer) {
        this.navn = navn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.køn = køn;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.hold = hold;
        this.disciplin = disciplin;
        this.træningsresultat = træningsresultat;
        this.studerende = studerende;
        this.medlemsNummer = medlemsNummer;

    }

    public Medlem() {
    }

    public Medlem(String navn, String efternavn, int alder, String køn, boolean konkurrenceSvømmer, boolean studerende, int medlemsNummer) {
        this.navn = navn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.køn = køn;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.studerende = studerende;
        this.medlemsNummer = medlemsNummer;
    }

    public Medlem(String navn, String efternavn, int alder, String køn, int medlemsNummer) {
        this.navn = navn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.køn = køn;
        this.medlemsNummer = medlemsNummer;
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


    public boolean isKonkurrenceSvømmer() {
        return konkurrenceSvømmer;
    }

    public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer) {
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public double getTræningsresultat() {
        return træningsresultat;
    }

    public void setTræningsresultat(double træningsresultat) {
        this.træningsresultat = træningsresultat;
    }

    public int getMedlemsNummer() {
        return medlemsNummer;
    }

    public void setMedlemsNummer(int medlemsNummer) {
        this.medlemsNummer = medlemsNummer;
    }

    public boolean isStuderende() {
        return studerende;
    }

    public void setStuderende(boolean studerende) {
        this.studerende = studerende;
    }

    public double getTræningsresultater() {
        return træningsresultat;
    }

    public abstract double getTid();
    public abstract void setTid(double tid);
}
