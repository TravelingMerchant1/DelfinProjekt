import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    private File medlemsNummerFil = new File("data/medlemsNummer.txt");
    public Database(ArrayList<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }

    public Database() {

    }

    public int medlemsNummer() {
        int midlertigtMedlemsNummer=0;
        Scanner scanner;
        try {
            scanner = new Scanner(medlemsNummerFil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (medlemsNummerFil.length() > 0) {
            while (scanner.hasNextInt()) {
                midlertigtMedlemsNummer = scanner.nextInt();
            }
            } else {
                midlertigtMedlemsNummer = 100;
            }
            scanner.close();

        return midlertigtMedlemsNummer;
    }

    public void nytMedlemsNummer(){
        int midlertidgtNummer;
        midlertidgtNummer = medlemsNummer();
        try {
            PrintWriter output = new PrintWriter(new FileWriter(medlemsNummerFil, true));
            output.println(midlertidgtNummer+1);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void sidsteMedlemsNummer(){
        int midlertidigtNummer;
        midlertidigtNummer = medlemsNummer();
        try {
            PrintWriter output = new PrintWriter(medlemsNummerFil);
            output.println(midlertidigtNummer);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultater, boolean studerende, int medlemsNummer) {
        Medlem medlem = new Medlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultater, studerende, medlemsNummer);
        medlemmer.add(medlem);
        return medlem;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }

}
