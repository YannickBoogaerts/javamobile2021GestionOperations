package be.technifutur.gestionComptes;


import java.io.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {

    private static File file = new File("operations.ser");

    public static void main(String[] args) throws IOException {

        Optional<Memory> load = loadOperations();
        if (load.isPresent()) {
            Memory memory = load.get();
            Services services = new Services(memory);
            // code de l'application
            MenuControler menuControler = new MenuControler();
            menuControler.addControler(new AddOperation(services),"Ajouter une opération");
            menuControler.addControler(new ShowByDate(services),"Afficher les opérations par date");
            menuControler.addControler(new ShowByCompte(services),"Afficher les opérations d'un compte");
            menuControler.addControler(new ShowPeriodeOperation(services),"Afficher les opérations entre deux dates");
            menuControler.addControler(new ShowSommeInput(services),"Somme des entrées");
            menuControler.addControler(new ShowSommeOutput(services),"Somme des sorties");
            menuControler.addControler(new ShowSoldeByCompte(services),"Afficher le solde d'un compte");
            menuControler.addControler(new ShowSolde(services),"Solde général");

            menuControler.start();


            // System.out.println(memory.getOperationSet());

            saveOperations(memory);
        }


    }

    private static void saveOperations(Memory memory) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));) {

            outputStream.writeObject(memory);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Optional<Memory> loadOperations() {
        Optional<Memory> set = null;
        if (file.exists()) {
            try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file))) {
                set = Optional.of((Memory) objectInput.readObject());
            } catch (IOException | ClassNotFoundException e) {
                set = Optional.empty();
                e.printStackTrace();
            }

        } else {
            set = Optional.of(new Memory());
        }
        return set;
    }
}
