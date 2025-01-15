__**Projet PO**__
=======

__**Auteurs**__
-----------

* **Sami SAOUD**
* **Maxance SPARENBERG**


# __**Fonctionnalités du jeu**__

Le jeu présenté ne fonctionne uniquement en texte. Il faut lancer Main.java pour le démarrer. Main.java ne créer pas d'instance de la classe Jeu mais une instance de JeuLigneCmd qui étant Jeu.

## __**Classes principales**__


1. **Action.java**

- Représente une action qu'un monstre peut utiliser pendant le combat.
- Les attributs incluent des statistiques telles que les dégâts, le blocage, la force, etc.
- Deux constructeurs sont disponibles pour les actions avec des cycles aléatoires ou non.


2. **Carte.java**

- Représente une carte pouvant être utiliser par le héros pendant le combat.
- Chaque carte a un effet spécifique qui peut affecter le héros, les monstres, ou les deux.
- L'exécution de l'effet se fait via la méthode executerEffet.


3. **Effet.java**

- Représente les effets associés aux cartes.
- Contient des attributs pour les dégâts infligés, le blocage, l'énergie gagnée, etc.
- Lors de la création de l'objet Effet, les valeurs des effets sont initialisé par des valeurs par défaut.
- Les effets peuvent être modifiés à l'aide des méthodes setEffet.


4. **Entite.java**

- Classe abstraite représentant toutes les entités du jeu (héros, monstres).
- Gère les points de vie, le blocage et les statuts des entités.


5. **Heros.java**

- Hérite de la classe Entite et représente le héros du joueur.
- Possède un deck de cartes, une main, des points d'énergie et peut jouer des cartes pendant le combat.


6. **Monstre.java**

- Classe abstraite représentant les monstres du jeu.
- Les monstres ont des actions de préparation et un cycle d'actions pendant le combat.
- La méthode attaquer permet au monstre d'attaquer le héros.


# __**Système de Combat**__

Le jeu propose un système de combat où le héros affronte différents monstres dans des salles. Le déroulement du combat est géré par les classes SalleCombat. Le héros peut jouer des cartes de son deck pour infliger des dégâts, gagner du blocage, etc. Et les monstres l'attaque également en retour.


# __**Gestion des Salles**__

Les salles sont gérées par plusieurs classes, notamment SalleCombat et SalleRepos qui sont toutes héritée de Salle. Chaque salle a ses propres caractéristiques et interactions.
- SalleCombat : c'est une salle où se déroule un combat entre le héro et un/plusieurs monstres jusqu'à ce que les monstres ou le héro meurt.
- SalleRepos : est une salle où le héro se repose, ce qui lui permet de regagner 30% de sa vie.

# __**Modification par rapport au PDF**__
- Les attaques "Enfer" et "Charge" du monstre Hexaghost : lorsque les dégats doivent être appliqué 2 fois, elle ne sont appliquée qu'une fois mais avec 2*dégats. Si l'attaque inflie 2 fois 6 dégats, ici elle inflige 1 fois 12 dégats