package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Tenacite extends Carte {
    public Tenacite() {
        nom = "Tenacite";
        description = "Ajoute 2 cartes Plaie à la main, gagne 15 points de blocage.";
        coutEnergie = 1;
        effet.setCartesPlaie(2);
        effet.setBlocage(15);
    }
}