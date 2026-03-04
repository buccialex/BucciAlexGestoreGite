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
public class Studente {
    /**
     * attributi
     */
    private String nome;
    private String cognome;
    private String matricola;
    private List<Gita> listaGite;
    
    public Studente(String nome, String cognome, String matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.listaGite = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public List<Gita> getListaGite() {
        return listaGite;
    }

    public void setListaGite(List<Gita> listaGite) {
        this.listaGite = listaGite;
    }
    
    
}
