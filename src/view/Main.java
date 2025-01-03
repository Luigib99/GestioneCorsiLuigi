package view;

import model.*;
import service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice1;
        int choice2;

        do {
            //MENU INIZIALE

            System.out.println("Scegli se visualizzare il menu:");
            System.out.println("1. DISCENTE");
            System.out.println("2. DOCENTE");
            System.out.println("3. CORSO");
            System.out.println("4. CHIUDI PROGRAMMA");
            choice1 = scanner.nextInt();

            //DISCENTE

            if (choice1 ==1) {
                do
                {
                    System.out.println("Classe discente");
                    System.out.println("***Menu***");
                    System.out.println("1. Crea un nuovo discente");
                    System.out.println("2. Aggiorna un discente");
                    System.out.println("3. Visualizza la lista di discenti");
                    System.out.println("4. Elimina un discente");
                    System.out.println("8. Torna alla scelta");
                    System.out.println("9. Exit");
                    System.out.print("inserisci la tua scelta: ");

                    choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            createDiscente();
                            break;
                        case 2:
                            updateDiscente();
                            break;
                        case 3:
                            readDiscente();
                            break;
                        case 4:
                            deleteDiscente();
                            break;
                        case 8:
                            System.out.println("INDIETRO");
                            break;
                        case 9:
                            System.out.println("exiting");
                            choice1=3;
                            break;
                        default:
                            System.out.println("scelta errata. scegliere un numero da 1 a 9");
                    }
                }
                while (choice2 != 9 && choice2 != 8);
            }

            //DOCENTE

            else if (choice1 ==2)
            {
                do
                {
                    System.out.println("Classe docente");
                    System.out.println("***Menu***");
                    System.out.println("1. Crea un nuovo docente");
                    System.out.println("2. Aggiorna un docente");
                    System.out.println("3. Visualizza la lista di docenti");
                    System.out.println("4. Elimina un docente");
                    System.out.println("8. Torna alla scelta");
                    System.out.println("9. Exit");
                    System.out.print("inserisci la tua scelta: ");


                    choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            createDocente();
                            break;
                        case 2:
                            updateDocente();
                            break;
                        case 3:
                            readDocente();
                            break;
                        case 4:
                            deleteDocente();
                            break;
                        case 8:
                            System.out.println("INDIETRO");
                            break;
                        case 9:
                            System.out.println("exiting");
                            choice1=3;
                            break;
                        default:
                            System.out.println("scelta errata. scegliere un numero da 1 a 8");
                    }
                }
                while (choice2 != 8 && choice2!=9);
            }

            //CORSO

            else if (choice1 == 3)
            {
                do
                {
                    System.out.println("Classe corso");
                    System.out.println("***Menu***");
                    System.out.println("1. Crea un nuovo corso");
                    System.out.println("2. Aggiorna un corso");
                    System.out.println("3. Guarda i corsi");
                    System.out.println("4. Elimina corso");
                    System.out.println("8. Torna alla scelta");
                    System.out.println("9. Exit");
                    System.out.print("inserisci la tua scelta: ");

                    choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1:
                            createCorso();
                            break;
                        case 2:
                            updateCorso();
                            break;
                        case 3:
                            readCorso();
                            break;
                        case 4:
                            deleteCorso();
                            break;
                        case 8:
                            System.out.println("INDIETRO");
                            break;
                        case 9:
                            System.out.println("exiting");
                            choice1=4;
                            break;
                        default:
                            System.out.println("scelta errata. scegliere un numero da 1 a 8");
                    }
                }
                while (choice2 != 8 && choice2!=9);
            }

            //NUMERO SBAGLIATO

            else
            {
                System.out.println("scelta errata. scegliere un numero da 1 a 3");
            }
        }
        while (choice1 != 4);
        scanner.close();
    }

    //CORSO

    private static void createCorso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci il nome del corso");
        String nomeCorso = scanner.nextLine();
        System.out.println("inserisci la data di inizio del corso");
        String dataInizio = scanner.nextLine();
        System.out.println("inserisci la durata del corso");
        String durataCorso = scanner.nextLine();
        System.out.println("Scegli il docente inserendo il nome del suo id");
        readDocente();
        scanner.nextLine();
        int idDocente = scanner.nextInt();
        DocenteService DocenteService = new DocenteService();
        List<Docente> listaDocenti= DocenteService.readDocente();
        for (int i = 0; i < listaDocenti.size(); i++)
        {
            if (listaDocenti.get(i).getid() == idDocente)
            {
                Docente docente = listaDocenti.get(i);
                CorsoService corsoService = new CorsoService();
                corsoService.createCorso(nomeCorso, dataInizio, durataCorso, idDocente, docente);
            }
        }
        }

        private static void readCorso ()
        {
            System.out.println("ecco la lista dei corsi: ");
            CorsoService corsoService = new CorsoService();
            List<Corso> listaCorsi = corsoService.readCorso();
            int i = 0;
            while (i < listaCorsi.size()) {
                System.out.println(listaCorsi.get(i).getIdCorso() + " " +
                        listaCorsi.get(i).getNomeCorso() + " " +
                        listaCorsi.get(i).getDataInizio() + " " +
                        listaCorsi.get(i).getDurataCorso() + " " +
                        listaCorsi.get(i).getDocente());
                i++;
            }
        }

        private static void deleteCorso ()
        {
            System.out.println("Elimina il corso con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            CorsoService corsoService = new CorsoService();
            corsoService.deleteCorso(id);
        }

    private static void updateCorso () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del corso da modificare:");
        readCorso();
        int idCorso = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci il nuovo nome del corso:");
        String nomeCorso = scanner.nextLine();
        System.out.println("inserisci la nuova data di inizio del corso:");
        String dataInizio = scanner.nextLine();
        System.out.println("inserisci la nuova durata del corso:");
        String durataCorso = scanner.nextLine();
        System.out.println("inserisci il nuovo docente dalla lista:");
        readDocente();
        scanner.nextLine();
        int idDocente = scanner.nextInt();
        DocenteService DocenteService = new DocenteService();
        List<Docente> listaDocenti= DocenteService.readDocente();
        for (int i = 0; i < listaDocenti.size(); i++)
        {
            if (listaDocenti.get(i).getid() == idDocente)
            {
                Docente docente = listaDocenti.get(i);
                CorsoService corsoService = new CorsoService();
                corsoService.updateCorso(idCorso, nomeCorso, dataInizio, durataCorso, idDocente);
            }
        }
    }






        //DISCENTE

        private static void readDiscente ()
        {
            System.out.println("ecco la lista dei discenti: ");
            DiscenteService discenteService = new DiscenteService();
            List<Discente> listaDiscenti = discenteService.readDiscente();
            int i = 0;
            while (i < listaDiscenti.size()) {
                System.out.println(listaDiscenti.get(i).getid() + " " +
                        listaDiscenti.get(i).getCognome() + " " +
                        listaDiscenti.get(i).getNome() + " " +
                        listaDiscenti.get(i).getMatricola() + " " +
                        listaDiscenti.get(i).getDataNascita());
                i++;
            }

        }


        private static void createDiscente () {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            System.out.println("inserisci matricola: ");
            String matricola = scanner.next();
            System.out.println("inserisci la data di nascita: ");
            String dataNascita = scanner.next();
            DiscenteService discenteService = new DiscenteService();
            discenteService.create(nome, cognome, matricola, dataNascita);
        }

        private static void deleteDiscente () {
            System.out.println("Elimina il discente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DiscenteService discenteService = new DiscenteService();
            discenteService.delete(id);

        }

        private static void updateDiscente () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del discente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            System.out.println("inserisci la nuova matricola:");
            String matricola = scanner.next();
            System.out.println("inserisci la nuova data di nascita:");
            String dataNascita = scanner.next();
            DiscenteService discenteService = new DiscenteService();
            discenteService.update(id, nome, cognome, matricola, dataNascita);
        }

        //DOCENTE

        private static void readDocente () {
            System.out.println("ecco la lista dei docenti: ");
            DocenteService oDocenteService = new DocenteService();
            List<Docente> listaDocenti = oDocenteService.readDocente();
            int i = 0;
            while (i < listaDocenti.size()) {
                System.out.println(listaDocenti.get(i).getid() + " " + listaDocenti.get(i).getCognome() + " " + listaDocenti.get(i).getNome());
                i++;
            }

        }


        private static void createDocente () {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.create(nome, cognome);

        }

        private static void deleteDocente () {
            System.out.println("Elimina il docente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.delete(id);

        }

        private static void updateDocente () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del docente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.update(id, nome, cognome);

        }


}
