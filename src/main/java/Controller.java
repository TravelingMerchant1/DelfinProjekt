import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {


    private Database database = new Database();
    private Filehandler filehandler;
    {
        filehandler = new Filehandler();
    }

    public void kontingentOversigt() {
        for (Medlem medlem : filehandler.indlæsMedlemmer()) {
            if (medlem.getAlder() < 18) {
                int kontigentUng;
                kontigentUng = 1000;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentUng + " kr.");
            } else if (medlem.getAlder() <= 60) {
                int kontigentSenior = 1600;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentSenior+ " kr.");
            } else if (medlem.getAlder() > 60) {
                double kontigentST = 1600 * (1 - 0.25);
                System.out.println("Kontigent for "+ medlem.getNavn() + "er: " + kontigentST+ " kr.");
            } else if (medlem.isAktivitetsForm() == true) {
                double kontigentAktiv = 500;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentAktiv+ " kr.");
            } else if (medlem.isStuderende() == true) {
                double kontigentStud = 1600 * (1 - 0.15);
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentStud+ " kr.");
            }
        }
    }

    public double kontingentTotal(){
        double kontingentTotal = 0;
        for (Medlem medlem : filehandler.indlæsMedlemmer()) {
            double kontingent = 0;
            if (medlem.getAlder() < 18) {
                kontingent = 1000;
            } else if (medlem.getAlder() <= 60) {
                kontingent = 1600;
            } else if (medlem.getAlder() > 60) {
                kontingent = 1600 * (1 - 0.25);
            } else if (medlem.isAktivitetsForm() == true) {
                kontingent= 500;
            } else if (medlem.isStuderende() == true) {
                kontingent = 1600 * (1 - 0.15);
            }
            kontingentTotal = kontingent + kontingentTotal;
        }
        return kontingentTotal;
    }
    public Database getDatabase() {
        return database;
    }
    public Filehandler getFilehandler() {
        return filehandler;
    }

//    public void sorteretMedlemmer() {
//        Collections.sort(database.getMedlemmers(), new Comparator.HoldComparator().thenComparing(new Comparator.DisciplinComparator().thenComparing(new TræningsresultaterComparator())));
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

    public void saveData() throws FileNotFoundException {
    database.getMedlemmer();
    filehandler.gemMedlemmer(getMedlemmer());
    }

    public void aldersOversigt(){
        int junior=0;
        int totalJunior=0;
        int mellemAlder=0;
        int totalMellemAlder=0;
        int senior=0;
        int totalSenior=0;
        for (Medlem medlem : filehandler.indlæsMedlemmer()){
            if (medlem.getAlder()<18){
                totalJunior =junior + 1;
            } else if (18<=medlem.getAlder() && medlem.getAlder()<=60){
                totalMellemAlder = mellemAlder + 1;
            } else {
                totalSenior =senior + 1;
            }
        }

        System.out.println("Der er følgende mængde folk i aldersgrupperne:" +
                "\nUnder 18 : " + totalJunior+
                "\nFra 18 til 60: " + totalMellemAlder +
                "\nOver 60 : " + totalSenior);

    }


}
