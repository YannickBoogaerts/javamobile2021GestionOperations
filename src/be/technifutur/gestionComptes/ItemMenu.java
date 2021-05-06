package be.technifutur.gestionComptes;

public class ItemMenu implements Runnable{

    private String name;
    private Runnable action;

    public ItemMenu(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        action.run();
    }
}
