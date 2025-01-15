package main.Cartes.CartesCommunes;

import main.Carte;

public class Defense extends Carte {
    public Defense() {
        nom = "Défense";
        description = "Gagne 5 points de blocage";
        coutEnergie = 1;
        effet.setBlocage(5);
    }

}
