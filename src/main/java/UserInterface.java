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

                case 5:

                case 6:
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
        boolean aktivitetsform = input.nextBoolean();

        System.out.println("Er medlem en konkurrencesvømmer (Motionist/Konkurrencesvømmer): ");
        boolean konkurrencesvømmer = input.nextBoolean();

        System.out.println("Medlem er gemt i databasen");
        controller.nyMedlem(navn, efternavn, alder, køn, aktivitetsform, konkurrencesvømmer);
        for (Medlemmer medlemmer : controller.getMedlemmer()) {
            System.out.println("---------------------------------");
            System.out.println("Navn: " + navn + " " + efternavn);
            System.out.println("Alder: " + alder);
            System.out.println("Køn: " + køn);
            System.out.println("Aktivitetsform: " + aktivitetsform);
            System.out.println("Konkurrencesvømmer: " + konkurrencesvømmer);
            System.out.println("---------------------------------");
        }
        input.nextLine();
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

    public void sletteMedlemmer () {
        for (int i = 0; i < controller.getMedlemmer().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getMedlemmer().get(i));
        }

        System.out.println("indtast nummer på medlem der skal slettes:");
        int nr = input.nextInt();
        input.nextLine();

        Medlemmer sletMedlem = controller.getMedlemmer().remove(nr - 1); // index starter fra 0
        System.out.println("Medlem " + sletMedlem + " er slettet fra systemet");

    }
}

