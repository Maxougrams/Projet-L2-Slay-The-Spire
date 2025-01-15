package main.Cartes;

import main.Carte;

public class Brulure extends Carte {
    public Brulure() {
        nom = "Brûlure";
        description = "Cette carte ne peut pas être jouée, comme vous l'avez en main elle vous enlève 2 points de vie à la fin de votre tour.";
        coutEnergie = 0;
    }

}
