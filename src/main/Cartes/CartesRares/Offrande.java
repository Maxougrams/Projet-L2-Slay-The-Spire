package main.Cartes.CartesRares;

import main.Carte;

public class Offrande extends Carte {
    public Offrande() {
        nom = "Offrande";
        description = "Perds 6 points de vie, gagne 2 points d’énergie, puis pioche 3 cartes. Cette carte est mise en exil après avoir été jouée.";
        coutEnergie = 0;
        effet.setPerdVie(6);
        effet.setEnergie(2);
        effet.setPioche(3);
        effet.setExil(true);
    }
}