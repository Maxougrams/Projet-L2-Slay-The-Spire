package main.Cartes.CartesRares;

import main.Carte;

public class Invincible extends Carte {
    public Invincible() {
        nom = "Invincible";
        description = "Gagne 30 points de blocage. Cette carte est mise en exil après avoir été jouée.";
        coutEnergie = 2;
        effet.setBlocage(30);
    }
}