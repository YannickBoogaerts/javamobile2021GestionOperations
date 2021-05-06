package be.technifutur.gestionComptes;

public class ShowByCompte implements Runnable{
    public ShowByCompte(Services services) {
        this.services = services;
    }
    private final Services services;


    @Override
    public void run() {
        String compte = CompteScreenUtil.selectCompte(services.getCompteList());

        System.out.println("\nOpération du compte "+compte);
        for(Operation op : services.getOperationList(compte)){
                CompteScreenUtil.affiche(op);
        }
        System.out.println();
    }
}
