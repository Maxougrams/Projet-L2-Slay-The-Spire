package main.Cartes.CartesRares;

import main.Carte;

public class FormeDemoniaque extends Carte {
    public FormeDemoniaque() {
        nom = "Forme démoniaque";
        description = "Donne au joueur 2 points d'un statut spécial Forme démoniaque. Cette carte est mise en exil après avoir été jouée.";
        coutEnergie = 3;
        effet.setFormeDemoniaque(2);
        effet.setExil(true);
    }
}