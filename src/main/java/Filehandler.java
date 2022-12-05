import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    private File file = new File("data/medlemmer.csv");

    public ArrayList<Medlem> indlæsMedlemmer()  {
        ArrayList<Medlem> personer = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {

            String linje = sc.nextLine();
            String[] attributter = linje.split(";");

            Medlem indlaestPerson = new Medlem(
                    attributter[0],
                    attributter[1],
                    Integer.parseInt(attributter[2]),
                    attributter[3],
                    Boolean.parseBoolean(attributter[4]),
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7]));
            personer.add(indlaestPerson);
        }
        sc.close();
        return personer;
    }



    public void gemMedlemmer(ArrayList<Medlem> dataSaver) throws FileNotFoundException {
        PrintStream output = new PrintStream(file);
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
            output.print(";");
            output.print(medlem.isStuderende());
            output.print(";");
            output.print(medlem.getMedlemsNummer());
            output.print(";");
            output.print(medlem.isRestance());
            output.print(";");
            output.println();
        }
        output.close();
    }
}
