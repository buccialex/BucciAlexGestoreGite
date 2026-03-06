package buccialexleonardogorettigestoregite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestioneFile {

    /*
     * Struttura di ogni record GITA (totale: 84 byte):
     *   - idGita  : 20 char * 2 byte = 40 byte
     *   - luogo   : 20 char * 2 byte = 40 byte
     *   - durata  : 1 int            =  4 byte
     *
     * Struttura di ogni record STUDENTE (totale: 160 byte):
     *   - matricola : 20 char * 2 byte = 40 byte
     *   - nome      : 20 char * 2 byte = 40 byte
     *   - cognome   : 20 char * 2 byte = 40 byte
     *   - idGita    : 20 char * 2 byte = 40 byte
     */

    private static final int DIM_RECORD_GITA     = 84;   // 40 + 40 + 4
    private static final int DIM_RECORD_STUDENTE = 160;  // 40 * 4
    private static final int LEN_STRINGA         = 20;

    private static final String FILE_GITE     = "gite.dat";
    private static final String FILE_STUDENTI = "studenti.dat";

    // ─────────────────────────────────────────────────────────────
    // UTILITÀ
    // ─────────────────────────────────────────────────────────────

    /** Porta la stringa esattamente a LEN_STRINGA caratteri (taglia o riempie con '*') */
    public String aggiustaLunghezzaStringa(String s) {
        if (s.length() > LEN_STRINGA) {
            return s.substring(0, LEN_STRINGA);
        }
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < LEN_STRINGA) {
            sb.append('*');
        }
        return sb.toString();
    }

    /** Legge una stringa di LEN_STRINGA char e rimuove i '*' di riempimento */
    private String leggiStringa(RandomAccessFile file) throws IOException {
        char[] chars = new char[LEN_STRINGA];
        for (int i = 0; i < LEN_STRINGA; i++) {
            chars[i] = file.readChar(); // readChar legge 2 byte (Unicode)
        }
        return new String(chars).replace("*", "").trim();
    }

    /** Scrive una stringa di esattamente LEN_STRINGA char (2 byte ognuno) */
    private void scriviStringa(RandomAccessFile file, String s) throws IOException {
        String aggiustata = aggiustaLunghezzaStringa(s);
        for (int i = 0; i < LEN_STRINGA; i++) {
            file.writeChar(aggiustata.charAt(i)); // writeChar scrive 2 byte
        }
    }

    // ─────────────────────────────────────────────────────────────
    // GITE
    // ─────────────────────────────────────────────────────────────

    /** Aggiunge una gita in fondo al file (accesso diretto: seek alla fine) */
    public void scriviGita(Gita g) {
        try (RandomAccessFile file = new RandomAccessFile(FILE_GITE, "rw")) {

            int nRecord = (int) (file.length() / DIM_RECORD_GITA);
            file.seek((long) nRecord * DIM_RECORD_GITA); // salta all'ultimo record

            scriviStringa(file, g.getIdGita());  // 40 byte
            scriviStringa(file, g.getLuogo());   // 40 byte
            file.writeInt(g.getDurata());        //  4 byte

        } catch (FileNotFoundException ex) {
            System.out.println("File gite non trovato");
        } catch (IOException e) {
            System.out.println("Errore scrittura gita: " + e.getMessage());
        }
    }

    /**
     * Legge tutte le gite usando l'accesso diretto:
     * calcola la posizione di ogni record con seek(i * DIM_RECORD)
     */
    public Gita[] leggiTutteLeGite() {
        try (RandomAccessFile file = new RandomAccessFile(FILE_GITE, "r")) {

            int nRecord = (int) (file.length() / DIM_RECORD_GITA);
            Gita[] gite = new Gita[nRecord];

            for (int i = 0; i < nRecord; i++) {
                file.seek((long) i * DIM_RECORD_GITA); // accesso diretto all'i-esimo record

                String id     = leggiStringa(file);
                String luogo  = leggiStringa(file);
                int    durata = file.readInt();

                gite[i] = new Gita(luogo, id, durata);
            }
            return gite;

        } catch (FileNotFoundException ex) {
            System.out.println("File gite non trovato");
            return new Gita[0];
        } catch (IOException e) {
            System.out.println("Errore lettura gite: " + e.getMessage());
            return new Gita[0];
        }
    }

    /**
     * Elimina una gita per ID.
     * Strategia: riscrive il file saltando il record da eliminare.
     */
    public boolean eliminaGita(String idGita) {
        Gita[] gite = leggiTutteLeGite();
        boolean trovata = false;

        try (RandomAccessFile file = new RandomAccessFile(FILE_GITE, "rw")) {
            file.setLength(0); // svuota il file prima di riscriverlo
            for (Gita g : gite) {
                if (g.getIdGita().equals(idGita)) {
                    trovata = true;
                    continue; // non riscrivere questo record → eliminato
                }
                scriviStringa(file, g.getIdGita());
                scriviStringa(file, g.getLuogo());
                file.writeInt(g.getDurata());
            }
        } catch (IOException e) {
            System.out.println("Errore eliminazione gita: " + e.getMessage());
        }
        return trovata;
    }

    // ─────────────────────────────────────────────────────────────
    // STUDENTI
    // ─────────────────────────────────────────────────────────────

    /** Aggiunge uno studente con la gita associata */
    public void scriviStudente(Studente s, String idGita) {
        try (RandomAccessFile file = new RandomAccessFile(FILE_STUDENTI, "rw")) {

            int nRecord = (int) (file.length() / DIM_RECORD_STUDENTE);
            file.seek((long) nRecord * DIM_RECORD_STUDENTE);

            scriviStringa(file, s.getMatricola()); // 40 byte
            scriviStringa(file, s.getNome());       // 40 byte
            scriviStringa(file, s.getCognome());    // 40 byte
            scriviStringa(file, idGita);            // 40 byte

        } catch (FileNotFoundException ex) {
            System.out.println("File studenti non trovato");
        } catch (IOException e) {
            System.out.println("Errore scrittura studente: " + e.getMessage());
        }
    }

    /**
     * Legge tutti gli studenti con accesso diretto.
     * Ritorna una matrice: ogni riga è [matricola, nome, cognome, idGita]
     */
    public String[][] leggiTuttiGliStudenti() {
        try (RandomAccessFile file = new RandomAccessFile(FILE_STUDENTI, "r")) {

            int nRecord = (int) (file.length() / DIM_RECORD_STUDENTE);
            String[][] studenti = new String[nRecord][4];

            for (int i = 0; i < nRecord; i++) {
                file.seek((long) i * DIM_RECORD_STUDENTE); // accesso diretto

                studenti[i][0] = leggiStringa(file); // matricola
                studenti[i][1] = leggiStringa(file); // nome
                studenti[i][2] = leggiStringa(file); // cognome
                studenti[i][3] = leggiStringa(file); // idGita
            }
            return studenti;

        } catch (FileNotFoundException ex) {
            System.out.println("File studenti non trovato");
            return new String[0][0];
        } catch (IOException e) {
            System.out.println("Errore lettura studenti: " + e.getMessage());
            return new String[0][0];
        }
    }

    /** Elimina uno studente per matricola */
    public boolean eliminaStudente(String matricola) {
        String[][] studenti = leggiTuttiGliStudenti();
        boolean trovato = false;

        try (RandomAccessFile file = new RandomAccessFile(FILE_STUDENTI, "rw")) {
            file.setLength(0);
            for (String[] row : studenti) {
                if (row[0].equals(matricola)) {
                    trovato = true;
                    continue;
                }
                scriviStringa(file, row[0]);
                scriviStringa(file, row[1]);
                scriviStringa(file, row[2]);
                scriviStringa(file, row[3]);
            }
        } catch (IOException e) {
            System.out.println("Errore eliminazione studente: " + e.getMessage());
        }
        return trovato;
    }
}
