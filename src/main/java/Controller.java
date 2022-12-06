import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {


    private Database database = new Database();
    private Filehandler filehandler;
    private Kontingens kontingens = new Kontingens();
    {
        filehandler = new Filehandler();
    }

    public void kontingentOversigt(){
        kontingens.kontingentOversigt(database);
    }


    public ArrayList<Medlem> indlæsMedlemmer(){
        return database.indlæsMedlemmer();
    }

    public void sletMedlem(int input){
        database.sletMedlem(input);
    }

    public void redigerMedlem(int input, String navn, String efternavn, String alder, String køn, String aktivitetsform, String konkurrencesvømmer){
        database.redigerMedlem(input, navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer);
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
    public Database getDatabase() {
        return database;
    }
    public Filehandler getFilehandler() {
        return filehandler;
    }

//    public void sorteretMedlemmer() {
//        Collections.sort(database.getMedlemmers(), new HoldComparator().thenComparing(new DisciplinComparator().thenComparing(new TræningsresultaterComparator())));
//        for (Medlem sorteretMedlemmer : database.getMedlemmers()) {
//            System.out.println(sorteretMedlemmer);
//        }
//    }

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultat, boolean studerende, int medlemsNummer){
        return database.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);
    }

    public ArrayList<Medlem> getMedlemmer() {
        return database.getMedlemmer();
    }

    public void setMedlemmer(ArrayList<Medlem> medlemmer) {
        this.database.setMedlemmer(medlemmer);
    }

    public void gemData() {
        database.getMedlemmer();
        filehandler.gemMedlemmer(getMedlemmer());
    }



    public void aldersOversigt(){
       database.aldersOversigt();
    }


}
