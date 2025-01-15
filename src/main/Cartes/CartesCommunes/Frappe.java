package main.Cartes.CartesCommunes;

import main.Carte;

public class Frappe extends Carte {
    public Frappe() {
        nom = "Frappe";
        description = "Inflige 6 dégats à un ennemi";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setDegats(6);
    }
}
