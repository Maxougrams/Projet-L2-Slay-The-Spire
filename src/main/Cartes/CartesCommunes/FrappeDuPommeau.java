package main.Cartes.CartesCommunes;

import main.Carte;

public class FrappeDuPommeau extends Carte {
    public FrappeDuPommeau() {
        nom = "Frappe du Pommeau";
        description = "Inflige 9 dégâts à un ennemi et pioche une carte";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setDegats(9);
        effet.setPioche(1);
    }
}
