package main;

import java.util.List;

/*
* Classe Salle : Classe qui va representer les differentes salles du jeu
*/
public abstract class Salle {
    protected Heros heros;
    protected List<Monstre> monstres;
    protected List<Carte> defausse;
    protected List<Carte> pioche;

    protected abstract void tour();

    /**
     * 
     * @return Vrai ssi ce qui peut être fait dans la salle est fini.
     */
    protected abstract boolean isOver();

    /**
     * 
     * @return vrai ssi la héro a gagné et faut sinon.
     */
    public boolean isVictory() {
        if (monstres.size() <= 0 && heros.getPV() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
