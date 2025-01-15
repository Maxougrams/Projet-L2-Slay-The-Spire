package main.Cartes.CartesCommunes;

import main.Carte;

public class EpeeBoomerang extends Carte {
    public EpeeBoomerang() {
        nom = "Epee Boomerang";
        description = "Inflige 3 dégâts à un ennemi au hasard, 3 fois de suite";
        coutEnergie = 1;
        cible = cibleType.monstreHasard;
        effet.setDegats(3);
        effet.setNbApplication(3);
    }
}
