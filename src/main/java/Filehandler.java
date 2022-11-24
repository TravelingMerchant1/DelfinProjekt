import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Filehandler {
    PrintStream output = new PrintStream(new File("data/medlemmer.csv"));

    public Filehandler() throws FileNotFoundException {

    }

    public void gemMedlemmer(ArrayList<Medlemmer> dataSaver) {
        for (Medlemmer medlem : dataSaver) {
            output.print(medlem.getNavn());
            output.print(";");
            output.print(medlem.getEfternavn());
            output.print(";");
            output.print(medlem.getAlder());
            output.print(";");
            output.print(medlem.getKøn());
            output.print(";");
            output.print(medlem.isAktivitetsForm());
            output.print(";");
            output.print(medlem.isKonkurrenceSvømmer());
            output.print(";");
            output.print(medlem.getMedlemsNummer());
            output.println(";");
            output.println();
        }
        output.close();
    }
}
