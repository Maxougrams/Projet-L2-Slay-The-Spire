package main.Monstres;

import main.Action;
import main.Monstre;

public class SlimeAcide extends Monstre {
    public SlimeAcide() {
        nom = "Slime acide";
        PVmax = 30;
        PV = PVmax;

        // initialise les attaques
        cycle.add(new Action("Crachat", 7, 0, 0, 0, 0, 0, 0.4,1,0));
        cycle.add(new Action("Lécher", 0, 0, 0, 0, 1, 0, 0.3,0,0));
        cycle.add(new Action("Charge", 10, 0, 0, 0, 0, 0, 0.3,0,0));

        // Pour trier les mouvements selon leur pourcentage, qui sera utile dans
        // changerMouvement()
        cycle.sort((a1, a2) -> Double.compare(a1.getPourcentage(), a2.getPourcentage()));

        // charge le prochain mouvement
        this.changerMouvement();
    }

}
