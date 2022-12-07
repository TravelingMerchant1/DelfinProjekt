package UI;
import Datahandler.*;


import java.util.ArrayList;

public class Controller {


    private Database database = new Database();
    private Filehandler filehandler = new Filehandler();;
    private Kontingens kontingens = new Kontingens();

    public void kontingentOversigt(){
        kontingens.kontingentOversigt(database);
    }

    public void restanceFil(){
        database.restanceFil();
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
        return database.indlæsRestance();
    }

    public ArrayList<Medlem> indlæsIkkeIRestance(){
        return database.indlæsIkkeIRestance();
    }

    public void tagUdAfRestance(int input){
        database.tageUdAfRestance(input);
    }

    public void sætIRestance(int input){
        database.sætIRestance(input);
    }

    public double kontingentTotal(){
        return kontingens.kontingentTotal(database);
    }

    public int medlemsNummer(){
        return database.medlemsNummer();
    }

    public void nytMedlemsNummer(){
        database.nytMedlemsNummer();
    }

    public void sidsteMedlemsNummer(){
        database.sidsteMedlemsNummer();
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
