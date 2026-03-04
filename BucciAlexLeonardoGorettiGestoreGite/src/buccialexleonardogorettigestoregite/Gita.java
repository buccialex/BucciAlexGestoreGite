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
    private List<Studente> listaStudenti;
    
    public Gita(String luogo, String idGita, int durata){
        this.luogo = luogo;
        this.durata = durata;
        this.idGita = idGita;
        this.listaStudenti = new ArrayList<>();
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

    public List<Studente> getListaStudenti() {
        return listaStudenti;
    }

    public void setListaStudenti(List<Studente> listaStudenti) {
        this.listaStudenti = listaStudenti;
    }
    
    
}
