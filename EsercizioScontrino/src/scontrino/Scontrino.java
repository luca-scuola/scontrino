package scontrino;

import java.util.ArrayList;
import java.util.List;

public class Scontrino {
    private final List<ScontrinoElemento> elementi;

    public Scontrino() {
        elementi = new ArrayList<>();
    }

    public List<ScontrinoElemento> getProdotti() {
        return elementi;
    }

    public void add(ScontrinoElemento e) {
        elementi.add(e);
    }

    public boolean remove(int index, int q) {
        if(elementi.get(index)!=null) {
            if(elementi.get(index).getQuantita()<=q) {
                elementi.remove(index);
            }
            else {
                elementi.get(index).setQuantita(elementi.get(index).getQuantita()-q);
            }
            return true;
        }
        return false;
    }

    public float totaleScontrino() {
        float pTotale=0;

        for (ScontrinoElemento e: elementi) {
            pTotale += e.getProdotto().prezzo() * e.getQuantita();
        }
        return pTotale;
    }

    public void printAll() {
        for (int i = 0; i < elementi.size(); i++) {
            System.out.println(i + "; " + elementi.get(i));
        }
    }

}