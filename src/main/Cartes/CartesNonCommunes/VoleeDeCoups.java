package main.Cartes.CartesNonCommunes;

import main.Carte;

public class VoleeDeCoups extends Carte {
    public VoleeDeCoups() {
        nom = "Volee de coups";
        description = "Inflige 2 dégâts 4 fois à un ennemi. Cette carte est mise en exil après avoir été jouée.";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setDegats(2);
        effet.setNbApplication(4);
        effet.setExil(true);
    }
}