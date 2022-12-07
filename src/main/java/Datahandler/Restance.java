package Datahandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Restance {

    public void Restannce(){

    }


    private File medlemmerIRestance = new File("data/medlemmerIRestance.csv");
    private File medlemmerIkkeIRestance = new File("data/medlemmerIkkeIRestance.csv");

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
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7])) {
                @Override
                public double getTid() {
                    return 0;
                }

                @Override
                public void setTid(double tid) {

                }
            };
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
                    Boolean.parseBoolean(attributter[5]),
                    Boolean.parseBoolean(attributter[6]),
                    Integer.parseInt(attributter[7])) {
                @Override
                public double getTid() {
                    return 0;
                }

                @Override
                public void setTid(double tid) {

                }
            };
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
}
