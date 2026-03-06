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
<<<<<<< Updated upstream
 
    /**
     * costruttore della classe Gita
     * @param luogo
     * @param idGita
     * @param durata 
     */
=======
    
>>>>>>> Stashed changes
    public Gita(String luogo, String idGita, int durata){
        if(luogo.isEmpty() || idGita.isEmpty()){
            throw new IllegalArgumentException("Riempi tutte le caselle");
        }
        this.luogo = luogo;
        this.durata = durata;
        this.idGita = idGita;
        this.mappaStudenti = new HashMap<String, Studente>();
    }
<<<<<<< Updated upstream
 
    /**
     * metodo per aggiungere uno studente all' HashMap
     * @param s
     * @return 
     */
=======
    
>>>>>>> Stashed changes
    public boolean aggiungiStudente(Studente s){
        if (this.mappaStudenti.containsKey(s.getMatricola())) {
            return false;
        }
        this.mappaStudenti.put(s.getMatricola(), s);
        return true;
    }

<<<<<<< Updated upstream
  
    /**
     * get di Luogo
     * @return 
     */
=======
    
>>>>>>> Stashed changes
    public String getLuogo() {
        return luogo;
    }

    /**
     * set di Luogo
     * @param luogo 
     */
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    /**
     * get di IdGita
     * @return 
     */
    public String getIdGita() {
        return idGita;
    }

    /**
     * set di IdGita
     * @param idGita 
     */
    public void setIdGita(String idGita) {
        this.idGita = idGita;
    }

    /**
     * get di Durata
     * @return 
     */
    public Integer getDurata() {
        return durata;
    }

    /**
     * set di Durata
     * @param durata 
     */
    public void setDurata(int durata) {
        this.durata = durata;
    }
<<<<<<< Updated upstream
   
    /**
     * elimina uno studente in base alla sua matricola
     * @param matricola
     * @return 
     */
=======
    
>>>>>>> Stashed changes
    public boolean eliminaStudente(String matricola) {
        if (this.mappaStudenti.containsKey(matricola)) {
            this.mappaStudenti.remove(matricola);
            return true;
        }
        return false;

    }
    
    
}
