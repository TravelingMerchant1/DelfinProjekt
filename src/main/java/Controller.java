import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    Database database = new Database();
    Filehandler filehandler;

    {
        try {
            filehandler = new Filehandler();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        return database.getMedlemmers();
    }

    public void saveData() throws FileNotFoundException {
    database.getMedlemmers();
    filehandler.gemMedlemmer(getMedlemmer());
    }


}
