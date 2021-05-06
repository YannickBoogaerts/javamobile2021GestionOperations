package be.technifutur.gestionComptes;

public class ShowSommeInput implements Runnable {
    public ShowSommeInput(Services services) {
        this.services = services;
    }
    private final Services services;


    @Override
    public void run() {
        System.out.printf("La somme des entrées est de : %s%n",services.getsommeInput());
    }
}
