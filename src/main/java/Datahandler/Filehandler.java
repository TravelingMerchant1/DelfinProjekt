package Datahandler;

import java.io.*;
import java.util.ArrayList;

public class Filehandler {

    private File medlemmerFil = new File("data/medlemmer.csv");
    private File medlemmerIkkeIRestance = new File("data/medlemmerIkkeIRestance.csv");



    public void gemMedlemmer(ArrayList<Medlem> dataSaver) {
                    try {
                medlemmerFil.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

    public void gemMedlemIRestance(ArrayList<Medlem> dataSaver) {
        try {
            medlemmerIkkeIRestance.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(medlemmerIkkeIRestance, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Medlem medlem : dataSaver) {
            dataWriting(output, medlem);
        }
        output.close();
    }

//    public void gemRestance(ArrayList<Medlem> dataSaver) {
//        try {
//            restanceFil.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        PrintWriter output = null;
//        try {
//            output = new PrintWriter(new FileWriter(restanceFil, true));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (Medlem medlem : dataSaver) {
//            dataWriting(output, medlem);
//        }
//        output.close();
//    }

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
        output.print(";");
        output.print(medlem.isRestance());
        output.println();
    }

//    static void restanceWriting(PrintWriter output, Medlem medlem) {
//        output.print(medlem.getNavn());
//        output.print(";");
//        output.print(medlem.getEfternavn());
//        output.print(";");
//        output.print(medlem.getAlder());
//        output.print(";");
//        output.print(medlem.getKøn());
//        output.print(";");
//        output.print(medlem.isAktivitetsForm());
//        output.print(";");
//        output.print(medlem.isKonkurrenceSvømmer());
//        output.print(";");
//        output.print(medlem.isStuderende());
//        output.print(";");
//        output.print(medlem.getMedlemsNummer());
//        output.println(";");
//        output.print(medlem.isRestance());
//        output.println();
//    }
}
