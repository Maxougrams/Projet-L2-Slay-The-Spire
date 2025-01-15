package main.Monstres;

import main.Action;
import main.Monstre;

public class SlimePiquant extends Monstre {
    public SlimePiquant() {
        nom = "Slime piquant";
        PVmax = 30;
        PV = PVmax;

        // initialise les attaques
        cycle.add(new Action("Crachat", 8, 0, 0, 0, 0, 0, 0.3,1,0));
        cycle.add(new Action("Lécher", 0, 0, 0, 0, 1, 0, 0.7,0,0));

        // Pour trier les mouvements selon leur pourcentage, qui sera utile dans
        // changerMouvement()
        cycle.sort((a1, a2) -> Double.compare(a1.getPourcentage(), a2.getPourcentage()));

        // charge le prochain mouvement
        this.changerMouvement();
    }

}
