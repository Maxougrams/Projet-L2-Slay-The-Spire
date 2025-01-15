package main.Salles;

import java.util.Scanner;

import main.Heros;
import main.Salle;

/**
 * Cette classe represente une salle de repos, elle permet au heros de se
 * reposer et de regagner de la vie
 */
public class SalleRepos extends Salle {
    Heros heros;
    Boolean finRepos;

    // Bloc d'initialisation
    {
        finRepos = false;
    }

    public SalleRepos(Heros heros) {
        this.heros = heros;
    }

    @Override
    public void tour() {
        System.out.println("Vous entrez dans une salle de repos");
        heros.setPV(heros.getPV() + (heros.getPVmax() * 30 / 100));
        if (heros.getPV() > heros.getPVmax()) {
            heros.setPV(heros.getPVmax());
        }
        System.out.println("Vous regagnez 30% des points de vie maximum.");
        System.out.println("Vous avez maintenant " + heros.getPV() + " points de vie");
        System.out.println("(Appuyez sur Entrée pour continuer)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        finRepos = true;

        // Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
        // fermer.
        if (heros.getBlocage() == -1000) {
            scanner.close();
        }
    }

    @Override
    protected boolean isOver() {
        return finRepos;
    }
}
