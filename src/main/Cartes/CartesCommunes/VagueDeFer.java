package main.Cartes.CartesCommunes;

import main.Carte;

public class VagueDeFer extends Carte {
    public VagueDeFer() {
        nom = "Vague de Fer";
        description = "Gagne 5 points de blocage puis inflige 5 dégâts à un ennemi";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setBlocage(5);
        effet.setDegats(5);
    }
}
