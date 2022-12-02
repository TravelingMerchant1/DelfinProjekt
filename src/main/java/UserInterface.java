import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private int menuvalg;
    private Scanner input = new Scanner(System.in);
    private Controller controller = new Controller();

    public void startMenu() throws FileNotFoundException {
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
        System.out.println("1) Indemeldelse Af Nyt Medlem.");
        System.out.println("2) Redigerine Af Medlem.");
        System.out.println("3) Slet Medlem.");
        System.out.println("4) Oversigt Over Medlem.");
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
                redigerMedlem();
                break;
            case 3:
                sletMedlem();
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
        System.out.println("1) Kontingent Oversigt.");
        System.out.println("2) Kontingent Per Person.");
        System.out.println("3) Restance Oversigt.");
        System.out.println("4) Rediger Medlems Restance.");
        System.out.println("9) Tilbage Til Hovedmenu");
        kasserMenuInput();
    }

    public void kasserMenuInput() throws FileNotFoundException {
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
                trænerMenu();
                break;
            case 9:
                startMenu();
                break;

        }
    }

    public void closeProgram() throws FileNotFoundException {
        System.out.println("Du aflsutter nu programmet");
        gemData();
        System.exit(0);
    }


    public void start() throws FileNotFoundException {
        boolean run = true;
        do {
            startMenu();
        } while (run == true);
    }

    public void aldersOversigt() {
        controller.aldersOversigt();
    }

    public void gemData() throws FileNotFoundException {
        controller.gemData();
    }

    public void menuValgInput() {
        menuvalg = input.nextInt();
        input.nextLine();
    }


    public void indmeldelse() {
        String hold = null;
        String disciplin = null;
        double træningsresultat = 0;
        System.out.println(controller.getDatabase().medlemsNummer());
        int medlemsNummer = controller.getDatabase().medlemsNummer();


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
        } while (alder < 0 || alder >120);


        System.out.println("Køn på medlem");
        boolean korrektInput = false;
        Scanner scanner = new Scanner(System.in);
        String køn = "";
        while(!korrektInput) {
            System.out.println("Indtast venligst M eller K");
            køn = scanner.nextLine().toLowerCase();
            switch (køn){
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
            }
        }


        System.out.println("aktivitetsform på medlem (Aktiv/Passiv): ");
        boolean aktivitetsform = true;
        if (input.nextLine().equalsIgnoreCase("aktiv")) {
            aktivitetsform = true;
        } else if (input.nextLine().equalsIgnoreCase("passiv")) {
            aktivitetsform = false;
        } else if (!input.nextLine().equalsIgnoreCase("aktiv") || !input.nextLine().equalsIgnoreCase("passiv")) {
            System.out.println("Venligst indtast Aktiv/Passiv");
        }

        System.out.println("Er medlem en konkurrencesvømmer (Motionist/Konkurrencesvømmer): ");
        boolean konkurrencesvømmer = true;
        if (input.nextLine().equalsIgnoreCase("aktiv")) {
            konkurrencesvømmer = true;
        } else if (input.nextLine().equalsIgnoreCase("passiv")) {
            konkurrencesvømmer = false;
        } else {
            System.out.println("Venligst indtast J/N");
        }

        if (konkurrencesvømmer) {
            System.out.println("Hvilket hold skal medlem være en del af? (Junior/Senior)");
            hold = input.nextLine();

            System.out.println("Hvilken disciplin skal medlem svømme i?");
            disciplin = input.nextLine();
        }

        System.out.println("Er medlemmet studerende? J/N");
        boolean studerende = true;
        if (input.nextLine().equalsIgnoreCase("aktiv")) {
            studerende = true;
        } else if (input.nextLine().equalsIgnoreCase("passiv")) {
            studerende = false;
        } else {
            System.out.println("Venligst indtast J/N");
        }


        System.out.println("Medlem er gemt i databasen");

        Medlem medlem = controller.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);

        System.out.println("---------------------------------");
        udskrivMedlem(medlem);
        System.out.println("---------------------------------");
    }

    public void navn(){

    }

    public void redigerMedlem() {
        for (int i = 0; i < controller.getMedlemmer().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMedlemmer().get(i));
        }

        System.out.println("indtast nummer på medlem der skal redigeres:");
        int nr = input.nextInt();
        input.nextLine();

        Medlem editMedlem = controller.getMedlemmer().get(nr - 1); // index starter fra 0
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

    public void sletMedlem() {
        for (int i = 0; i < controller.getMedlemmer().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMedlemmer().get(i));
        }

        System.out.println("indtast nummer på medlem der skal slettes:");
        int nr = input.nextInt();
        input.nextLine();

        // TODO: Lav en deleteMedlem metode i controller i stedet
        Medlem sletMedlem = controller.getMedlemmer().remove(nr - 1); // index starter fra 0
        System.out.println("Medlem " + sletMedlem + " er slettet fra systemet");

    }

    public void medlemsOversigt() {
        System.out.println(controller.getFilehandler().indlæsMedlemmer());
        for (Medlem medlem : controller.getFilehandler().indlæsMedlemmer()) {
            System.out.println(medlem.getNavn() + " " + medlem.getEfternavn());
        }

    }


    private void udskrivMedlem(Medlem medlem) {
        System.out.println("Navn: " + medlem.getNavn() + " " + medlem.getEfternavn());
        System.out.println("Alder: " + medlem.getAlder());
        System.out.println("Køn: " + medlem.getKøn());
        System.out.println("Aktivitetsform: " + medlem.isAktivitetsForm());
        System.out.println("Konkurrencesvømmer: " + medlem.isKonkurrenceSvømmer());
        System.out.println("Medlemsnummer : " + medlem.getMedlemsNummer());
    }

    public void kontigentOversigt() {
        controller.kontingentOversigt();
    }

    public void kontingentTotal() {
        System.out.println("Den totale bruttoindkomst er: " + controller.kontingentTotal() + " kr.");
    }


}

