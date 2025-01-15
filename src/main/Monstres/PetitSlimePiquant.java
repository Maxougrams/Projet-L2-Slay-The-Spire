package main.Monstres;

import main.Action;
import main.Monstre;

public class PetitSlimePiquant extends Monstre {

    public PetitSlimePiquant() {
        nom = "Petit slime piquant";
        PVmax = 12;
        PV = PVmax;
        blocage = 0;

        // initialise les attaques
        cycle.add(new Action("Charge", 5, 0, 0, 0, 0, 0,0,0));

        // charge le prochain mouvement
        this.changerMouvement();

    }

}
