package main.Cartes.CartesCommunes;

import main.Carte;

public class Manchette extends Carte {
    public Manchette() {
        nom = "Manchette";
        description = "Inflige 12 dégâts à un ennemi et lui applique 2 de faiblesse";
        coutEnergie = 2;
        cible = cibleType.monstre;
        effet.setDegats(12);
        effet.setFaiblesse(2);
    }
}
