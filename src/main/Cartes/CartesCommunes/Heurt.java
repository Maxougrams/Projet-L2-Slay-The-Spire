package main.Cartes.CartesCommunes;

import main.Carte;

public class Heurt extends Carte {
    public Heurt() {
        nom = "Heurt";
        description = "Inflige 8 dégâts à un ennemi puis 2 de Vulnérable";
        coutEnergie = 2;
        cible = cibleType.monstre;
        effet.setDegats(8);
        effet.setVulnerabilite(2);
    }
}
