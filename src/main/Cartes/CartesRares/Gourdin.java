package main.Cartes.CartesRares;

import main.Carte;

public class Gourdin extends Carte {
    public Gourdin() {
        nom = "Gourdin";
        description = "Inflige 32 points de dégâts à un ennemi";
        coutEnergie = 3;
        cible = cibleType.monstre;
        effet.setDegats(32);
    }
}