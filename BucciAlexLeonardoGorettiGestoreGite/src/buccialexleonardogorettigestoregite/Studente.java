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
    private HashMap<String, Gita> mappaGite;
    
    /**
     * costruttore della classe Studente
     * @param nome
     * @param cognome
     * @param matricola 
     */
    public Studente(String nome, String cognome, String matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.mappaGite = new HashMap<String, Gita>();
    }

    /**
     * get di Nome
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * set di Nome
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * get di Cognome
     * @return 
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * set di Cognome
     * @param cognome 
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * get di Matricola
     * @return 
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * set di Matricola 
     * @param matricola 
     */
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    

    
    
    
}
