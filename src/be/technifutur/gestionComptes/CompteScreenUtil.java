package be.technifutur.gestionComptes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CompteScreenUtil {
    private static Scanner scan = new Scanner(System.in);

    public static String selectCompte(List<String> comptes) {
        String compte = null;

        while (compte == null) {
            System.out.println("Choix d'un compte");

            for (int i = 0; i < comptes.size(); i++) {
                System.out.printf("  %s - %s%n", i + 1, comptes.get(i));
            }

            int choix = getInt("Choix :");
            if (choix > 0 && choix <= comptes.size()) {
                compte = comptes.get(choix - 1);
            }

        }
        System.out.println(" compte : "+compte);
        return compte;
    }

    public static int getInt(String invite) {
        int result = 0;
        boolean error = true;
        while (error) {
            String input = getInput(invite);
            try {
                result = Integer.parseInt(input);
                error = false;
            } catch (NumberFormatException e) {
                System.out.println(result + " n'est pas un entier");
            }
        }
        return result;
    }

    public static String getInput(String invite) {
        System.out.print(invite);
        return scan.nextLine();
    }

    public static LocalDate getDate(String libelle) {
        LocalDate date = null;
        while (date == null) {
            String input = getInput(libelle + " (jj/mm/aaaa): ");
            try {
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("le format de date n'est pas valide");
            }
        }
        return date;
    }

    public static void affiche(Operation operation) {
        System.out.printf(" %s %15s %d € (%s)%n",
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(operation.getDate()),
                operation.getLibelle(),
                operation.getSomme(),
                operation.getCompte());
    }

}
