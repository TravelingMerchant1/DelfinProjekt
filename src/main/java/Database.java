import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private ArrayList<Medlemmer> medlemmers = new ArrayList<>();
    Medlemmer medlemmer = new Medlemmer();

    public Database(ArrayList<Medlemmer> medlemmers) {
        this.medlemmers = medlemmers;
    }

    public Database() {

    }

    public void nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, int medlemsNummer) {
        Medlemmer medlem = new Medlemmer(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, medlemsNummer);
        medlemmers.add(medlem);
    }

    public ArrayList<Medlemmer> getMedlemmers() {
        return medlemmers;
    }

    public void setMedlemmers(ArrayList<Medlemmer> medlemmers) {
        this.medlemmers = medlemmers;
    }

}
