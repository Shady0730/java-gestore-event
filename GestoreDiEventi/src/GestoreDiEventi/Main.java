package GestoreDiEventi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): ");
            String data = scanner.nextLine();

            System.out.print("Inserisci l'ora dell'evento (HH:mm:ss): ");
            String ora = scanner.nextLine();

            System.out.print("Inserisci il numero totale di posti: ");
            int numeroPostiTotali = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Inserisci il prezzo del biglietto: ");
            double prezzo = scanner.nextDouble();
            scanner.nextLine(); 
            
            //creazione concerto con i dati inseriti dall'utente
            Concerto concerto = new Concerto (titolo, data,numeroPostiTotali, ora , prezzo);
            System.out.println("Concerto creato: " + concerto);

            System.out.print("Quante prenotazioni vuoi fare? ");
            int prenotazioni = scanner.nextInt();
            scanner.nextLine(); 
            

            //stampa prenotazioni con eventuali posti in eccesso 
            System.out.println(concerto.prenota(prenotazioni));

            System.out.println("Posti prenotati: " + concerto.getNumeroPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));

            System.out.print("Quante prenotazioni vuoi disdire? ");
            int disdette = scanner.nextInt();
            scanner.nextLine(); 

            //stampa delle disdette e in caso di numero maggiore stampa errore
            System.out.println(concerto.disdici(disdette)); 
            
            System.out.println("Posti prenotati: " + concerto.getNumeroPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //verifica della correttezza dei dati inseriti dall'utente rispetto a quelli richiesti
        }

        scanner.close();
    }
}

