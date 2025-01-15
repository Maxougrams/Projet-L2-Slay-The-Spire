package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Enflammer extends Carte {
    public Enflammer() {
        nom = "Enflammer";
        description = "Gagne 2 de Force. Cette carte est mise en exil après avoir été joué.";
        coutEnergie = 1;
        effet.setGainForce(2);
        effet.setExil(true);
    }
}