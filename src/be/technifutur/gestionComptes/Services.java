package be.technifutur.gestionComptes;

import java.time.LocalDate;
import java.util.*;

public class Services {

    private Memory memory;

    public Services(Memory memory) {
        this.memory = memory;
    }

    List<Operation> getOperationbyCompte(String compte) {
        ArrayList<Operation> operations = new ArrayList<>();

        for (Operation op : memory.getOperationSet()) {
            if (compte.equals(op.getCompte())) {
                operations.add(op);
            }
        }

        return operations;
    }


    public List<String> getCompteList() {
        return memory.getCompteList();
    }

    public long getMax_id() {
        int max_id = memory.getMax_id();
        memory.setMax_id(max_id++);
        return max_id;
    }

    public Operation addOperation(String libelle, int montant, String compte, LocalDate date) {
        Operation operation = new Operation(memory.getMax_id(), libelle, montant, compte, date);
        memory.getOperationSet().add(operation);
        return operation;
    }

    public List<Operation> getOperationList(String compte) {
        ArrayList<Operation> operations = new ArrayList<>();
        for (Operation op : memory.getOperationSet()) {
            if (compte.equals(op.getCompte())) {
                operations.add(op);
            }
        }
        return operations;
    }

    public Collection<Operation> getOperationBetween(LocalDate debut, LocalDate fin) {
        SortedSet<Operation> operationByDate = getOperationByDate();
        Iterator<Operation> iterator = operationByDate.iterator();
        while (iterator.hasNext()) {
            LocalDate date = iterator.next().getDate();
            if (date.isBefore(debut) || date.isAfter(fin)) {
                iterator.remove();
            }

        }
        return operationByDate;
    }

    public SortedSet<Operation> getOperationByDate() {
        TreeSet<Operation> operations = new TreeSet<>(getByDateComparator());

        for (Operation op : memory.getOperationSet()) {
            operations.add(op);
        }
        return operations;
    }

    private Comparator<Operation> getByDateComparator() {
        Comparator<Operation> comp = Comparator.comparing(o -> o.getDate());
        comp = comp.thenComparingLong(o -> o.getId());
        return comp;
    }

    public int getsommeInput() {
        int somme = 0;
        for (Operation op : memory.getOperationSet()) {
            int montant = op.getSomme();
            if (montant > 0) {
                somme += montant;
            }
        }
        return somme;
    }

    public int getsolde() {
        int somme = 0;
        for (Operation op : memory.getOperationSet()) {
            somme += op.getSomme();
        }
        return somme;
    }

    public int getsolde(String compte) {
        int solde = 0;
        for(Operation op : memory.getOperationSet()){
            if(compte.equals(op.getCompte())){
                solde += op.getSomme();
            }
        }
        return solde;
    }

    public int getsommeOutput() {
        int somme = 0;
        for (Operation op : memory.getOperationSet()) {
            int montant = op.getSomme();
            if (montant < 0) {
                somme += montant;
            }
        }
        return somme;
    }
}
