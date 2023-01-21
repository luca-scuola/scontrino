package scontrino;

public class ScontrinoElemento {
    Prodotto prodotto;
    int quantita;

    public ScontrinoElemento(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return prodotto.nomeProdotto() + " - " + prodotto.prezzo() + "€ --> quantita: " + quantita;
    }

}