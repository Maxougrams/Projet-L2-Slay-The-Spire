package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Saignee extends Carte {
    public Saignee() {
        nom = "Saignee";
        description = "Perdez 3 points de vie puis gagnez 2 points d’énergie";
        coutEnergie = 0;
        effet.setPerdVie(3);
        effet.setEnergie(2);
    }
}
