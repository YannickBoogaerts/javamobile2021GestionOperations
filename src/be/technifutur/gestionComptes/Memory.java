package be.technifutur.gestionComptes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Memory implements Serializable {

    private int max_id;
    private Set<Operation> operationSet = new HashSet<>();
    private List<String> compteList = Arrays.asList("vacances", "nourriture", "maison");


    public int getMax_id() {
        return max_id;
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public List<String> getCompteList() {
        return compteList;
    }

    public void setMax_id(int max_id) {
        this.max_id = max_id;
    }
}
