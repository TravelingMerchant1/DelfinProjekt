package UI;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Datahandler.*;
import Hold.KonkurrenceSvømmer;

public class UserInterface {
    private int menuvalg;
    private Scanner input = new Scanner(System.in);
    private Controller controller = new Controller();

    //MENUER

    public void startMenu() throws FileNotFoundException {
        controller.restanceFil();
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("Du har nu 3 valgmuligheder.");
        System.out.println("1) Formand");
        System.out.println("2) Kasserer");
        System.out.println("3) Træner");
        System.out.println("9) Luk Program");
        startMenuInput();
    }

    public void startMenuInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                formandMenu();
                break;
            case 2:
                kasserMenu();
                break;
            case 3:
                trænerMenu();
                break;
            case 9:
                closeProgram();
                break;
        }
    }


    public void formandMenu() throws FileNotFoundException {
        System.out.println("Formands Menu:");
        System.out.println("1) Indemeldelse Af Nyt medlem.");
        System.out.println("2) Redigerine Af medlem.");
        System.out.println("3) Slet medlem.");
        System.out.println("4) Oversigt Over medlemmer.");
        System.out.println("5) Oversigt Over Aldersgrupper.");
        System.out.println("9) Tilbage Til Hovedmenu");
        formandMenuInput();
    }

    public void formandMenuInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                indmeldelse();
                break;
            case 2:
                redigerMedlem(input);
                break;
            case 3:
                sletMedlem(input);
                break;
            case 4:
                medlemsOversigt();
                break;
            case 5:
                aldersOversigt();
                break;
            case 9:
                startMenu();
        }
    }

    public void kasserMenu() throws FileNotFoundException {
        System.out.println("Kasser Menu:");
        System.out.println("1) Kontingent Brutto Total.");
        System.out.println("2) Kontingent Per Person.");
        System.out.println("3) Sæt Medlem I Restance.");
        System.out.println("4) Tag Medlem I Restance.");
        System.out.println("5) Restance Oversigt.");
        System.out.println("9) Tilbage Til Hovedmenu");
        kasserMenuInput();
    }

    public void kasserMenuInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                kontingentTotal();
                break;
            case 2:
                kontigentOversigt();
                break;
            case 3:
                sætIRestance();
                break;
            case 4:
                tagUdAfRestance();
                break;
            case 5:
                restanceOverblik();
                break;
            case 9:
                startMenu();
                break;
        }
    }

    public void trænerMenu() throws FileNotFoundException {
        System.out.println("Træner Menu:");
        System.out.println("1) Oversigt Over Hold.");
        System.out.println("2) Oversigt Over Aldersgrupper.");
        System.out.println("3) Træningsresultater.");
        System.out.println("4) Oversigt Til Udtagelse.");
        System.out.println("9) Tilbage Til Hovedmenu");
        trænerMenuInput();
    }

    public void trænerMenuInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 9:
                startMenu();
                break;

        }
    }

    public void menuValgInput() {
        menuvalg = input.nextInt();
        input.nextLine();
    }

    public void closeProgram() {
        System.out.println("Du aflsutter nu programmet");
        System.exit(0);
    }


    public void start() throws FileNotFoundException {
        boolean run = true;
        do {
            startMenu();
        } while (run == true);
    }


    //ALDERSOVERSIGT
    public void aldersOversigt() {
        controller.aldersOversigt();
    }


    //INDMELDELSE, REDIGERING, SLETNING

    public void indmeldelse() {
        String hold = null;
        String disciplin = null;
        boolean korrektInput = false;
        double træningsresultat = 0;
        boolean erCrawler = false;
        boolean erRygcrawler = false;
        boolean erBrystsvømmer = false;
        boolean erButterflyer = false;

        System.out.println("Navn på medlem: ");
        String navn = input.nextLine();

        System.out.println("Efternavn på medlem: ");
        String efternavn = input.nextLine();

        System.out.println("Alder på medlem: ");
        int alder;
        do {
            System.out.println("Indtast venligst et tal mellem 1 og 120");
            while (!input.hasNextInt()) {
                System.out.println("Indtast venligst et tal.");
                input.next();
            }
            alder = input.nextInt();
        } while (alder < 0 || alder > 120);


        System.out.println("Køn på medlem");
        String køn;
        do {
            System.out.println("Indtast venligst M eller K");
            køn = input.next().toLowerCase();
            switch (køn) {
                case "m":
                    køn = "mand";
                    korrektInput = true;
                    break;
                case "k":
                    køn = "kvinde";
                    korrektInput = true;
                    break;
                default:
                    System.out.println("Fejl I Indtastning");
                    break;
            }
        } while (!korrektInput);


        System.out.println("Er medlem en konkurrencesvømmer (M)otionist/(K)onkurrencesvømmer: ");
        boolean erKonkurrenceSvømmer = true;
        do {
            String konkurrenceSvømmerString = input.next().toLowerCase();
            korrektInput = false;
            switch (konkurrenceSvømmerString) {
                case "k":
                    System.out.println("Skal medlem være på crawl hold? J/N");
                    if (input.next().equalsIgnoreCase("j")){
                        erCrawler=true;
                    }
                    System.out.println("Skal medlem være på rygcrawl hold? J/N");
                    if (input.next().equalsIgnoreCase("j")){
                        erRygcrawler=true;
                    }
                    System.out.println("Skal medlem være på brystsvømning hold? J/N");
                    if (input.next().equalsIgnoreCase("j")){
                        erBrystsvømmer=true;
                    }
                    System.out.println("Skal medlem være på butterfly hold? J/N");
                    if (input.next().equalsIgnoreCase("j")){
                        erButterflyer=true;
                    }
                    erKonkurrenceSvømmer = true;
                    korrektInput = true;
                    break;
                case "m":
                    erKonkurrenceSvømmer = false;
                    korrektInput = true;
                    break;
                default:
                    System.out.println("Fejl i indtastning");
                    break;
            }
        } while (!korrektInput);

        System.out.println("Er medlemmet studerende? J/N");
        boolean studerende = true;
        if (input.nextLine().equalsIgnoreCase("j")) {
            studerende = true;
        } else if (input.nextLine().equalsIgnoreCase("n")) {
            studerende = false;
        } else {
            System.out.println("Venligst indtast J/N");
        }


        System.out.println(navn + " er gemt i databasen");

        int medlemsNummer = controller.medlemsNummer();
        controller.nytMedlemsNummer();
        controller.sidsteMedlemsNummer();

        Medlem medlem = controller.nyMedlem(navn, efternavn, alder, køn, erKonkurrenceSvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);
        double tid = 0;

        if (erKonkurrenceSvømmer) {
            KonkurrenceSvømmer konkurrenceSvømmer = controller.nyKonkurrenceSvømmer(navn, efternavn, alder, køn, medlemsNummer, tid);
            if (erCrawler){
                controller.gemMedlemCrawl();
            }
            if (erRygcrawler){
                controller.gemMedlemRygcrawl();
            }
            if (erBrystsvømmer){
                controller.gemMedlemBrystsvømning();
            }
            if (erButterflyer){
                controller.gemMedlemButtefly();
            }
        }
        System.out.println("---------------------------------");
        udskrivMedlem(medlem);
        if (erKonkurrenceSvømmer) {
            System.out.println("Medlem er skrevet op til:");
            if (erCrawler) {
                System.out.println("Crawl");
            }
            if (erRygcrawler) {
                System.out.println("Rygcrawl");
            }
            if (erBrystsvømmer) {
                System.out.println("Brystvømning");
            }
            if (erButterflyer) {
                System.out.println("Butterfly");
            }
        }
        System.out.println("---------------------------------");
        controller.gemData();
    }


    public void redigerMedlem(Scanner input) {
        for (int i = 0; i < controller.indlæsMedlemmer().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsMedlemmer().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsMedlemmer().get(i)));
        }

        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        Medlem editMedlem = controller.indlæsMedlemmer().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + navnMedStort(editMedlem));

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + editMedlem.getNavn());
        String nyNavn = input.nextLine();

        System.out.println("Efternavn: " + editMedlem.getEfternavn());
        String nyEfternavn = input.nextLine();


        System.out.println("Alder: " + editMedlem.getAlder());
        String nyAlder = input.nextLine();


        System.out.println("Køn: " + editMedlem.getKøn());
        String nyKøn = input.nextLine();

        System.out.println("Konkurrencesvømmer: " + editMedlem.isKonkurrenceSvømmer());
        String nyKonkurrencesvømmer = input.nextLine();

        controller.redigerMedlem(nr, nyNavn, nyEfternavn, nyAlder, nyKøn, nyKonkurrencesvømmer);

    }

    public void sletMedlem(Scanner input) {
        for (int i = 0; i < controller.indlæsMedlemmer().size(); i++) {
            System.out.println(i + 1 + ")" + "Medlems nummer: " + controller.indlæsMedlemmer().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsMedlemmer().get(i)));
        }
        System.out.println("indtast nummer på medlem der skal slettes:");
        int nr = input.nextInt();
        input.nextLine();
        System.out.println("Medlem " + nr + ", Navn: " + navnMedStort(controller.indlæsMedlemmer().get(nr)) + " er slettet fra systemet");
        controller.sletMedlem(nr);
    }

    //OVERSIGT
    public void medlemsOversigt() {
        System.out.println(controller.indlæsMedlemmer());
        for (Medlem medlem : controller.indlæsMedlemmer()) {
            System.out.println(medlem.getNavn() + " " + medlem.getEfternavn());
        }

    }

    //KONTINGENT

    public void kontigentOversigt() {
        controller.kontingentOversigt();
    }

    public void kontingentTotal() {
        System.out.println("Den totale bruttoindkomst er: " + controller.kontingentTotal() + " kr.");
    }

    //RESTANCE

    public void sætIRestance() {
        for (int i = 0; i < controller.indlæsIkkeIRestance().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsIkkeIRestance().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsIkkeIRestance().get(i)));
        }

        System.out.println("indtast nummer på medlem der skal flyttes til restance:");
        int nr = input.nextInt();
        input.nextLine();
        System.out.println("Medlem: " + navnMedStort(controller.indlæsIkkeIRestance().get(nr)) + ", " + controller.indlæsIkkeIRestance().get(nr).getMedlemsNummer() +" sat i af restance.");
        controller.sætIRestance(nr);


    }

    public void tagUdAfRestance(){
        for (int i = 0; i < controller.indlæsIRestance().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsIRestance().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsIRestance().get(i)));
        }

        System.out.println("indtast nummer på medlem der skal flyttes til restance:");
        int nr = input.nextInt();
        input.nextLine();
        System.out.println("Medlem: " + navnMedStort(controller.indlæsIRestance().get(nr))+ ", " + controller.indlæsIkkeIRestance().get(nr).getMedlemsNummer()+ " taget ud af restance.");
        controller.tagUdAfRestance(nr);


    }
    public void restanceOverblik() {
        for (int i = 0; i < controller.indlæsIRestance().size(); i++) {
                System.out.println(i + 1 + ") " + controller.indlæsIRestance().get(i).getMedlemsNummer() + " " + navnMedStort(controller.indlæsIRestance().get(i)));
        }
    }

    //DIVERSE
    private void udskrivMedlem(Medlem medlem) {
        System.out.println("Navn: " + navnMedStort(medlem));
        System.out.println("Alder: " + medlem.getAlder());
        System.out.println("Køn: " + medlem.getKøn());
        System.out.println("Konkurrencesvømmer: " + medlem.isKonkurrenceSvømmer());
        System.out.println("Medlemsnummer : " + medlem.getMedlemsNummer());

    }

    public String navnMedStort(Medlem medlem) {
        String navnMedStort = "";
        String førsteBogstavFornavn = medlem.getNavn().substring(0, 1).toUpperCase();
        String fornavn = førsteBogstavFornavn + medlem.getNavn().substring(1);

        String førsteBogstavEfternavn = medlem.getEfternavn().substring(0, 1).toUpperCase();
        String efternavn = førsteBogstavEfternavn + medlem.getEfternavn().substring(1);

        navnMedStort = fornavn + " " + efternavn;

        return navnMedStort;
    }


}
