package be.technifutur.gestionComptes;

import java.util.Comparator;
import java.util.TreeSet;

public class ShowByDate implements Runnable {
    public ShowByDate(Services services) {
        this.services = services;
    }
    private final Services services;


    @Override
    public void run() {
        System.out.println("\nOpération par date :");
        for(Operation o : services.getOperationByDate()){
            CompteScreenUtil.affiche(o);
        }
        System.out.println();
    }
}
