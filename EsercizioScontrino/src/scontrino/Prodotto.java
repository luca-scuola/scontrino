package scontrino;

public record Prodotto(String nomeProdotto, float prezzo) {

    @Override
    public String toString() {
        return nomeProdotto + ": " + prezzo + "€";
    }
}