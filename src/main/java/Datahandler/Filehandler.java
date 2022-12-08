package Datahandler;

import Medlemmer.KonkurrenceSvømmer;
import Medlemmer.Medlem;

import java.io.*;
import java.util.ArrayList;

public class Filehandler {

    private File medlemmerFil = new File("data/medlemmer.csv");
    private File medlemmerIkkeIRestance = new File("data/medlemmerIkkeIRestance.csv");

    private File brystsvømning = new File ("data/brystsvømning.csv");
    private File crawl = new File ("data/crawl.csv");
    private File rygcrawl = new File ("data/rygcrawl.csv");
    private File butterfly = new File ("data/butterfly.csv");
    public void gemMedlem(ArrayList<Medlem> dataSaver) {
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
            skrivMedlemData(output, medlem);
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
            skrivMedlemData(output, medlem);
        }
        output.close();
    }

    public void gemMedlemCrawl(ArrayList<KonkurrenceSvømmer> dataSaver){
        try {
            crawl.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(crawl, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : dataSaver) {
            skrivKonkurrenceSvømmerData(output, konkurrenceSvømmer);
        }
        output.close();
    }

    public void gemMedlemRygcrawl(ArrayList<KonkurrenceSvømmer> dataSaver){
        try {
            rygcrawl.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(rygcrawl, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : dataSaver) {
            skrivKonkurrenceSvømmerData(output, konkurrenceSvømmer);
        }
        output.close();
    }

    public void gemMedlemBrystsvømning(ArrayList<KonkurrenceSvømmer> dataSaver){
        try {
            brystsvømning.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(brystsvømning, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : dataSaver) {
            skrivKonkurrenceSvømmerData(output, konkurrenceSvømmer);
        }
        output.close();
    }

    public void gemMedlemButterfly(ArrayList<KonkurrenceSvømmer> dataSaver){
        try {
            butterfly.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(butterfly, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : dataSaver) {
            skrivKonkurrenceSvømmerData(output, konkurrenceSvømmer);
        }
        output.close();
    }



    static void skrivKonkurrenceSvømmerData(PrintWriter output, KonkurrenceSvømmer konkurrenceSvømmer) {
            output.print(konkurrenceSvømmer.getNavn());
            output.print(";");
            output.print(konkurrenceSvømmer.getEfternavn());
            output.print(";");
            output.print(konkurrenceSvømmer.getAlder());
            output.print(";");
            output.print(konkurrenceSvømmer.getKøn());
            output.print(";");
            output.print(konkurrenceSvømmer.getMedlemsNummer());
            output.print(";");
            output.print(konkurrenceSvømmer.getTid());
            output.println();
    }
    static void skrivMedlemData(PrintWriter output, Medlem medlem) {
        output.print(medlem.getNavn());
        output.print(";");
        output.print(medlem.getEfternavn());
        output.print(";");
        output.print(medlem.getAlder());
        output.print(";");
        output.print(medlem.getKøn());
        output.print(";");
        output.print(medlem.isKonkurrenceSvømmer());
        output.print(";");
        output.print(medlem.isStuderende());
        output.print(";");
        output.print(medlem.getMedlemsNummer());
        output.println();
    }
}
