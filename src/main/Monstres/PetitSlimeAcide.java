package main.Monstres;

import main.Action;
import main.Monstre;

public class PetitSlimeAcide extends Monstre {

    public PetitSlimeAcide() {
        nom = "Petit slime acide";
        PVmax = 8;
        PV = PVmax;

        // initialise les attaques
        cycle.add(new Action("Charge", 3, 0, 0, 0, 0, 0,0,0));
        cycle.add(new Action("Lécher", 0, 0, 0, 1, 0, 0,0,0));

        // charge le prochain mouvement
        this.changerMouvement();
    }

}
