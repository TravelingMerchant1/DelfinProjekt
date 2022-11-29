import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Filehandler {

    public Filehandler() throws FileNotFoundException {

    }

    public void gemMedlemmer(ArrayList<Medlem> dataSaver) throws FileNotFoundException {
         PrintStream output = new PrintStream(new File("data/medlemmer.csv"));
        for (Medlem medlem : dataSaver) {
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
            output.println(";");
            output.print(medlem.isStuderende());
            output.print(";");
            output.print(medlem.getMedlemsNummer());
            output.println();
        }
        output.close();
    }
}
