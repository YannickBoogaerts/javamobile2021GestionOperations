package be.technifutur.gestionComptes;

import java.io.Serializable;
import java.time.LocalDate;

public class Operation implements Serializable {

    private long id;
    private String libelle;
    private int somme;
    private String compte;
    private LocalDate date;

    public Operation(int id){
        this.id = id;
    }

    public Operation(long id, String libelle, int somme, String compte, LocalDate date) {
        this.id = id;
        this.libelle = libelle;
        this.somme = somme;
        this.compte = compte;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", somme=" + somme +
                ", compte='" + compte + '\'' +
                ", date=" + date +
                '}';
    }
}
