package be.technifutur.gestionComptes;

public class ShowSoldeByCompte implements Runnable {
    private final Services services;

    public ShowSoldeByCompte(Services services) {
        this.services = services;
    }

    @Override
    public void run() {
        String compte = CompteScreenUtil.selectCompte(services.getCompteList());
        System.out.println("\nSolde du compte " + compte);
        System.out.printf("Le solde du compte %s est de : %d €%n", compte, services.getsolde(compte));
    }
}
