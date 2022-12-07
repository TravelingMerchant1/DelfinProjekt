package Datahandler;

import java.io.*;
import java.util.Scanner;

public class MedlemsNummer {


    private File medlemsNummerFil = new File("data/medlemsNummer.txt");

    public void MedlemsNummer(){

    }
    public int medlemsNummer() {
        try {
            medlemsNummerFil.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
