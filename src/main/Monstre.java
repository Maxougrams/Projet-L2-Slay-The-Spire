package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
* Classe Monstre : Classe qui va representer les monstres du jeu
*/
public abstract class Monstre extends Entite {
    protected String nom;
    protected List<Action> preparation;
    protected List<Action> cycle;
    protected int cycle_index = 0;
    protected Action prochain_mouvements;
    protected int rituel;

    // Bloc d'initialisation
    {
        preparation = new LinkedList<>();
        cycle = new ArrayList<>();
    }

    /**
     * Cette méthode permet au monstre d'attaquer.
     * Elle change aussi le prochain mouvement effectué par le monstre.
     * Elle ajoute les points de force du statut rituel (si il existe).
     * 
     * @return le nombre de dégats de l'attaque du monstre (avec les effets de
     *         statuts)
     */
    public int attaquer() {
        int degats = prochain_mouvements.getDegats();

        // Appliquer les effets des statuts sur les degats
        degats = attaquerEffetsStatuts(degats);

        // Applique le mouvment du monstre
        this.gagnerBlocage(prochain_mouvements.getBlocage());
        this.ajoutStatutsForce(prochain_mouvements.getForce());
        this.rituel += prochain_mouvements.getRituel();

        this.changerMouvement();
        this.ajoutStatutsForce(rituel);

        return degats;
    }

    /**
     * Cette méthode permet de définir le prochain mouvement que le monstre va
     * effectuer.
     * Si le monstre n'a pas effectué ses actions de préparation alors il les fait.
     * Sinon c'est un cycle entre les action de la list cycle.
     */
    protected void changerMouvement() {
        if (preparation.size() > 0) {
            prochain_mouvements = preparation.get(0);
            preparation.remove(0);
        } else {
            // Cas où le cycle est aléatoire
            if (cycle.get(0).getPourcentage() != 0) {
                // Fait un choix alléatoire entre 0 et 1.
                // Puis parcours cycle (qui est triée par ordre croissant de pourcentage) pour
                // trouver à quel mouvement le choix correspond.
                Random random = new Random();
                double choix = random.nextDouble();
                for (Action action : cycle) {
                    if (action.getPourcentage() >= choix) {
                        prochain_mouvements = action;
                    }
                }
            } else {
                // Cas où le cycle n'est pas aléatoire
                prochain_mouvements = cycle.get(cycle_index);
                cycle_index++;
                if (cycle_index >= cycle.size()) {
                    cycle_index = 0;
                }
            }

        }
    }

    @Override
    public String toString() {
        return nom + " :\n\t" + "Prochain mouvement : " + prochain_mouvements.getNom() + "\n\tvie : " + PV;
    }

    public Action getProchain_mouvements() {
        return prochain_mouvements;
    }

}
