package main;

/**
 * Cette classe sert à représenter les effets qu'une carte peut avoir
 */
public class Effet {
    // Variable pour ce qui est infligé
    private int degats, vulnerabilite, faiblesse, infligeForce;

    // Variable pour ce qui est gagné
    private int blocage, energie, gainForce, perdVie;

    private int nbApplication; // Nombre de fois où s'appliquent les effets
    private boolean exil; // Si vrai alors carte mise en exil
    private int pioche; // Nombre de cartes que le héro pioche
    private int cartesPlaie; // Nombre de cartes plaie que le héro pioche
    private int formeDemoniaque; // Nombre de points forme démoniaque gagnés

    /**
     * Lorsque qu'un effet est créé, tout les effets sont initialisé avec des
     * valeurs par défauts. Pour créer un effet il faut modifer seulement les effets
     * voulu avec setEffet().
     */
    public Effet() {
        degats = 0;
        vulnerabilite = 0;
        faiblesse = 0;
        infligeForce = 0;

        blocage = 0;
        energie = 0;
        gainForce = 0;
        perdVie = 0;

        nbApplication = 1;
        exil = false;
        pioche = 0;
        cartesPlaie = 0;
        formeDemoniaque = 0;

    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getVulnerabilite() {
        return vulnerabilite;
    }

    public void setVulnerabilite(int vulnerabilite) {
        this.vulnerabilite = vulnerabilite;
    }

    public int getFaiblesse() {
        return faiblesse;
    }

    public void setFaiblesse(int faiblesse) {
        this.faiblesse = faiblesse;
    }

    public int getInfligeForce() {
        return infligeForce;
    }

    public void setInfligeForce(int infligeForce) {
        this.infligeForce = infligeForce;
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

    public int getGainForce() {
        return gainForce;
    }

    public void setGainForce(int gainForce) {
        this.gainForce = gainForce;
    }

    public int getPerdVie() {
        return perdVie;
    }

    public void setPerdVie(int perdVie) {
        this.perdVie = perdVie;
    }

    public int getNbApplication() {
        return nbApplication;
    }

    public void setNbApplication(int nbApplication) {
        this.nbApplication = nbApplication;
    }

    public boolean isExil() {
        return exil;
    }

    public void setExil(boolean exil) {
        this.exil = exil;
    }

    public int getPioche() {
        return pioche;
    }

    public void setPioche(int pioche) {
        this.pioche = pioche;
    }

    public int getCartesPlaie() {
        return cartesPlaie;
    }

    public void setCartesPlaie(int cartesPlaie) {
        this.cartesPlaie = cartesPlaie;
    }

    public int getFormeDemoniaque() {
        return formeDemoniaque;
    }

    public void setFormeDemoniaque(int formeDemoniaque) {
        this.formeDemoniaque = formeDemoniaque;
    }
}
