package main.Cartes.CartesCommunes;

import main.Carte;

public class MemePasMal extends Carte {
    public MemePasMal() {
        nom = "Meme Pas Mal";
        description = "Gagne 8 points de blocage puis pioche une carte";
        coutEnergie = 1;
        effet.setBlocage(8);
        effet.setPioche(1);
    }
}
