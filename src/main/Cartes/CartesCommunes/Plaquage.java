package main.Cartes.CartesCommunes;

import main.Carte;

public class Plaquage extends Carte {
    public Plaquage() {
        nom = "Plaquage";
        description = "Inflige des dégâts égaux au nombre de points de blocage de l'entité qui utilise la carte.";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setDegats(effet.getBlocage());
    }
}
