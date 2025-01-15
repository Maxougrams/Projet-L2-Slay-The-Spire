package main.Cartes.CartesCommunes;

import main.Carte;

public class FrappeDouble extends Carte {
    public FrappeDouble() {
        nom = "Frappe Double";
        description = "Inflige 5 dégâts deux fois à un ennemi";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setDegats(5);
        effet.setNbApplication(2);
    }
}
