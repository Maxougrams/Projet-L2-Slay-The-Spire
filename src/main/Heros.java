package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import main.Cartes.CartesCommunes.Defense;
import main.Cartes.CartesCommunes.Frappe;
import main.Cartes.CartesCommunes.Heurt;

/*
* Classe Heros : Classe qui va representer le Heros d
*/
public class Heros extends Entite {
    private List<Carte> deck;
    private List<Carte> deckJouable;

    private List<Carte> main;

    public Heros() {
        this.PV = 70;
        this.PVmax = 70;
        energie = 3;
        deck = new LinkedList<>();
        deckJouable = new LinkedList<>();
        main = new ArrayList<>();

        Carte carte = null;
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    carte = new Frappe();
                    break;
                case 1:
                    carte = new Frappe();
                    break;
                case 2:
                    carte = new Frappe();
                    break;
                case 3:
                    carte = new Frappe();
                    break;
                case 4:
                    carte = new Frappe();
                    break;
                case 5:
                    carte = new Defense();
                    break;
                case 6:
                    carte = new Defense();
                    break;
                case 7:
                    carte = new Defense();
                    break;
                case 8:
                    carte = new Defense();
                    break;
                case 9:
                    carte = new Heurt();
                    break;
            }
            deck.add(carte);
        }
        deckJouable.addAll(deck);
    }

    /**
     * 
     */
    public void ajouterCarteMain(Carte carte) {
        main.add(carte);
    }

    /**
     * Cette méthode supprime toutes les cartes en main du héro et les retournes
     * 
     * @return une ArrayList des cartes que le héro avait en main.
     */
    public List<Carte> resetCartesMain() {
        List<Carte> a = new ArrayList<>();
        a.addAll(main);
        main.clear();
        return a;
    }

    public void ajouterCarteDeck(Carte carte) {
        this.deckJouable.add(carte);
    }

    /**
     * 
     * @return le monstre que le Hero veut attaquer
     */
    public int cible(List<Monstre> monstres) {
        // simplification pour le jeu en texte

        Scanner s = new Scanner(System.in);
        int m = 1; // Le numéro du monstre que le héro choisis
        boolean choixCorrect = false;
        while (!choixCorrect) {

            // affichage des monstres possible a attaquer
            System.out.println("Veuillez entrer le numero correspondant au monstre a attaquer :");
            for (int i = 0; i < monstres.size(); i++) {
                System.out.println("(" + i + ") " + monstres.get(i));
            }

            // choix du monstres
            m = s.nextInt();

            if (m >= 0 && m < monstres.size()) {
                choixCorrect = true;
            } else {
                System.out.println("Choix invalide, essayez encore.");
            }
        }
        // Sert uniquement à enlever l'erreur dû au scanner que l'on ne peut pas fermer.
        if (monstres.size() < -100) {
            s.close();
        }
        return m;
    }

    /**
     * Cette méthode permet au héro de jouer une carte. Elle vérifie si la héro a
     * suffisament d'énergie et retire la carte en main.
     * 
     * @param carte à jouer
     * @return vrai ssi la carte peut être jouer.
     */
    public boolean jouerCarte(Carte carte) {
        if (carte.getCoutEnergie() > this.getEnergie()) {
            System.out.println("Vous n'avez pas assez d'énergie pour jouer cette carte.");
            return false;
        } else if (carte.getNom() == "Brûlure" || carte.getNom() == "Plaie") {
            System.out.println("Cette carte ne permet pas d'être jouée.");
            return false;
        }
        energie -= carte.getCoutEnergie();
        main.remove(carte);
        return true;
    }

    public void reset() {
        deckJouable.clear();
        deckJouable.addAll(deck);
        PV = PVmax;
        energie = 3;
        main.clear();
    }

    /**
     * Cette méthode permet au héro de remettre l'énergie du héro au max de son
     * énergie. Doit être fait au début de chaque tour.
     */
    public void resetEnergie() {
        energie = 3;
    }

    /**
     * Cette methode permet au hero de gagner du blocage
     */
    public void gagnerBlocage(int bloc) {
        blocage += bloc;
    }

    public void gagnerEnergie(int energie) {
        this.energie += energie;
    }

    /**
     * Ne prends pas compte du blocage
     * 
     * @param PV peut être négatif
     */
    public void gagnerVie(int PV) {
        this.PV += PV;
    }

    public List<Carte> getDeck() {
        return deckJouable;
    }

    public List<Carte> getMain() {
        return main;
    }

    public void setMain(List<Carte> main) {
        this.main = main;
    }

}
