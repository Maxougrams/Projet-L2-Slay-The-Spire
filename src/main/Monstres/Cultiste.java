package main.Monstres;

import main.Action;
import main.Monstre;

public class Cultiste extends Monstre {
    public Cultiste() {
        nom = "Cultiste";
        PVmax = 50;
        PV = PVmax;

        // initialise les attaques
        preparation.add(new Action("Rituel", 0, 0, 0, 0, 0, 3, 0, 0));
        cycle.add(new Action("Attaque", 6, 0, 0, 0, 0, 0, 0, 0));

        // Pour trier les mouvements selon leur pourcentage, qui sera utile dans
        // changerMouvement()
        cycle.sort((a1, a2) -> Double.compare(a1.getPourcentage(), a2.getPourcentage()));

        // charge le prochain mouvement
        this.changerMouvement();
    }

}
