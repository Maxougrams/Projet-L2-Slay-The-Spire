package main;

/**
 * Classe Action : Cette classe représente une action qu'un monstre peut
 * utiliser
 */
public class Action {
    private String nom;
    private int degats, blocage, force, faiblesse, fragilite, rituel, slime, brulure;
    private double pourcentage;

    /**
     * Constructeur d'un mouvement dans un cycle non aléataoire.
     * Pour les autres paramètres que le nom si le mouvement ne fait rien
     * (comme de pas donner de degats) alors il faut mettre 0
     * 
     * @param nom       nom du mouvement
     * @param degats
     * @param blocage
     * @param force
     * @param faiblesse
     * @param fragilite
     * @param rituel    statut spécique au monstres
     * @param slime     nombre de carte slime qui pollue le deck, coute 1 d'énergie
     *                  et est exilée apres etre jouée
     * @param brulure   nombre de brulure slime qui est impossible a jouer, par
     *                  tour, inflige 2 degats au héros si elle est dans la main
     */
    public Action(String nom, int degats, int blocage, int force, int faiblesse, int fragilite, int rituel, int slime,
            int brulure) {
        this.nom = nom;
        this.degats = degats;
        this.blocage = blocage;
        this.force = force;
        this.faiblesse = faiblesse;
        this.fragilite = fragilite;
        this.rituel = rituel;
        this.slime = slime;
        this.brulure = brulure;
    }

    /**
     * Constructeur d'un mouvement dans un cycle aléatoire.
     * Pour les autres paramètres que le nom si le mouvement ne fait rien
     * (comme de pas donner de degats) alors il faut mettre 0
     * 
     * @param nom         nom du mouvement
     * @param degats
     * @param blocage
     * @param force
     * @param faiblesse
     * @param fragilite
     * @param rituel      statut spécique aux monstres Cultiste
     * @param slime       nombre de carte slime qui pollue le deck, coute 1
     *                    d'énergie et est exilée apres etre jouée
     * @param brulure     nombre de brulure slime qui est impossible a jouer, par
     *                    tour, inflige 2 degats au héros si elle est dans la main
     * @param pourcentage est le pourcentage de chance que le monstre utilise ce
     *                    mouvement
     */
    public Action(String nom, int degats, int blocage, int force, int faiblesse, int fragilite, int rituel,
            double pourcentage, int slime, int brulure) {
        this.nom = nom;
        this.degats = degats;
        this.blocage = blocage;
        this.force = force;
        this.faiblesse = faiblesse;
        this.rituel = rituel;
        this.fragilite = fragilite;
        this.slime = slime;
        this.brulure = brulure;
        this.pourcentage = pourcentage;
    }

    //
    //
    // GETTERS
    //
    //

    public double getPourcentage() {
        return pourcentage;
    }

    public String getNom() {
        return nom;
    }

    public int getDegats() {
        return degats;
    }

    public int getBlocage() {
        return blocage;
    }

    public int getForce() {
        return force;
    }

    public int getFaiblesse() {
        return faiblesse;
    }

    public int getFragilite() {
        return fragilite;
    }

    public int getRituel() {
        return rituel;
    }

    public int getSlime() {
        return slime;
    }

    public int getBrulure() {
        return brulure;
    }

}