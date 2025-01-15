/** package principal */
package main;

import java.io.File;

import librairies.StdDraw;
import ressources.Affichage;
import ressources.AssociationTouches;
import ressources.Config;

/*
* Classe Jeu : Classe qui va representer le lancement du Jeu
*/

public class Jeu {

	public Jeu() throws Exception {
	}

	public boolean isOver() {
		return false;
	}

	public void display() {
		StdDraw.clear();

		// Affichage du fond
		String pathBackground = "pictures" + File.separator + "background.jpg";
		Affichage.image(0, Config.X_MAX, 0, Config.Y_MAX, pathBackground);

		// Affichage du heros
		String pathHeros = "pictures" + File.separator + "Ironclad.png";
		Affichage.image(Config.X_MAX * 0.2 - 183, Config.X_MAX * 0.2 + 183, Config.Y_MAX * 0.5 - 130,
				Config.Y_MAX * 0.5 + 130, pathHeros);

		// Affichage de l'energie et le nombre de carte de la pioche, de la defausse et
		// en l'exil
		Affichage.texteGauche(0, Config.Y_MAX - 20, "Pioche : 10");
		Affichage.texteGauche(0, Config.Y_MAX - 45, "Energie : 3/3");
		Affichage.texteDroite(Config.X_MAX, Config.Y_MAX - 20, "Defausse : 0");
		Affichage.texteDroite(Config.X_MAX, Config.Y_MAX - 45, "Exil : 0");

		StdDraw.show(); // montre a l'ecran les changements demandes
	}

	public void initialDisplay() {
		AssociationTouches.init();
		Config.init();
		StdDraw.enableDoubleBuffering(); // rend l'affichage plus fluide: tout draw est mis en buffer et ne s'affiche
											// qu'au prochain StdDraw.show();
		display();
	}

	public void update() {
		String toucheSuivante = AssociationTouches.trouveProchaineEntree(); // cette fonction boucle jusqu'a la
																			// prochaine entree de l'utilisateur
		if (toucheSuivante.equals("Entree")) {
			// deplacer le curseur vers le haut
			System.out.println("Entree");
			display();
		}
		// Ajouter les autres touches utiles avec la classe AssociationTouches
		else {
			System.out.println("Autre touche");
			display();
		}
	}
}
