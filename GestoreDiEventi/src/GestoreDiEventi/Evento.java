package GestoreDiEventi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento {
	 
	private String titolo;
    private LocalDateTime data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;
    
    

    public Evento(String titolo, String data, int numeroPostiTotali) throws IllegalArgumentException {
        this.titolo = titolo;
        try {
            this.data = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Utilizzare 'dd/MM/yyyy HH:mm:ss'.");
        }

        if (this.data.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    // Getter e setter per titolo
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Getter e setter per data
    public LocalDateTime getData() {
        return data;
    }

   

    // Getter per numeroPostiTotali
    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    // Getter per numeroPostiPrenotati
    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // Metodo per prenotare
    public String prenota(int nPrenotazioni) {
        if (nPrenotazioni <= 0) {
            return "Devi inserire un numero maggiore di 0";
        } else if(nPrenotazioni > numeroPostiTotali) {
        	int nPostiDifferenza = nPrenotazioni - numeroPostiTotali;
        	nPrenotazioni = nPrenotazioni - nPostiDifferenza;
        	numeroPostiPrenotati = numeroPostiPrenotati + nPrenotazioni;
        	return nPrenotazioni + " posti prenotati con successo. Inoltre non possono essere effettuate " + nPostiDifferenza + " prenotazioni perchè superano il limite massimo.";
        	
        }
        
        else {
        numeroPostiPrenotati = numeroPostiPrenotati + nPrenotazioni;
        return nPrenotazioni + " posti prenotati con successo.";
        }
        
        
    }

    // Metodo per disdire
    public String disdici(int nDisdette) {
        if (numeroPostiPrenotati == 0) {
            return "Non ci sono prenotazioni da disdire.";
        } else if(numeroPostiPrenotati < nDisdette) {
        	return "Il numero delle disdette non può essere maggiore dei posti prenotati";
        } 
        else {
        numeroPostiPrenotati = numeroPostiPrenotati - nDisdette; 
        return nDisdette + " prenotazioni disdette con successo.";
        }
    }

    @Override
    public String toString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " - " + titolo;
    }
	
	}
	
