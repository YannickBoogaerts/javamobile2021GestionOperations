package be.technifutur.gestionComptes;

public class ShowSolde implements Runnable {

    private final Services services;

    public ShowSolde(Services services) {
        this.services = services;
    }

    @Override
    public void run() {
        System.out.printf("Le solde général est de : %d €%n", services.getsolde());
    }
}
