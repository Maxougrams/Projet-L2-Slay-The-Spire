package main;

import java.util.List;
import java.util.Random;

public class Carte {
    protected String nom;
    protected int coutEnergie;
    protected String description;

    protected enum cibleType {
        monstre, tousLesMonstres, monstreHasard, aucune
    };

    protected cibleType cible;
    protected Effet effet;

    // Bloc d'initialisation
    {
        effet = new Effet(); // Les effets sont initialisé par des valeurs par défauts.
        cible = cibleType.aucune;
    }

    /**
     * Cette fonction applique ce que la carte dois faire.
     * 
     * @param heros    : le héro qui utilise la carte
     * @param monstres : tout les monstres en vie dans la salle
     */
    public void executerEffet(Heros heros, List<Monstre> monstres) {
        // Applique les effets qui sont sur le héro.
        heros.gagnerBlocage(effet.getBlocage());
        heros.gagnerEnergie(effet.getEnergie());
        heros.ajoutStatutsForce(effet.getGainForce());
        heros.gagnerVie(effet.getPerdVie());

        // Applique les effets qui sont sur le/les monstre/s, en fonction de si la carte
        // à des effets sur un monstre choisi par le héro, un monstre au hasard ou tout
        // les monstrers.
        switch (cible) {
            case monstre:
                int m = heros.cible(monstres);
                Monstre monstre = monstres.get(m);
                for (int i = 0; i < effet.getNbApplication(); i++) {
                    monstre.subirDegats(heros.attaquerEffetsStatuts(effet.getDegats()));
                    monstre.ajoutStatutsFaiblesse(effet.getFaiblesse());
                    monstre.ajoutStatutsForce(-effet.getInfligeForce());
                    monstre.ajoutStatutsVulnerable(effet.getVulnerabilite());
                }

                break;

            case tousLesMonstres:
                for (Monstre monstre2 : monstres) {
                    monstre2.subirDegats(effet.getDegats() + heros.getStatutsForce());
                    monstre2.ajoutStatutsFaiblesse(effet.getFaiblesse());
                    monstre2.ajoutStatutsForce(-effet.getInfligeForce());
                    monstre2.ajoutStatutsVulnerable(effet.getVulnerabilite());

                }
                break;

            case monstreHasard:
                for (int i = 0; i < effet.getNbApplication(); i++) {
                    // Tire au hasard un monstre vivant dans la salle.
                    Random random = new Random();
                    Monstre monstre3 = monstres.get(random.nextInt(monstres.size()));
                    monstre3.subirDegats(effet.getDegats() + heros.getStatutsForce());
                    monstre3.ajoutStatutsFaiblesse(effet.getFaiblesse());
                    monstre3.ajoutStatutsForce(-effet.getInfligeForce());
                    monstre3.ajoutStatutsVulnerable(effet.getVulnerabilite());
                }
                break;
            case aucune:
                break;
        }

    }

    /**
     * 
     * @return vrai ssi la carte va à la défausse après et faux sinon.
     */
    public boolean defausse() {
        return !effet.isExil();
    }

    public String getNom() {
        return nom;
    }

    public int getCoutEnergie() {
        return coutEnergie;
    }

    public String getDescription() {
        return description;
    }

    public int getPioche() {
        return effet.getPioche();
    }

    @Override
    public String toString() {
        return nom + " (cout : " + coutEnergie + ", effet : " + description + ")";
    }
}