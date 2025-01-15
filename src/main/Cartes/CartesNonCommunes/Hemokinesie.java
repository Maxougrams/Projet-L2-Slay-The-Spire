package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Hemokinesie extends Carte {
    public Hemokinesie() {
        nom = "Hemokinesie";
        description = "Perdez 2 points de vie, inflige15 points de dégâts à un ennemi.";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setPerdVie(2);
        effet.setDegats(15);
    }
}