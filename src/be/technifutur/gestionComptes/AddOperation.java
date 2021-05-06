package be.technifutur.gestionComptes;

import java.time.LocalDate;

public class AddOperation implements Runnable{

    public AddOperation(Services services) {
        this.services = services;
    }
    private final Services services;

    @Override
    public void run() {
        System.out.println("Ajout d'un compte :");
        String compte = CompteScreenUtil.selectCompte(services.getCompteList());
        LocalDate date = CompteScreenUtil.getDate("  Date: ");
        String libelle = CompteScreenUtil.getInput("  libellé: ");
        int montant = CompteScreenUtil.getInt("  Montant: ");
        Operation operation = services.addOperation(libelle, montant, compte, date);
        CompteScreenUtil.affiche(operation);
    }
}
