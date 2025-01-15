/** package principal */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.Monstres.Cultiste;
import main.Monstres.Hexaghost;
import main.Monstres.Machouilleur;
import main.Monstres.PetitSlimeAcide;
import main.Monstres.PetitSlimePiquant;
import main.Monstres.SlimeAcide;
import main.Monstres.SlimePiquant;
import main.Salles.Menu;
import main.Salles.SalleBoss;
import main.Salles.SalleCombat;
import main.Salles.SalleRepos;

/*
* Classe Jeu : Classe qui va representer le lancement du Jeu en ligne de commande
*/

public class JeuLigneCmd extends Jeu {
	private Heros monHero;
	private List<Salle> salles;

	public JeuLigneCmd() throws Exception {
		super();
		monHero = new Heros();
		this.initialisation();

	}

	@Override
	public void update() {
		Salle salle = salles.get(0);
		if (salles.size() > 0) {
			if (!salle.isOver()) { // Cas où ce qui doit être fait dans la salle n'est pas fini.
				salle.tour();
			} else if ((salle instanceof SalleCombat) || salle instanceof SalleBoss) {
				if (salle.isVictory()) { // Cas où c'ets un combat et qu'il est fini et gagné.
					salles.remove(0);
				} else { // Cas où c'ets un combat et qu'il est fini et perdu.
					System.out.println("Le jeu va redémarrer");
					System.out.println("(Appuyez sur Entrée pour continuer)");
					Scanner scanner = new Scanner(System.in);
					scanner.nextLine();
					this.initialisation();

					// Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
					// fermer.
					if (monHero.getBlocage() == -1000) {
						scanner.close();
					}
				}

			} else { // Cas où ce n'est pas un combat et que ce qui est fait dans la salle est fini.
				salles.remove(0);
			}
		} else { // Cas où le joueur finis le jeu.
			System.out.println("Bravo vous avez réussi à terminer le jeu !!");
			System.out.println("Le jeu va redémarrer");
			System.out.println("(Appuyez sur Entrée pour continuer)");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			this.initialisation();

			// Sert uniquement à enlever l'erreur dûe au scanner que l'on ne peut pas
			// fermer.
			if (monHero.getBlocage() == -1000) {
				scanner.close();
			}
		}

	}

	/**
	 * Cette méthode permet d'initialiser le jeu. Elle initialise le hero et les
	 * salles avec ses monstres.
	 */
	private void initialisation() {
		// creer un hero et des petits slime piquant
		monHero.reset();
		salles = new ArrayList<>();
		List<Monstre> mesMonstres;

		// Ajout des differentes salle pour jouer.
		salles.add(new Menu());

		// Combat 1
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimePiquant(), new PetitSlimePiquant()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 2
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimePiquant(), new PetitSlimeAcide(), new PetitSlimePiquant()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Salle de repos
		salles.add(new SalleRepos(monHero));

		// Combat 3
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimePiquant(), new Machouilleur()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 4
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new SlimePiquant()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 5
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new SlimeAcide()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Salle de repos
		salles.add(new SalleRepos(monHero));

		// Combat 6
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new Cultiste()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 7
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimePiquant(), new PetitSlimeAcide(), new PetitSlimePiquant()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 8
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new Machouilleur()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Salle de repos
		salles.add(new SalleRepos(monHero));

		// Combat 9
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimeAcide(), new PetitSlimePiquant(), new SlimeAcide()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Combat 10
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new PetitSlimePiquant(), new Machouilleur()));
		salles.add(new SalleCombat(monHero, mesMonstres));

		// Salle de repos
		salles.add(new SalleRepos(monHero));

		// Salle du Boss
		mesMonstres = new ArrayList<>();
		mesMonstres.addAll(Arrays.asList(new Hexaghost()));
		salles.add(new SalleBoss(monHero, mesMonstres));

	}
}