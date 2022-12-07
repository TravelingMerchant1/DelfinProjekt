package UI;
import Datahandler.*;
import Hold.KonkurrenceSvømmer;


import java.util.ArrayList;

public class Controller {


    private Database database = new Database();
    private Filehandler filehandler = new Filehandler();;
    private Kontingens kontingens = new Kontingens();
    private Restance restance = new Restance();
    private MedlemsNummer medlemsNummer = new MedlemsNummer();

    public void kontingentOversigt(){
        kontingens.kontingentOversigt(database);
    }

    public void restanceFil(){
        restance.restanceFil();
    }

    public void aldersOversigt(){
        database.aldersOversigt();
    }

    public void gemMedlemCrawl(){
       filehandler.gemMedlemCrawl(getKonkurrenceSvømmer());
    }

    public void gemMedlemRygcrawl(){
        filehandler.gemMedlemRygcrawl(getKonkurrenceSvømmer());
    }

    public void gemMedlemBrystsvømning(){
        filehandler.gemMedlemBrystsvømning(getKonkurrenceSvømmer());
    }

    public void gemMedlemButtefly(){
        filehandler.gemMedlemButterfly(getKonkurrenceSvømmer());
    }


    public ArrayList<Medlem> indlæsMedlemmer(){
        return database.indlæsMedlemmer();
    }

    public void sletMedlem(int input){
        database.sletMedlem(input);
    }

    public void redigerMedlem(int input, String navn, String efternavn, String alder, String køn, String konkurrencesvømmer) {
        database.redigerMedlem(input, navn, efternavn, alder, køn, konkurrencesvømmer);
    }

    public ArrayList<Medlem> indlæsIRestance(){
        return restance.indlæsRestance();
    }

    public ArrayList<Medlem> indlæsIkkeIRestance(){
        return restance.indlæsIkkeIRestance();
    }

    public void tagUdAfRestance(int input){
        restance.tageUdAfRestance(input);
    }

    public void sætIRestance(int input){
        restance.sætIRestance(input);
    }

    public double kontingentTotal(){
        return kontingens.kontingentTotal(restance);
    }

    public int medlemsNummer(){
        return medlemsNummer.medlemsNummer();
    }

    public void nytMedlemsNummer(){
        medlemsNummer.nytMedlemsNummer();
    }

    public void sidsteMedlemsNummer(){
        medlemsNummer.sidsteMedlemsNummer();
    }

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultat, boolean studerende, int medlemsNummer){
        return database.nyMedlem(navn, efternavn, alder, køn, konkurrencesvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);
    }

    public KonkurrenceSvømmer nyKonkurrenceSvømmer(String navn, String efternavn, int alder, String køn, int medlemsNummer, double tid){
        return database.nyKonkurrenceSvømmer(navn, efternavn, alder, køn, medlemsNummer, tid);
    }

    public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmer() {
        return database.getKonkurrenceSvømmere();
    }
    public ArrayList<Medlem> getMedlemmer() {
        return database.getMedlemmer();
    }
    public void gemData() {
        database.getMedlemmer();
        filehandler.gemMedlem(getMedlemmer());
        filehandler.gemMedlemIRestance(getMedlemmer());
    }


}
