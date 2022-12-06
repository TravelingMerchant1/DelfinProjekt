package Datahandler;

public class Kontingens {

    public Kontingens(){

    }
    public void kontingentOversigt(Database database) {
        for (Medlem medlem : database.indlæsMedlemmer()) {
            if (medlem.getAlder() < 18) {
                int kontigentUng;
                kontigentUng = 1000;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentUng + " kr.");
            } else if (medlem.getAlder() <= 60) {
                int kontigentSenior = 1600;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentSenior+ " kr.");
            } else if (medlem.getAlder() > 60) {
                double kontigentST = 1600 * (1 - 0.25);
                System.out.println("Kontigent for "+ medlem.getNavn() + "er: " + kontigentST+ " kr.");
            } else if (medlem.isAktivitetsForm() == true) {
                double kontigentAktiv = 500;
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentAktiv+ " kr.");
            } else if (medlem.isStuderende() == true) {
                double kontigentStud = 1600 * (1 - 0.15);
                System.out.println("Kontigent for "+ medlem.getNavn() + " er: " + kontigentStud+ " kr.");
            }
        }
    }

    public double kontingentTotal(Database database) {
        double kontingentTotal = 0;
        for (Medlem medlem : database.indlæsMedlemmer()) {
            double kontingent = 0;
            if (medlem.getAlder() < 18) {
                kontingent = 1000;
            } else if (medlem.getAlder() <= 60) {
                kontingent = 1600;
            } else if (medlem.getAlder() > 60) {
                kontingent = 1600 * (1 - 0.25);
            } else if (medlem.isAktivitetsForm()) {
                kontingent= 500;
            } else if (medlem.isStuderende()) {
                kontingent = 1600 * (1 - 0.15);
            }
            kontingentTotal = kontingent + kontingentTotal;
        }
        return kontingentTotal;
    }
}
