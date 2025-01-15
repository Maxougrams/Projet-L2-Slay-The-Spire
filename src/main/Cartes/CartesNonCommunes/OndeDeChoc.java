package main.Cartes.CartesNonCommunes;

import main.Carte;

public class OndeDeChoc extends Carte {
    public OndeDeChoc() {
        nom = "OndeDeChoc";
        description = "Inflige 3 points de Faiblesse et de Vulnérables à tous les ennemis. Cette carte est mise en exil après avoir été jouée";
        coutEnergie = 2;
        cible = cibleType.tousLesMonstres;
        effet.setFaiblesse(3);
        effet.setVulnerabilite(3);
        effet.setExil(true);
    }
}