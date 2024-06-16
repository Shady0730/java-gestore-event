package GestoreDiEventi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Concerto extends Evento{
	private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, String data, int numeroPostiTotali, String ora, double prezzo) {
        super(titolo, data + " " + ora, numeroPostiTotali);
        this.prezzo = prezzo;
    }

    // Getter e setter per ora
    public LocalTime getOra() {
        return ora;
    }

    // Getter e setter per prezzo
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per restituire data e ora formattata
    public String getDataOraFormattata() {
        return super.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Metodo per restituire prezzo formattato
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}