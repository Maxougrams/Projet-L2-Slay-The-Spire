package main.Cartes.CartesNonCommunes;

import main.Carte;

public class Desarmement extends Carte {
    public Desarmement() {
        nom = "Desarmement";
        description = "Fait perdre 2 de Force à un ennemi. Cette carte est mise en exil après avoir été jouée.";
        coutEnergie = 1;
        cible = cibleType.monstre;
        effet.setInfligeForce(2);
        effet.setExil(true);
    }
}