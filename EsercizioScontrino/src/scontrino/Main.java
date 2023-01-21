package scontrino;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static Scontrino scontrino = new Scontrino();
    private final static Catalogo catalogo = Catalogo.getInstance("listaProdotti");

    public static void main(String[] args) {
        int scelta;

        do {
            System.out.println();
            System.out.println("Cosa vuoi fare?");
            System.out.println("1- Aggiungere un nuovo elemento");
            System.out.println("2- Rimuovere un nuovo elemento");
            System.out.println("3- Prezzo totale");
            System.out.println("4- Stampare Scontrino");
            System.out.println("5- Stampare Catalogo");
            System.out.println("0- per uscire");

            scelta = Integer.parseInt(sc.nextLine());

            switch (scelta) {
                case 1 -> {
                    System.out.println("Scegli il prodotto dal catalogo: ");
                    catalogo.printAll();
                    int idx;
                    do {
                        idx = Integer.parseInt(sc.nextLine());
                    } while (idx<0 || idx >= catalogo.getProdotti().size());

                    System.out.println();
                    int quantita;
                    do {
                        System.out.println("in che quantità? ");
                        quantita = Integer.parseInt(sc.nextLine());
                    } while (quantita<=0);

                    scontrino.add(new ScontrinoElemento(catalogo.getProdotti().get(idx), quantita));
                }
                case 2 -> {
                    scontrino.printAll();
                    System.out.println("Indice del prodotto da cancellare: ");
                    int idx = Integer.parseInt(sc.nextLine());

                    System.out.println();
                    int quantita;
                    do {
                        System.out.println("in che quantità? ");
                        quantita = Integer.parseInt(sc.nextLine());
                    } while (quantita<=0);

                    scontrino.remove(idx, quantita);
                }
                case 3 -> System.out.println("Il prezzo totale è " + scontrino.totaleScontrino() + "€");
                case 4 -> scontrino.printAll();
                case 5 -> catalogo.printAll();
            }
        }while (scelta != 0) ;

        scontrino.printAll();
        System.out.println();
        System.out.println("Grazie della spesa :)");
    }
}