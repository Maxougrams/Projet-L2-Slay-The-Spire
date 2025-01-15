package main.Monstres;

import main.Action;
import main.Monstre;

public class Hexaghost extends Monstre {
    public Hexaghost() {
        nom = "Hexaghost";
        PVmax = 250;
        PV = PVmax;

        // initialise les attaques
        preparation.add(new Action("Chargement", 0, 0, 0, 0, 0, 0, 0, 0));
        preparation.add(new Action("Divise", 0, 0, 0, 0, 0, 0, 0, 0));

        cycle.add(new Action("Brûle", 6, 0, 0, 0, 0, 0, 0, 1));
        cycle.add(new Action("Charge", 10, 0, 0, 0, 0, 0, 0, 0));
        cycle.add(new Action("Brûle", 6, 0, 0, 0, 0, 0, 0, 1));
        cycle.add(new Action("Enflamme", 0, 12, 2, 0, 0, 0, 0, 0));
        cycle.add(new Action("Charge", 10, 0, 0, 0, 0, 0, 0, 0));
        cycle.add(new Action("Brûle", 6, 0, 0, 0, 0, 0, 0, 1));
        cycle.add(new Action("Enfer", 12, 0, 0, 0, 0, 0, 0, 3));

        // Pour trier les mouvements selon leur pourcentage, qui sera utile dans
        // changerMouvement()
        cycle.sort((a1, a2) -> Double.compare(a1.getPourcentage(), a2.getPourcentage()));

        // charge le prochain mouvement
        this.changerMouvement();

    }

}