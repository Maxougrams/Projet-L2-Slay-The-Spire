package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Uppercut extends Carte {
    public Uppercut() {
        nom = "Uppercut";
        description = "Inflige 13 points de dégâts à un ennemi, puis inflige 1 point de Faiblesse et Vulnérable.";
        coutEnergie = 2;
        cible = cibleType.monstre;
        effet.setDegats(13);
        effet.setFaiblesse(1);
        effet.setVulnerabilite(1);
    }
}