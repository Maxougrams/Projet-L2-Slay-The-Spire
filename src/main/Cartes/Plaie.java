package main.Cartes;

import main.Carte;

public class Plaie extends Carte {
    public Plaie() {
        nom = "Plaie";
        description = "Cette carte ne peut pas être joué, c'est son seul effet !";
        coutEnergie = 0;
    }
}
