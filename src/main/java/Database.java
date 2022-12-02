import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private ArrayList<Medlem> medlemmer = new ArrayList<>();

    public Database(ArrayList<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }
    private Medlem medlem = new Medlem();

    private File medlemsNummerFil = new File("data/medlemsNummer.txt");


    public Database() {

    }



    public int medlemsNummer() {
        int medlemsNummer = 10000;
        try {
            Scanner scanner = new Scanner(medlemsNummerFil);
            Writer nytNummer = new FileWriter(medlemsNummerFil);

            //if (medlemsNummerFil.length() == 0){
              //  medlemsNummer = 10000;
             //   nytNummer.write(Integer.toString(medlemsNummer));
           // } else {
               // medlemsNummer = scanner.nextInt();
                nytNummer.write(Integer.toString(medlemsNummer + 1));
           // }
            scanner.close();
            nytNummer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return medlemsNummer;
    }

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultater, boolean studerende, int medlemsNummer) {
        medlemsNummer();
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
