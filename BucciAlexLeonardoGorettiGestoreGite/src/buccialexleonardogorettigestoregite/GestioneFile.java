/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexleonardogorettigestoregite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * classe addebitata alla gestione del file come la lunghezza
 * @author bucci.alex
 */
public class GestioneFile {
    private static int dimensioneRecord;
     
    public GestioneFile(){
        this.dimensioneRecord = 84;
    }
    
    public String aggiustaLunghezzaStringa(String s) {
        String aggiustata=s;
        if (s.length() < 20) {
            for (int i = 0; i < (20 - s.length()); i++) {
                aggiustata += "*";
            }
            return aggiustata;
        } else if (s.length() > 20) {
            aggiustata = s.substring(0, 19);
            return aggiustata;
        }
        return s;
    }
    
    /**
     * classe addebitata alla creazione del file di testo
     */
    public void generaFile(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco.dat", "rw");
            //calcolo la dimensione del file per capire quanti record ci sono. 
            //Questo serve perché ogni nuovo record vine aggiunto in fondo
            int nRecord = (int) (file.length() / dimensioneRecord);
            //con il metodo seek ci si sposta all'interno del file alla posizione desiderata
            file.seek(nRecord * dimensioneRecord);
            

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    
    }

}
