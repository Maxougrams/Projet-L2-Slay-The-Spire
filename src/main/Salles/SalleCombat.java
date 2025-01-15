package main.Salles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import main.Action;
import main.Carte;
import main.Heros;
import main.Monstre;
import main.Salle;
import main.Cartes.Brulure;
import main.Cartes.Slime;

/**
 * Cette classe represente une salle de combat, elle gere les combats (les coups
 * donnés, pris et les statuts)
 */
public class SalleCombat extends Salle {
    protected List<Carte> pioche;
    protected List<Carte> defausse;
    protected List<Carte> exil;

    public SalleCombat(Heros heros, List<Monstre> monstres) {
        this.heros = heros;
        this.monstres = monstres;
        pioche = new ArrayList<>();
        defausse = new ArrayList<>();
        exil = new ArrayList<>();
    }

    /**
     * Cette methode permet de gerer les tours de combats
     */
    @Override
    public void tour() {
        this.grandEspace();

        System.out.println("Debut tour\n");

        this.piocher(5); // Le héros pioche 5 cartes
        heros.resetEnergie(); // Réinitialise l'énergie du héros
        heros.setBlocage(0); // Réinitialise le blocage du héros
        // Laisser le joueur choisir une carte à jouer
        Scanner scanner = new Scanner(System.in);
        boolean finTour = false;
        while (!finTour) {
            System.out.println("Votre vie : " + heros.getPV());
            System.out.println("Votre blocage : " + heros.getBlocage());
            System.out.println("Votre energie : " + heros.getEnergie() + "\n");

            this.afficheMonstres();

            // Affiche les différentes cartes possibles et le joueur choisis une carte par
            // un numéro
            System.out.println("Choisissez une carte à jouer (entrez le numéro) :");
            for (int i = 0; i < heros.getMain().size(); i++) {
                Carte carte = heros.getMain().get(i);
                System.out.println("(" + i + ") " + carte);
            }
            int choix = scanner.nextInt();

            this.grandEspace();

            // Vérifie que le numéro entré correspond à une carte
            if (choix >= 0 && choix < heros.getMain().size()) {
                Carte carteChoisie = heros.getMain().get(choix);

                // Vérifie que le héros a assez d'énergie pour que la carte soit jouée et
                // retirée de la main du héros
                if (heros.jouerCarte(carteChoisie)) {
                    this.grandEspace();
                    carteChoisie.executerEffet(heros, monstres);

                    // Applique l'effet piocher de la carte
                    this.piocher(carteChoisie.getPioche());

                    // Jette la carte dans la defausse ou l'exil
                    if (carteChoisie.defausse()) {
                        defausse.add(carteChoisie);
                    } else {
                        exil.add(carteChoisie);
                    }

                    // Supprime les monstres morts (qui ont 0 PV ou moins).
                    monstres = monstres.stream().filter(m -> m.getPV() > 0).collect(Collectors.toList());

                }

                boolean choixCorrect = false; // Pour valider si le choix de continuer/terminer le tour est correct
                while (!choixCorrect && !isOver()) {
                    choixCorrect = true;
                    System.out.println(
                            "Voulez-vous utiliser une autre carte (1) ou finir le tour (2) ?");
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) { // Cas pour continuer le tour
                        this.grandEspace();
                    } else if (choixAction == 2) { // Cas pour arrêter le tour en terminant la boucle
                        finTour = true;
                    } else {
                        this.grandEspace();
                        System.out.println("Choix invalide, essayez encore.\n");
                        choixCorrect = false;
                    }
                }

                if (isOver()) { // Fin de tour si le combat est fini.
                    finTour = true;
                }

            } else {
                this.grandEspace();
                System.out.println("Choix invalide, essayez encore.\n");
            }

        }

        this.attaqueMonstres(); // attaque des monstres
        heros.finDeTour();
        this.defausser();

        System.out.println("Fin tour");

        // Permet de gérer la fin de combat (si le héros meurt ou tout les monstres sont
        // morts)
        if (heros.getPV() <= 0) {
            this.defaite();
            finTour = true;
        } else if (monstres.size() <= 0) {
            this.victoire();
            finTour = true;
        }

        // Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
        // fermer.
        if (exil.size() < -100) {
            scanner.close();
        }
    }

    /**
     * Cette méthode permet de terminer le combat quand le héros a gagné en donnant
     * la possibilité au joueur de choisir une nouvelle carte à ajouter à son deck.
     */
    // ...

    private void victoire() {
        this.grandEspace();
        boolean carteEstChoisie = false;

        System.out.println("Vous avez gagné, tout les monstres sont morts.");
        List<Carte> cartesAChoisir = new ArrayList<>();
        // Choix de la rareté de la carte
        Random random = new Random();
        File dossier;
        String packageName;
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(101);
            if (randomNumber <= 60) {
                // Ajouter une carte commune
                dossier = new File("src\\main\\Cartes\\CartesCommunes");
                packageName = "main.Cartes.CartesCommunes";
            } else if (randomNumber <= 97) {
                // Ajouter une carte non-commune
                dossier = new File("src\\main\\Cartes\\CartesNonCommunes");
                packageName = "main.Cartes.CartesNonCommunes";
            } else {
                // Ajouter une carte rare
                dossier = new File("src\\main\\Cartes\\CartesRares");
                packageName = "main.Cartes.CartesRares";
            }

            String[] nomsFichiersRare = dossier.list();
            if (nomsFichiersRare != null && nomsFichiersRare.length > 0) {
                int randomIndex = random.nextInt(nomsFichiersRare.length);
                String nomFichier = nomsFichiersRare[randomIndex];
                String nomClasse = packageName + '.' + nomFichier.substring(0, nomFichier.lastIndexOf('.'));

                try {
                    cartesAChoisir.add((Carte) Class.forName(nomClasse).getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        // Affiche les différentes cartes possibles et le joueur choisis une carte par
        // un numéro
        while (!carteEstChoisie) {
            System.out.println("Choisissez une carte à ajouter au deck (entrez le numéro) :");
            for (int i = 0; i < cartesAChoisir.size(); i++) {
                Carte carte = cartesAChoisir.get(i);
                System.out.println("(" + i + ") " + carte);
            }
            System.out.println("(" + 3 + ") " + "Aucune carte");
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            this.grandEspace();
            // Vérifie que le numéro entré correspond à une carte
            if (choix == 3) {
                System.out.println("Vous n'avez pas choisi de carte.");
                carteEstChoisie = true;
            }

            else if (choix >= 0 && choix < cartesAChoisir.size()) {
                Carte carteChoisie = cartesAChoisir.get(choix);
                heros.ajouterCarteDeck(carteChoisie);
                carteEstChoisie = true;
            }

            else {
                this.grandEspace();
                System.out.println("Choix invalide, essayez encore.\n");
            }

            // Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
            // fermer.
            if (exil.size() < -100) {
                scanner.close();
            }
        }
    }

    /**
     * @return vrai ssi le combat est fini et faux sinon.
     */
    @Override
    public boolean isOver() {
        if (heros.getPV() <= 0 || monstres.size() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cette méthode permet de terminer quand le héros a perdu.
     */
    private void defaite() {
        this.grandEspace();
        System.out.println("Vous avez perdu, vous n'avez plus de points de vie.");
    }

    /**
     * Cette méthode permet d'effectuer les attaques des monstres. Supprime
     * également les monstres mort de la salle de combat.
     */
    protected void attaqueMonstres() {
        monstres.stream().forEach(m -> m.setBlocage(0)); // Enlève le blocage de tout les monstres
        for (Monstre monstre : monstres) {
            // Récupère le prochain mouvement du monstre, ajoute les point de faiblesse,
            // fragilité et les dégats au héros.
            Action action = monstre.getProchain_mouvements();
            heros.ajoutStatutsFaiblesse(action.getFaiblesse());
            heros.ajoutStatutsFragile(action.getFragilite());
            heros.subirDegats(monstre.attaquer());
            for (int i = 0; i < action.getSlime(); i++) { // Ajoute les cartes Slime si il y en a.
                defausse.add(new Slime());
            }
            for (int i = 0; i < action.getBrulure(); i++) { // Ajoute les cartes Brulure si il y en a.
                defausse.add(new Brulure());
            }
            monstre.finDeTour();
        }
    }

    private void afficheMonstres() {
        for (int i = 0; i < monstres.size(); i++) {
            System.out.println("(" + i + ") " + monstres.get(i));
        }
        System.out.println();
    }

    /**
     * Cette methode permet de piocher 5 cartes aleatoirement, si la pioche est
     * vide on reprend les cartes de la defausse pour les remettre dans la pioche.
     */
    private void piocher(int nombre) {

        // Pioche une carte aleatoirement en l'ajoutant dans les cartes en main.
        Random rand = new Random();
        for (int i = 0; i < nombre; i++) {
            // Cas ou la pioche est vide.
            if (pioche.isEmpty()) {
                if (defausse.isEmpty()) { // cas où c'est le début du combat et que la pioche n'est pas initialisé
                    pioche.addAll(heros.getDeck());
                } else { // cas dans le reste du combat
                    pioche.addAll(defausse);
                    defausse.clear();
                }
            }

            if (!pioche.isEmpty()) {
                int index = rand.nextInt(pioche.size());
                heros.ajouterCarteMain(pioche.remove(index));
            }
        }
    }

    /**
     * Cette méthode permet d'ajouter les cartes qui étaient en main du héros dans
     * la défausse.
     */
    private void defausser() {
        List<Carte> mainHero = heros.resetCartesMain();
        for (Carte carte : mainHero) {
            if (carte.getNom() == "Brûlure") { // Applique l'effet de la carte brulure.
                heros.gagnerVie(-2);
            }
        }
        defausse.addAll(mainHero);
    }

    /**
     * Cette méthode permet d'afficher un grand espace vide pour plus de visibilité
     * dans le jeu.
     */
    private void grandEspace() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}