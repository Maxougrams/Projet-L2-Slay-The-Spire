package main.Salles;

import java.util.List;

import main.Action;
import main.Heros;
import main.Monstre;
import main.Cartes.Brulure;

public class SalleBoss extends SalleCombat {

    public SalleBoss(Heros heros, List<Monstre> monstres) {
        super(heros, monstres);
    }

    @Override
    protected void attaqueMonstres() {
        monstres.stream().forEach(m -> m.setBlocage(0)); // Enlève le blocage de tout les monstres
        for (Monstre monstre : monstres) {
            // Récupère le prochain mouvement du monstre, ajoute les point de faiblesse,
            // fragilité et les dégats au héros.
            Action action = monstre.getProchain_mouvements();
            heros.ajoutStatutsFaiblesse(action.getFaiblesse());
            heros.ajoutStatutsFragile(action.getFragilite());

            if (action.getNom() == "Divise") {
                for (int index = 0; index < 6; index++) {
                    heros.subirDegats(1 + heros.getPV() / 12);
                }
            }
            heros.subirDegats(monstre.attaquer());
            for (int i = 0; i < action.getBrulure(); i++) { // Ajoute les cartes Brulure si il y en a.
                defausse.add(new Brulure());
            }
            monstre.finDeTour();
        }
    }

}
