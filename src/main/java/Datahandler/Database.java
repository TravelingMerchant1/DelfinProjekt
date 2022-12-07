package Datahandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    private File medlemsNummerFil = new File("data/medlemsNummer.txt");
    private File medlemmerFil = new File("data/medlemmer.csv");
    private File medlemmerIRestance = new File("data/medlemmerIRestance.csv");
    private File medlemmerIkkeIRestance = new File("data/medlemmerIkkeIRestance.csv");

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


    // RESTANCE
    public ArrayList<Medlem> indlæsRestance()  {
        ArrayList<Medlem> medlemmer = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(medlemmerIRestance);
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
                    Boolean.parseBoolean(attributter[4]),
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7]));
            medlemmer.add(indlæstMedlem);
        }
        sc.close();
        return medlemmer;
    }

    public ArrayList<Medlem> indlæsIkkeIRestance()  {
        ArrayList<Medlem> medlemmer = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(medlemmerIkkeIRestance);
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
                    Boolean.parseBoolean(attributter[4]),
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7]));
            medlemmer.add(indlæstMedlem);
        }
        sc.close();
        return medlemmer;
    }

    public void restanceFil(){
        try {
            medlemmerIRestance.createNewFile();
            medlemmerIkkeIRestance.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void tageUdAfRestance(int input){
        ArrayList<String> tempRestanceListe = new ArrayList<>();
        try (Scanner scanner = new Scanner(medlemmerIRestance)) {
            while (scanner.hasNext()) {
                tempRestanceListe.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(medlemmerIkkeIRestance, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String restanceMedlem = tempRestanceListe.get(input-1);
        output.write(restanceMedlem);
        output.close();
        tempRestanceListe.remove(input-1);

        try {PrintWriter pw = new PrintWriter(medlemmerIRestance);
            for (String medlem : tempRestanceListe){
                pw.println(medlem);
            }pw.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void sætIRestance(int input){
        ArrayList<String> tempRestanceListe = new ArrayList<>();
        try (Scanner scanner = new Scanner(medlemmerIkkeIRestance)) {
            while (scanner.hasNext()) {
                tempRestanceListe.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileWriter(medlemmerIRestance, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String restanceMedlem = tempRestanceListe.get(input-1);
        output.write(restanceMedlem);
        output.close();
        tempRestanceListe.remove(input-1);

        try {PrintWriter pw = new PrintWriter(medlemmerIkkeIRestance);
            for (String medlem : tempRestanceListe){
                pw.println(medlem);
            }pw.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public void redigerMedlem(int input, String navn, String efternavn, String alder, String køn, String aktivitetsform, String konkurrencesvømmer){

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

        if (aktivitetsform.isEmpty()){
            medlem.setAktivitetsForm(medlem.isAktivitetsForm());
        } else {
            if (aktivitetsform.equals("y")){
                medlem.setAktivitetsForm(true);
            } else if (aktivitetsform.equals("n")){
                medlem.setAktivitetsForm(false);
            }
        }

        if (konkurrencesvømmer.isEmpty()){
            medlem.setAktivitetsForm(medlem.isAktivitetsForm());
        } else {
            if (konkurrencesvømmer.equals("y")){
                medlem.setAktivitetsForm(true);
            } else if (konkurrencesvømmer.equals("n")){
                medlem.setAktivitetsForm(false);
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
        Filehandler.dataWriting(output, medlem);
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
                    Boolean.parseBoolean(attributter[4]),
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7]));
            medlemmer.add(indlæstMedlem);
        }
        sc.close();
        return medlemmer;
    }


    //MEDLEMSNUMMER
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

    public Medlem nyMedlem(String navn, String efternavn, int alder, String køn, boolean aktivitetsform, boolean konkurrencesvømmer, String hold, String disciplin, double træningsresultater, boolean studerende, int medlemsNummer) {
        Medlem medlem = new Medlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultater, studerende, medlemsNummer);
        medlemmer.add(medlem);
        return medlem;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }


}
