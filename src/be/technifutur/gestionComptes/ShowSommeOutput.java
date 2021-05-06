package be.technifutur.gestionComptes;

public class ShowSommeOutput implements Runnable {
    public ShowSommeOutput(Services services) {
        this.services = services;
    }
    private final Services services;
    @Override
    public void run() {
        System.out.printf("La somme des sorties est de : %s%n",services.getsommeOutput());
    }
}
