package be.technifutur.gestionComptes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class ShowPeriodeOperation implements Runnable {
    public ShowPeriodeOperation(Services services) {
        this.services = services;
    }
    private final Services services;


    @Override
    public void run() {
        System.out.println("Opération entre deux dates");
        LocalDate debut = CompteScreenUtil.getDate("Date de début");
        LocalDate fin = CompteScreenUtil.getDate("Date de fin");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Opération entre le %s et le %s%n", formatter.format(debut), formatter.format(fin));
        for (Operation op : services.getOperationBetween(debut,fin)){
                CompteScreenUtil.affiche(op);
        }
        System.out.println();
    }
}
