package UI;
import Datahandler.*;


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


    public ArrayList<Medlem> indlæsMedlemmer(){
        return database.indlæsMedlemmer();
    }

    public void sletMedlem(int input){
        database.sletMedlem(input);
    }

    public void redigerMedlem(int input, String navn, String efternavn, String alder, String køn, String aktivitetsform, String konkurrencesvømmer) {
        database.redigerMedlem(input, navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer);
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

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultat, boolean studerende, int medlemsNummer){
        return database.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);
    }

    public ArrayList<Medlem> getMedlemmer() {
        return database.getMedlemmer();
    }
    public void gemData() {
        database.getMedlemmer();
        filehandler.gemMedlemmer(getMedlemmer());
        filehandler.gemMedlemIRestance(getMedlemmer());
    }


}
