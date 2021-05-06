package be.technifutur.gestionComptes;



import java.util.ArrayList;
import java.util.List;

public class MenuControler {
    private List<ItemMenu> controlerList = new ArrayList<>();

    public void addControler(Runnable controler, String itemName) {
        this.controlerList.add(new ItemMenu(itemName,controler));
    }

    public void start() {
        afficheMenu();
        int choix = CompteScreenUtil.getInt("choix:");
        while ( choix != 0){
            if(choix>0 && choix<= controlerList.size()){
                controlerList.get(choix-1).run();
                CompteScreenUtil.getInput("entrer pour continuer");
            }
            afficheMenu();
            choix = CompteScreenUtil.getInt("choix:");
        }
    }

    private void afficheMenu() {
        for (int i = 0; i < controlerList.size(); i++) {
            System.out.printf("%s - %s%n",i+1,controlerList.get(i).getName());

        }
        System.out.printf("%s - %s%n",0,"Quitter");
    }
}
