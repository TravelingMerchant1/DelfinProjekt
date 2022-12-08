package UI;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Medlemmer.KonkurrenceSvømmer;
import Medlemmer.Medlem;

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
        System.out.println("1) Hold Oversigt");
        System.out.println("2) Rediger Tider");
        System.out.println("3) Bedste Svømmer Fra Hold Oversigt");
        trænerMenuInput();
    }

    public void trænerMenuInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                trænerHoldOversigt();
                break;
            case 2:
                trænerRedigerTiderOversigt();
                break;
            case 3:
                trænerBedstSvømmereOversigt();
                break;
            case 9:
                startMenu();
                break;

        }
    }

    public void trænerHoldOversigt() throws FileNotFoundException {
        System.out.println("Hvilket hold vil du have oversigt over?");
        System.out.println("1) Crawl");
        System.out.println("2) Rygcrawl");
        System.out.println("3) Brystsvømning");
        System.out.println("4) Butterfly");
        trænerHoldOversigtInput();
    }

    public void trænerHoldOversigtInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                juniorCrawl();
                seniorCrawl();
                break;
            case 2:
                juniorRygcrawl();
                seniorRygcrawl();
                break;
            case 3:
                juniorBryst();
                seniorBryst();
                break;
            case 4:
                juniorButterfly();
                seniorButterfly();
                break;
            case 9:
                startMenu();
                break;
        }
    }

    public void trænerRedigerTiderOversigt() throws FileNotFoundException {
        System.out.println("Fra hvilket hold vil du have redigere en svømmers tid?");
        System.out.println("1) Crawl");
        System.out.println("2) Rygcrawl");
        System.out.println("3) Brystsvømning");
        System.out.println("4) Butterfly");
        trænerRedigerTiderOversigtInput();
    }

    public void trænerRedigerTiderOversigtInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                redigerCrawlTid(input);
                break;
            case 2:
                redigerRygcrawlTid(input);
                break;
            case 3:
                redigerBrystsvømningTid(input);
                break;
            case 4:
                redigerButterflyTid(input);
                break;
            case 9:
                startMenu();
                break;
        }
    }

    public void trænerBedstSvømmereOversigt() throws FileNotFoundException {
        System.out.println("Hvilket hold vil du have oversigt over de bedste svømmere?");
        System.out.println("1) Crawl");
        System.out.println("2) Rygcrawl");
        System.out.println("3) Brystsvømning");
        System.out.println("4) Butterfly");
        trænerBedsteSvømmereOversigtInput();
    }

    public void trænerBedsteSvømmereOversigtInput() throws FileNotFoundException {
        menuValgInput();
        switch (menuvalg) {
            case 1:
                sorterCrawlTidJunior();
                sorterCrawlTidSenior();

                break;
            case 2:
                sorterRygcrawlTidJunior();
                sorterRygcrawlTidSenior();
                break;
            case 3:
                sorterBrystsvømningTidJunior();
                sorterBrystsvømningTidSenior();
                break;
            case 4:
                sorterButterflyTidJunior();
                sorterButterflyTidSenior();
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
                    if (input.next().equalsIgnoreCase("j")) {
                        erCrawler = true;
                    }
                    System.out.println("Skal medlem være på rygcrawl hold? J/N");
                    if (input.next().equalsIgnoreCase("j")) {
                        erRygcrawler = true;
                    }
                    System.out.println("Skal medlem være på brystsvømning hold? J/N");
                    if (input.next().equalsIgnoreCase("j")) {
                        erBrystsvømmer = true;
                    }
                    System.out.println("Skal medlem være på butterfly hold? J/N");
                    if (input.next().equalsIgnoreCase("j")) {
                        erButterflyer = true;
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
            if (erCrawler) {
                controller.gemMedlemCrawl();
            }
            if (erRygcrawler) {
                controller.gemMedlemRygcrawl();
            }
            if (erBrystsvømmer) {
                controller.gemMedlemBrystsvømning();
            }
            if (erButterflyer) {
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
    public void aldersOversigt() {
        controller.aldersOversigt();
    }

    public void medlemsOversigt() {
        System.out.println(controller.indlæsMedlemmer());
        for (Medlem medlem : controller.indlæsMedlemmer()) {
            System.out.println(medlem.getNavn() + " " + medlem.getEfternavn());
        }

    }

    public void juniorCrawl() {
        System.out.println("Junior Crawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsCrawl()) {
            if (konkurrenceSvømmer.getAlder() < 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
    }

    public void seniorCrawl() {
        System.out.println("Senior Crawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsCrawl()) {
            if (konkurrenceSvømmer.getAlder() >= 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
    }

    public void juniorRygcrawl() {
        System.out.println("Junior Rygcrawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsRygcrawl()) {
            if (konkurrenceSvømmer.getAlder() < 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
    }

    public void seniorRygcrawl() {
        System.out.println("Senior Rygcrawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsRygcrawl()) {
            if (konkurrenceSvømmer.getAlder() >= 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
    }

    public void juniorBryst() {
        System.out.println("Junior Brystsvømnings Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsBrystsvømning()) {
            if (konkurrenceSvømmer.getAlder() < 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }


        System.out.println("---------------------------------");
    }

    public void seniorBryst() {
        System.out.println("Senior Brystsvømnings Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsBrystsvømning()) {
            if (konkurrenceSvømmer.getAlder() >= 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
    }

    public void juniorButterfly() {
        System.out.println("Junior Rygcrawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsButterfly()) {
            if (konkurrenceSvømmer.getAlder() < 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }


        System.out.println("---------------------------------");
    }

    public void seniorButterfly() {
        System.out.println("Senior Rygcrawl Hold, Træner: Jens");

        System.out.println("---------------------------------");
        for (KonkurrenceSvømmer konkurrenceSvømmer : controller.indlæsButterfly()) {
            if (konkurrenceSvømmer.getAlder() >= 18) {
                System.out.println("Medlemsnummer: " + konkurrenceSvømmer.getMedlemsNummer() + ", " + navnMedStort(konkurrenceSvømmer) + ". Bedste tid: " + konkurrenceSvømmer.getTid() + " sek.");
            }
        }
        System.out.println("---------------------------------");
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
        System.out.println("Medlem: " + navnMedStort(controller.indlæsIkkeIRestance().get(nr)) + ", " + controller.indlæsIkkeIRestance().get(nr).getMedlemsNummer() + " sat i af restance.");
        controller.sætIRestance(nr);


    }

    public void tagUdAfRestance() {
        for (int i = 0; i < controller.indlæsIRestance().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsIRestance().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsIRestance().get(i)));
        }

        System.out.println("indtast nummer på medlem der skal flyttes til restance:");
        int nr = input.nextInt();
        input.nextLine();
        System.out.println("Medlem: " + navnMedStort(controller.indlæsIRestance().get(nr)) + ", " + controller.indlæsIkkeIRestance().get(nr).getMedlemsNummer() + " taget ud af restance.");
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

    //REDIGER SVØMMETIDER
    public void redigerCrawlTid(Scanner input) {
        for (int i = 0; i < controller.indlæsCrawl().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsCrawl().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsCrawl().get(i)));
        }
        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();
        if (nr<0 || nr> controller.indlæsCrawl().size()) {
            System.out.println(("indtast det rigtig nummer."));
            return;
        }
        KonkurrenceSvømmer redigerCrawlTid = controller.indlæsCrawl().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + navnMedStort(redigerCrawlTid) + ", Bedste Tid: " + redigerCrawlTid.getTid());

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + redigerCrawlTid.getNavn() + " har en tid på " + redigerCrawlTid.getTid());
        String nyTid = input.nextLine();

        controller.redigerCrawlTid(nr, nyTid);

    }

    public void redigerRygcrawlTid(Scanner input) {
        for (int i = 0; i < controller.indlæsRygcrawl().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsRygcrawl().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsRygcrawl().get(i)));
        }
        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        KonkurrenceSvømmer redigerRygcrawlTid = controller.indlæsRygcrawl().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + navnMedStort(redigerRygcrawlTid) + ", Bedste Tid: " + redigerRygcrawlTid.getTid());

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + redigerRygcrawlTid.getNavn() + " har en tid på " + redigerRygcrawlTid.getTid());
        String nyTid = input.nextLine();

        controller.redigerRygcrawlTid(nr, nyTid);

    }

    public void redigerBrystsvømningTid(Scanner input) {
        for (int i = 0; i < controller.indlæsBrystsvømning().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsBrystsvømning().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsBrystsvømning().get(i)));
        }
        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        KonkurrenceSvømmer redigerBrystsvømningTid = controller.indlæsBrystsvømning().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + navnMedStort(redigerBrystsvømningTid) + ", Bedste Tid: " + redigerBrystsvømningTid.getTid());

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + redigerBrystsvømningTid.getNavn() + " har en tid på " + redigerBrystsvømningTid.getTid());
        String nyTid = input.nextLine();

        controller.redigerBrystsvømningTid(nr, nyTid);

    }

    public void redigerButterflyTid(Scanner input) {
        for (int i = 0; i < controller.indlæsButterfly().size(); i++) {
            System.out.println(i + 1 + ") Medlem Nummer: " + controller.indlæsButterfly().get(i).getMedlemsNummer() + ": " + navnMedStort(controller.indlæsButterfly().get(i)));
        }
        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        KonkurrenceSvømmer redigerButterflyTid = controller.indlæsButterfly().get(nr - 1); // index starter fra 0
        System.out.println("Edit medlem: " + navnMedStort(redigerButterflyTid) + ", Bedste Tid: " + redigerButterflyTid.getTid());

        System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

        System.out.println("Navn: " + redigerButterflyTid.getNavn() + " har en tid på " + redigerButterflyTid.getTid());
        String nyTid = input.nextLine();

        controller.redigerButterflyTid(nr, nyTid);

    }

    //SORTER EFTER TID
    public void sorterCrawlTidJunior() {
        int counter = 1;
        System.out.println("Junior Crawl Bedste Tider:");

        for (int i = 0; i < controller.sorterCrawlTid().size(); i++) {
            if (controller.sorterRygcrawlTid().get(i).getAlder() < 18) {
                System.out.println(counter + ") " + controller.sorterRygcrawlTid().get(i).getNavn() + ", Tid: " + controller.sorterCrawlTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterCrawlTidSenior() {
        int counter = 1;
        System.out.println("Senior Crawl Bedste Tider:");

        for (int i = 0; i < controller.sorterRygcrawlTid().size(); i++) {
            if (controller.sorterRygcrawlTid().get(i).getAlder() >= 18) {
                System.out.println(counter + ") " + controller.sorterCrawlTid().get(i).getNavn() + ", Tid: " + controller.sorterBrystsvømningTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterRygcrawlTidJunior() {
        int counter = 1;
        System.out.println("Junior Rygcrawl Bedste Tider:");

        for (int i = 0; i < controller.sorterRygcrawlTid().size(); i++) {
            if (controller.sorterRygcrawlTid().get(i).getAlder() < 18) {
                System.out.println(counter + ") " + controller.sorterRygcrawlTid().get(i).getNavn() + ", Tid: " + controller.sorterRygcrawlTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterRygcrawlTidSenior() {
        int counter = 1;
        System.out.println("Senior Rygcrawl Bedste Tider:");

        for (int i = 0; i < controller.sorterRygcrawlTid().size(); i++) {
            if (controller.sorterRygcrawlTid().get(i).getAlder() >= 18) {
                System.out.println(counter + ") " + controller.sorterRygcrawlTid().get(i).getNavn() + ", Tid: " + controller.sorterRygcrawlTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterBrystsvømningTidJunior() {
        int counter = 1;
        System.out.println("Junior Brystsvømning Bedste Tider:");

        for (int i = 0; i < controller.sorterBrystsvømningTid().size(); i++) {
            if (controller.sorterBrystsvømningTid().get(i).getAlder() < 18) {
                System.out.println(counter + ") " + controller.sorterBrystsvømningTid().get(i).getNavn() + ", Tid: " + controller.sorterBrystsvømningTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterBrystsvømningTidSenior() {
        int counter = 1;
        System.out.println("Senior Brystsvømning Bedste Tider:");

        for (int i = 0; i < controller.sorterBrystsvømningTid().size(); i++) {
            if (controller.sorterBrystsvømningTid().get(i).getAlder() >= 18) {
                System.out.println(counter + ") " + controller.sorterBrystsvømningTid().get(i).getNavn() + ", Tid: " + controller.sorterBrystsvømningTid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterButterflyTidJunior() {
        int counter = 1;
        System.out.println("Junior Butterfly Bedste Tider:");

        for (int i = 0; i < controller.sorterButterflyEftertid().size(); i++) {
            if (controller.sorterButterflyEftertid().get(i).getAlder() < 18) {
                System.out.println(counter + ") " + controller.sorterButterflyEftertid().get(i).getNavn() + ", Tid: " + controller.sorterButterflyEftertid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }

    public void sorterButterflyTidSenior() {
        int counter = 1;
        System.out.println("Senior Butterfly Bedste Tider:");

        for (int i = 0; i < controller.sorterButterflyEftertid().size(); i++) {
            if (controller.sorterButterflyEftertid().get(i).getAlder() >= 18) {
                System.out.println(counter + ") " + controller.sorterButterflyEftertid().get(i).getNavn() + ", Tid: " + controller.sorterButterflyEftertid().get(i).getTid());
                counter++;
            }
            if (counter > 5) {
                break;
            }
        }
    }
}