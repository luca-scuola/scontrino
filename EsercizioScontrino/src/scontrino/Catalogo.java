package scontrino;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private final List<Prodotto> prodotti = new ArrayList<>();
    private static Catalogo instance = null;

    public static Catalogo getInstance(String fileName) {
        if(instance == null) {
            instance = new Catalogo();

            try {
                BufferedReader fileReader = Files.newBufferedReader(Path.of(fileName));

                String line = fileReader.readLine();
                while (line!=null) {
                    instance.prodotti.add(new Prodotto( line.split(";")[0], Float.parseFloat(line.split(";")[1]) ));
                    line = fileReader.readLine();
                }
                fileReader.close();

            } catch (IOException e) {
                System.out.println("File non trovato");
            }
        }
        return instance;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void printAll() {
        for (int i = 0; i < prodotti.size(); i++) {
            System.out.println(i + " - " + prodotti.get(i));
        }
    }

}