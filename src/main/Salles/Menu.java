package main.Salles;

import java.util.Scanner;

import main.Salle;

public class Menu extends Salle {
    private boolean finMenu;

    public Menu() {
        finMenu = false;
    }

    @Override
    protected void tour() {
        for (int i = 0; i < 100; i++) { // Pour plus de visibilité
            System.out.println();
        }
        System.out.println("Bienvenue dans Slay The Spire. Vous pouvez débuter une partie.");
        System.out.println();
        System.out.println("(Appuyez sur Entrée pour continuer)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        finMenu = true;

        // Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
        // fermer.
        if (finMenu == false) {
            scanner.close();
        }
    }

    @Override
    protected boolean isOver() {
        return finMenu;
    }

}
