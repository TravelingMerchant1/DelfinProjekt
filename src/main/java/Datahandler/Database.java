package Datahandler;

import Hold.KonkurrenceSvømmer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    private ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = new ArrayList<>();
    private File medlemmerFil = new File("data/medlemmer.csv");

    public Database() {

    }
    //ALDERSOVERSIGT

    public void aldersOversigt(){
        int totalJunior=0;
        int totalMellemAlder=0;
        int totalSenior=0;
        for (Medlem medlem : indlæsMedlemmer()){
            if (medlem.getAlder()<18){
                totalJunior =totalJunior + 1;
            } else if (18<=medlem.getAlder() && medlem.getAlder()<=60){
                totalMellemAlder = totalMellemAlder + 1;
            } else {
                totalSenior = totalSenior + 1;
            }
        }

        System.out.println("Der er følgende mængde folk i aldersgrupperne:" +
                "\nUnder 18 : " + totalJunior+
                "\nFra 18 til 60: " + totalMellemAlder +
                "\nOver 60 : " + totalSenior);
    }



    //OPRET, SLET, REDIGER

    public void sletMedlem(int input){
        ArrayList<String> tempMedlemListe = new ArrayList<>();
        try (Scanner scanner = new Scanner(medlemmerFil)) {
            while (scanner.hasNext()) {
                tempMedlemListe.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        tempMedlemListe.remove(input-1);

        try {PrintWriter pw = new PrintWriter(medlemmerFil);
            for (String medlem : tempMedlemListe){
                pw.println(medlem);
            }pw.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void redigerMedlem(int input, String navn, String efternavn, String alder, String køn, String konkurrencesvømmer){

        Medlem medlem = indlæsMedlemmer().get(input-1);
        if (navn.isEmpty()){
            medlem.setNavn(medlem.getNavn());
        } else {
            medlem.setNavn(navn);
        }
        if (efternavn.isEmpty()){
            medlem.setNavn(medlem.getNavn());
        } else {
            medlem.setNavn(navn);
        }
        if (alder.isEmpty()){
            medlem.setAlder(medlem.getAlder());
        } else {
            Integer.parseInt(alder);
            medlem.setNavn(alder);
        }
        if (køn.isEmpty()){
            medlem.setKøn(medlem.getKøn());
        } else {
            medlem.setKøn(køn);
        }


        if (konkurrencesvømmer.isEmpty()){
            medlem.setKonkurrenceSvømmer(medlem.isKonkurrenceSvømmer());
        } else {
            if (konkurrencesvømmer.equals("y")){
                medlem.setKonkurrenceSvømmer(true);
            } else if (konkurrencesvømmer.equals("n")){
                medlem.setKonkurrenceSvømmer(false);
            }
        }

        ArrayList<Medlem> tempMedlemmer = new ArrayList<>();
        tempMedlemmer.addAll(indlæsMedlemmer());
        tempMedlemmer.remove(input-1);
        tempMedlemmer.add(input-1, medlem);

        PrintWriter output = null;
        PrintWriter clearFile = null;
        try {
            clearFile = new PrintWriter(new FileWriter(medlemmerFil, false));
            clearFile.print("");
            clearFile.close();
            output = new PrintWriter(new FileWriter(medlemmerFil, true));
            for (Medlem medlemmer1 : tempMedlemmer) {
                saveData(output, medlemmer1);
            }
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveData(PrintWriter output, Medlem medlem) {
        Filehandler.skrivMedlemData(output, medlem);
    }


    public ArrayList<Medlem> indlæsMedlemmer()  {
        ArrayList<Medlem> medlemmer = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(medlemmerFil);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {

            String linje = sc.nextLine();
            String[] attributter = linje.split(";");

            Medlem indlæstMedlem = new Medlem(
                    attributter[0],
                    attributter[1],
                    Integer.parseInt(attributter[2]),
                    attributter[3],
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7]));
            medlemmer.add(indlæstMedlem);
        }
        sc.close();
        return medlemmer;
    }
    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultater, boolean studerende, int medlemsNummer) {
        Medlem medlem = new Medlem(navn, efternavn, alder, køn, konkurrencesvømmer, hold, disciplin, træningsresultater, studerende, medlemsNummer);
        medlemmer.add(medlem);
        return medlem;
    }

    public KonkurrenceSvømmer nyKonkurrenceSvømmer(String navn, String efternavn, int alder, String køn, int medlemsNummer, double tid){
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer(navn, efternavn, alder, køn, medlemsNummer, tid);
        konkurrenceSvømmere.add(konkurrenceSvømmer);
        return konkurrenceSvømmer;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public ArrayList<KonkurrenceSvømmer> getKonkurrenceSvømmere() {
        return konkurrenceSvømmere;
    }

    public void setKonkurrenceSvømmere(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
        this.konkurrenceSvømmere = konkurrenceSvømmere;
    }



}
