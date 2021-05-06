package be.technifutur.gestionComptes;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public abstract class AbstractControler implements Runnable{

    private final String name;
    private Memory memory;

    public AbstractControler(Memory memory, String name) {
        this.memory = memory;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMax_id() {
        return memory.getMax_id();
    }

    public Set<Operation> getOperationSet() {
        return memory.getOperationSet();
    }

    public List<String> getCompteList() {
        return memory.getCompteList();
    }
}
