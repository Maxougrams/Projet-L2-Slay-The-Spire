package main.Monstres;

import main.Action;
import main.Monstre;

public class Machouilleur extends Monstre {
    public Machouilleur() {
        nom = "Machouilleur";
        PVmax = 40;
        PV = PVmax;

        // initialise les attaques
        preparation.add(new Action("Charge", 7, 5, 0, 0, 0, 0,0,0));
        cycle.add(new Action("Morsure", 11, 0, 0, 0, 0, 0, 0.25,0,0));
        cycle.add(new Action("Charge", 7, 5, 0, 0, 0, 0, 0.3,0,0));
        cycle.add(new Action("Gronder", 0, 6, 3, 0, 0, 0, 0.45,0,0));

        // Pour trier les mouvements selon leur pourcentage, qui sera utile dans
        // changerMouvement()
        cycle.sort((a1, a2) -> Double.compare(a1.getPourcentage(), a2.getPourcentage()));

        // charge le prochain mouvement
        this.changerMouvement();
    }

}
