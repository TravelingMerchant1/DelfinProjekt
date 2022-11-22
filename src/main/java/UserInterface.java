import java.util.Scanner;

public class UserInterface {
    private Scanner input = new Scanner(System.in);

    public void menuText() {
        System.out.println("Velkommen til Delfinens administrative system");
        System.out.println("1) Indmeldelse af nye medlemmer");
        System.out.println("2) Oversigt over medlemmer");
        System.out.println("3) Opdater medlemmers resultater");
        System.out.println("5) Kontigent oversigt");
        System.out.println("6) Oversigt over hold");
        System.out.println("7) Exit");
    }

    public void start() {
        String menuInput = input.nextLine().toLowerCase();
        switch (menuInput) {
            case "1":
                indmeldelse();
                break;
            case "2":

            case "3":

            case "4":

            case "5":

            case "6":

            case "7":

        }
    }

    public void indmeldelse() {

    }
}
