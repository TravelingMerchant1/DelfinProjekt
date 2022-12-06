import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    private File medlemmerFil = new File("data/medlemmer.csv");




    public void gemMedlemmer(ArrayList<Medlem> dataSaver) {
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(medlemmerFil, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Medlem medlem : dataSaver) {
            dataWriting(output, medlem);
        }
        output.close();
    }

    static void dataWriting(PrintWriter output, Medlem medlem) {
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
        output.print(medlem.isStuderende());
        output.print(";");
        output.print(medlem.getMedlemsNummer());
        output.println();
    }
}
