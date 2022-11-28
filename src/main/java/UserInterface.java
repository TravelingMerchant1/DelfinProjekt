import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    int menuvalg;
    Controller controller = new Controller();


    public void menu() {
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("1) Indmeldelse af nye medlemmer");
        System.out.println("2) Redigere medlemmer oplysninger");
        System.out.println("3) Slette medlemmer");
        System.out.println("4) Oversigt over medlemmer");
        System.out.println("5) Opdater medlemmers resultater");
        System.out.println("6) Kontigent oversigt");
        System.out.println("7) Oversigt over hold");
        System.out.println("9) Exit");
    }

    public void start() {

        do {
            menu();
            menuvalg = input.nextInt();
            input.nextLine(); //Fix for Scanner Bug
            switch (menuvalg) {
                case 1:
                    indmeldelse();
                    break;
                case 2:
                    redigerMedlem();
                    break;
                case 3:
                    sletteMedlemmer();
                    break;
                case 4:
                    medlemsOversigt();
                    break;
                case 5:

                case 6:
                    kontigentOversigt();
            }
        } while (menuvalg != 9);
        System.out.println("Du aflsutter nu programmet");
        controller.saveData();
    }


    public void indmeldelse() {
        System.out.println("Navn på medlem: ");
        String navn = input.nextLine();


        System.out.println("Efternavn på medlem: ");
        String efternavn = input.nextLine();

        System.out.println("Alder på medlem: ");
        int alder = input.nextInt();
        input.nextLine();

        System.out.println("Køn på medlem: ");
        String køn = input.nextLine();

        System.out.println("aktivitetsform på medlem (Aktiv/Passiv): ");
        boolean aktivitetsform = true;
        if (input.nextLine().equalsIgnoreCase("aktiv")){
            aktivitetsform = true;
        } else if (input.nextLine().equalsIgnoreCase("passiv")){
            aktivitetsform = false;
        }

        System.out.println("Er medlem en konkurrencesvømmer (Motionist/Konkurrencesvømmer): ");
        boolean konkurrencesvømmer = input.nextBoolean();

        System.out.println("Er medlemmet studerende?");
        boolean studerende = input.nextBoolean();

        int medlemsNummer = 0;
        for (Medlemmer medlemmer : controller.getMedlemmer()){
            int midlertidigtMedlemsNummer = controller.getMedlemmer().size();
            medlemsNummer = midlertidigtMedlemsNummer + 1;
        }

        System.out.println("Medlem er gemt i databasen");
        controller.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, studerende, medlemsNummer);
            System.out.println("---------------------------------");
            System.out.println("Navn: " + navn + " " + efternavn);
            System.out.println("Alder: " + alder);
            System.out.println("Køn: " + køn);
            String aktivitet = "";
            if (aktivitetsform == true){
                aktivitet = "aktiv";
            } else {
                aktivitet = "passiv";
            }
            System.out.println("Aktivitetsform: " + aktivitet);
            System.out.println("Konkurrencesvømmer: " + konkurrencesvømmer);
            System.out.println("Studerende: " + studerende);
            System.out.println("Medlemsnummer: " + medlemsNummer);
            System.out.println("---------------------------------");
    }

    public void redigerMedlem() {
        for (int i = 0; i < controller.getMedlemmer().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMedlemmer().get(i));
        }

        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        Medlemmer editMedlem = controller.getMedlemmer().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + editMedlem);

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + editMedlem.getNavn());
        String nyNavn = input.nextLine();
        if (!nyNavn.isEmpty())
            editMedlem.setNavn(nyNavn);

        System.out.println("Efternavn: " + editMedlem.getEfternavn());
        String nyEfternavn = input.nextLine();
        if (!nyEfternavn.isEmpty()) {
            editMedlem.setEfternavn(nyEfternavn);
        }

        System.out.println("Alder: " + editMedlem.getAlder());
        String nyAlder = input.nextLine();
        if (!nyAlder.isEmpty()) {
            editMedlem.setAlder(Integer.parseInt(nyAlder));
        }

        System.out.println("Køn: " + editMedlem.getKøn());
        String nyKøn = input.nextLine();
        if (!nyKøn.isEmpty()) {
            editMedlem.setKøn(nyKøn);
        }

        System.out.println("Aktivitetsform: " + editMedlem.isAktivitetsForm());
        String nyAktivitetsform = input.nextLine();
        if (!nyAktivitetsform.isEmpty()) {
            editMedlem.setAktivitetsForm(Boolean.parseBoolean(nyAktivitetsform));
        }

        System.out.println("Konkurrencesvømmer: " + editMedlem.isKonkurrenceSvømmer());
        String nyKonkurrencesvømmer = input.nextLine();
        if (!nyKonkurrencesvømmer.isEmpty()) {
            editMedlem.setKonkurrenceSvømmer(Boolean.parseBoolean(nyKonkurrencesvømmer));
        }
    }

    public void sletteMedlemmer() {
        for (int i = 0; i < controller.getMedlemmer().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMedlemmer().get(i));
        }

        System.out.println("indtast nummer på medlem der skal slettes:");
        int nr = input.nextInt();
        input.nextLine();

        Medlemmer sletMedlem = controller.getMedlemmer().remove(nr - 1); // index starter fra 0
        System.out.println("Medlem " + sletMedlem + " er slettet fra systemet");

    }

    public void medlemsOversigt() {
        for (Medlemmer medlemmer : controller.getMedlemmer()) {
            System.out.println("---------------------------------");
            System.out.println("Navn: " + medlemmer.getNavn() + " " + medlemmer.getEfternavn());
            System.out.println("Alder: " + medlemmer.getAlder());
            System.out.println("Køn: " + medlemmer.getKøn());
            System.out.println("Aktivitetsform: " + medlemmer.isAktivitetsForm());
            System.out.println("Konkurrencesvømmer: " + medlemmer.isKonkurrenceSvømmer());
            System.out.println("Medlemsnummer : " + medlemmer.getMedlemsNummer());

        }
    }
    public void kontigentOversigt(){
        //For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt,
        //For seniorsvømmere (18 år og over) 1600 kr. årligt.
        //For medlemmer over 60 år gives der 25 % rabat af seniortaksten.
        //For passivt medlemskab er taksten 500 kr. årligt.
        //For studerende givers der 15 % rabat af seniortaksten.

        for (Medlemmer medlemmer: controller.getMedlemmer()){
            if (medlemmer.getAlder()<18){
               int kontigentUng;
                kontigentUng=1000;
                System.out.println("Kontigent for den medlem er: "+kontigentUng);
            } else if (medlemmer.getAlder()==18 && medlemmer.getAlder()<=60) {
                int kontigentSenior=1600;
                System.out.println("Kontigent for den medlem er: "+kontigentSenior);
            } else if (medlemmer.getAlder()>60){
                double kontigentST=1600*(1-0.25);
                System.out.println("Kontigent for den medlem er: "+kontigentST);
            }else if (medlemmer.isAktivitetsForm()==true){
                double kontigentAktiv=500;
                System.out.println("Kontigent for den medlem er: "+kontigentAktiv);
            } else if (medlemmer.isStuderende()==true){
                double kontigentStud=1600*(1-0.15);
                System.out.println("Kontigent for den medlem er: "+kontigentStud);
            }
        }

    }
}

