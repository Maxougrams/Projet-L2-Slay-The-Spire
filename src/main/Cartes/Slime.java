package main.Cartes;

import main.Carte;

public class Slime extends Carte {
    public Slime() {
        nom = "Slime";
        description = "Son seul effet est d'être exilée après avoir été joué";
        coutEnergie = 1;
        effet.setExil(true);
    }

}
