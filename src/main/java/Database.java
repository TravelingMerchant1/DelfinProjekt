import java.util.ArrayList;

public class Database {
    private ArrayList<Medlem> medlemmers = new ArrayList<>();


    public Database(ArrayList<Medlem> medlemmers) {
        this.medlemmers = medlemmers;
    }

    public Database() {

    }

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultater, boolean studerende, int medlemsNummer) {


   // Find på medlemsnummer her - før vi opretter det nye
        Medlem medlem = new Medlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultater, studerende, medlemsNummer);
        medlemmers.add(medlem);

        return medlem;
    }

    public ArrayList<Medlem> getMedlemmers() {
        return medlemmers;
    }

    public void setMedlemmers(ArrayList<Medlem> medlemmers) {
        this.medlemmers = medlemmers;
    }

}
