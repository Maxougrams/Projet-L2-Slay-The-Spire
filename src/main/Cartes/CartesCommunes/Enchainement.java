package main.Cartes.CartesCommunes;

import main.Carte;

public class Enchainement extends Carte {
    public Enchainement() {
        nom = "Enchainement";
        description = "Inflige 8 dégâts à tous les ennemis";
        coutEnergie = 1;
        cible = cibleType.tousLesMonstres;
        effet.setDegats(8);
    }
}
