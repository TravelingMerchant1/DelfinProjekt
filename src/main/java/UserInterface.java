import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private int menuvalg;
    private Scanner input = new Scanner(System.in);
    private Controller controller = new Controller();

    public void menu() {
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("1) Indmeldelse af nye medlemmer");
        System.out.println("2) Redigere medlemmer oplysninger");
        System.out.println("3) Slette medlemmer");
        System.out.println("4) Oversigt over medlemmer");
        System.out.println("5) Opdater medlemmers resultater");
        System.out.println("6) Kontigent oversigt");
        System.out.println("7) Oversigt over hold");
        System.out.println("8) Oversigt over aldersgrupper");
        System.out.println("10) Total Kontingent");
        System.out.println("9) Exit");
    }

    public void start() throws FileNotFoundException {

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
//                    controller.sorteretMedlemmer();
                    break;
                case 6:
                    kontigentOversigt();
                    break;
                case 8:
                    controller.aldersOversigt();
                    break;
                case 10:
                    kontingentTotal();
                    break;


            }
        } while (menuvalg != 9);
        System.out.println("Du aflsutter nu programmet");
        controller.saveData();
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
        int alder = input.nextInt();
        input.nextLine();

        System.out.println("Køn på medlem: ");
        String køn = input.nextLine();

        System.out.println("aktivitetsform på medlem (Aktiv/Passiv): ");
        boolean aktivitetsform = true;
        if (input.nextLine().equalsIgnoreCase("aktiv")) {
            aktivitetsform = true;
        } else if (input.nextLine().equalsIgnoreCase("passiv")) {
            aktivitetsform = false;
        }

        System.out.println("Er medlem en konkurrencesvømmer (Motionist/Konkurrencesvømmer): ");
        boolean konkurrencesvømmer = input.nextBoolean();

        if (konkurrencesvømmer) {
            System.out.println("Hvilket hold skal medlem være en del af? (Junior/Senior)");
            hold = input.nextLine();

            System.out.println("Hvilken disciplin skal medlem svømme i?");
            disciplin = input.nextLine();
        }

        System.out.println("Er medlemmet studerende?");
        boolean studerende = input.nextBoolean();

        System.out.println("Medlem er gemt i databasen");

        Medlem medlem = controller.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer, hold, disciplin, træningsresultat, studerende, medlemsNummer);

        System.out.println("---------------------------------");
        udskrivMedlem(medlem);
        System.out.println("---------------------------------");
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

    public void sletteMedlemmer() {
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
    public void kontingentTotal(){
        System.out.println("Den totale bruttoindkomst er: " + controller.kontingentTotal() + " kr.");
    }


}

