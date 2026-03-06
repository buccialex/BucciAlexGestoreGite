/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexleonardogorettigestoregite;
import java.util.*;
/**
 *
 * @author bucci.alex
 */
public class Gita {
    /**
     * attributi
     */
    private String luogo;
    private String idGita;
    private Integer durata;
    private HashMap<String, Studente> mappaStudenti;
    
    public Gita(String luogo, String idGita, int durata){
        if(luogo.isEmpty() || idGita.isEmpty()){
            throw new IllegalArgumentException("Riempi tutte le caselle");
        }
        this.luogo = luogo;
        this.durata = durata;
        this.idGita = idGita;
        this.mappaStudenti = new HashMap<String, Studente>();
    }
    
    public boolean aggiungiStudente(Studente s){
        if (this.mappaStudenti.containsKey(s.getMatricola())) {
            return false;
        }
        this.mappaStudenti.put(s.getMatricola(), s);
        return true;
    }

    
    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getIdGita() {
        return idGita;
    }

    public void setIdGita(String idGita) {
        this.idGita = idGita;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    
    public boolean eliminaStudente(String matricola) {
        if (this.mappaStudenti.containsKey(matricola)) {
            this.mappaStudenti.remove(matricola);
            return true;
        }
        return false;

    }
    
    
}
