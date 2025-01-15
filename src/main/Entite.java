package main;

import java.util.HashMap;
import java.util.Map;

/*
* Classe Entite : Classe mere qui represente toutes les entites
*/
public abstract class Entite {

    protected int PV;
    protected int PVmax;
    protected int blocage;
    protected int energie;
    protected Map<String, Integer> statuts;

    // Bloc d'initialisation
    {
        statuts = new HashMap<>();
        blocage = 0;
        statuts.put("Force", 0);
        statuts.put("Faiblesse", 0);
        statuts.put("Vulnerable", 0);
        statuts.put("Fragile", 0);
        statuts.put("Rituel", 0);
    }

    /**
     * Cette fonction retourne le nombre de dégats qui vont être donné à l'ennemi
     * 
     * @param degats , les degats qui sont donner par une carte ou une action de
     *               monstre
     * @return les degats qui vont être donné après les effets des
     *         statuts
     */
    protected int attaquerEffetsStatuts(int degats) {
        // Appliquer l'effet de Force
        degats += statuts.get("Force");

        // Appliquer l'effet de Faiblesse
        int faiblesse = statuts.get("Faiblesse");
        if (faiblesse > 0) {
            degats = (int) Math.floor(0.75 * degats);
        }

        return degats;
    }

    /**
     * Cette fonction rend le nombre de degats reellement subit par le hero
     * 
     * @param degats le nombre de degats initialement subit
     * @return le nombre de degats subit apres l'application des effets
     */
    protected int subirEffetsStatuts(int degats) {

        // Appliquer l'effet de Vulnerabilite
        int vulnerabilite = statuts.get("Vulnerable");
        if (vulnerabilite > 0) {
            degats = (int) Math.floor(1.5 * degats);
        }

        return degats;
    }

    protected void gainStatuts(Carte carte) {
        // Appliquer l'effet de Fragilite
        int fragilite = statuts.get("Fragile");
        if (fragilite > 0) {
            // La fragilite reduit le blocage
            blocage = (int) Math.floor(0.75 * blocage);
        }
    }

    /**
     * Cette fonction permet d'infliger des degats a l'entite en appliquant les
     * effets de statuts et le blocage
     * 
     * @param degats les degats inflige
     */
    public void subirDegats(int degats) {
        // applique les effets de statuts
        degats = subirEffetsStatuts(degats);

        // applique le blocage
        if (blocage > 0) {
            blocage -= degats;
            if (blocage < 0) {
                PV += blocage;
                blocage = 0;
            }
        } else {
            PV -= degats;
        }
    }

    /**
     * Cette méthode doit être appelée à la fin du tour, elle permet de diminuer les
     * points de faiblesse, de vulnérabilité et de fragilité.
     */
    public void finDeTour() {

        if (this.getStatutsFaiblesse() > 0) {
            this.ajoutStatutsFaiblesse(-1);
        }
        if (this.getStatutsVulnerable() > 0) {
            this.ajoutStatutsVulnerable(-1);
        }
        if (this.getStatutsFragile() > 0) {
            this.ajoutStatutsFragile(-1);
        }
    }

    public void gagnerBlocage(int bloc) {
        if (statuts.get("Fragile") > 0) {
            blocage += (int) Math.floor(0.75 * bloc);
        }

        blocage += bloc;
    }

    public Integer getStatutsForce() {
        return statuts.get("Force");
    }

    public Integer getStatutsVulnerable() {
        return statuts.get("Vulnerable");
    }

    public Integer getStatutsFaiblesse() {
        return statuts.get("Faiblesse");
    }

    public Integer getStatutsFragile() {
        return statuts.get("Fragile");
    }

    public void ajoutStatutsForce(int force) {
        this.statuts.put("Force", force + statuts.get("Force"));
    }

    public void ajoutStatutsVulnerable(int vulnerabilite) {
        this.statuts.put("Vulnerable", vulnerabilite + statuts.get("Vulnerable"));
    }

    public void ajoutStatutsFaiblesse(int faiblesse) {
        this.statuts.put("Faiblesse", faiblesse + statuts.get("Faiblesse"));
    }

    public void ajoutStatutsFragile(int fragilite) {
        this.statuts.put("Fragile", fragilite + statuts.get("Fragile"));
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int pV) {
        PV = pV;
    }

    public int getPVmax() {
        return PVmax;
    }

    public void setPVmax(int pVmax) {
        PVmax = pVmax;
    }

    public int getBlocage() {
        return blocage;
    }

    public void setBlocage(int blocage) {
        this.blocage = blocage;
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public Map<String, Integer> getStatuts() {
        return statuts;
    }

    public void setStatuts(Map<String, Integer> statuts) {
        this.statuts = statuts;
    }

}