package main.Cartes.CartesNonCommunes;

import main.Carte;

public class VoirRouge extends Carte {
    public VoirRouge() {
        nom = "Voir rouge";
        description = "Gagne 2 points d’énergie. Cette carte est mise en exil après avoir été jouée";
        coutEnergie = 1;
        effet.setEnergie(2);
        effet.setExil(true);
    }
}