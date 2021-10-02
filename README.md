# SimpleFraction2
# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/) si vous n'en possédez pas déjà un.
  Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
  Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
  Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
  Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
   En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
   > Répondre ici

   *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    #   git config --global user.mail naimabouchrit15@gmail.com

    git config --global user.name uvsq22006817
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    #   cd dossier_de_travail
        git init
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
   Vérifiez que le projet compile et s'exécute dans l'IDE;
   Validez les changements;
    ```bash
    # echo ""> Fraction.java
        echo ""> Main.java
        git add Fraction.java
        git commit -m "Ajout Fraction"
        git add Main.java
        git commit -m "Ajout Main"
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
   Validez les changements;
    ```Java
    // Code pour tester toString
public class Fraction {
private int numerateur;
private int denominateur;


    Fraction(int num,int denom)
    {
        this.numerateur = num;
        this.denominateur = denom;
    }

    public String toString()
    {
        String str = this.numerateur + "et " + this.denominateur;
        return str;
    }


}

public class Main {
public static void main(String[] args) {
System.out.println("hello world");

        Fraction f = new Fraction(26,5);
        System.out.println(f.toString());
}}


    ```
1. Publiez vos modifications sur le dépôt distant;
   Vous utiliserez le protocole `https` pour cela;
   Vérifiez avec le navigateur;
    ```bash
    # Commandes pour publier les modifications.
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
   Quelle syntaxe est utilisée pour ce fichier ?
   > echo "">README.md
   git add README.md
   git commit - m "Ajout Readme"
   git push
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    # git pull
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```echo "*.class">.gitignore
    git add .gitignore
    # Copier ici le contenu de `.gitignore`
    ```*.class
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    # On prend les fichiers .iml on les rajoute dans .gitignore.
    ```
   Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    # *.class
SimpleFraction.iml

    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
   > Générer la paire clé publique/clé privée.
   ssh-keygen -b 4096
   COPIER LA CLÉ PUBLIQUE SUR LE SERVEUR
   user@localmachine$ scp ~/.ssh/id_rsa.pub user@remotemachine:/home/user/uploaded_key.pub
   DÉSACTIVER L’ACCÈS AU SERVEUR AVEC LE MOT DE PASSE
   PasswordAuthentication no
   ACCÉDER AU SERVEUR AVEC LA CLÉ PUBLIQUE
   user@localmachine$ ssh user@remotemachine

## Partie II (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
   > Os: windows
   Shell: bash
1. Quelle commande permet d'obtenir de l'aide ?
   Donnez un exemple.
    ```bash
    # help 
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        # ls -s :plus lourd au plus léger
          ls -rl : de plus petit au plus grand
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        # wc -l file.txt
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        # grep -e 'une variable' main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        #   grep -r uneVariable *.java
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        #   find . -name README.md
        "." pour dire le répertoire courant
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        # diff -u fic1 fic2
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
      > protocole permettant d'établir une communication chiffrée, donc sécurisée entre une machine locale et une machine distance
    * `screen`/`tmux`
      > un multiplexeur de terminaux, outil permettant d'exploiter plusieurs terminaux au sein d'un seul et même affichage, le meilleur pour l'utilisateur distant
    * `curl`/[HTTPie](https://httpie.org/)
      > transferer des données, manipulation des données
    * [jq](https://stedolan.github.io/jq/)
      > modifier le format des données .

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
   > Intellij IDEA

   Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
   > dans /.idée pli, il y a encodings.xml fichier, vous pouvez le modifier, <file url="file://$PROJECT_DIR$" charset="UTF-8" />
1. Comment choisir le JDK à utiliser dans un projet ?
   >La version de Java à utiliser dans un projet peut être précisée lors de la création d'un projet.  Pour préciser une version différente, il suffit de cocher « Utiliser une compatibilité propre au projet » et de sélectionner la version à utiliser dans la liste déroulante.
1. Comment préciser la version Java des sources dans un projet ?
   > Pour préciser une version différente, il suffit de cocher « Utiliser une compatibilité propre au projet » et de sélectionner la version à utiliser dans la liste déroulante. Il est possible de modifier la version du JDK à utiliser dans les préférences du projet.
1. Comment ajouter une bibliothèque externe dans un projet ?
   > Procédez comme suit: "structure du projet" -> "modules" -> "cliquez sur le volet projet actuel à droite" -> "dépendances" -> "cliquez sur le petit bouton ajouter (+)" - > "library" -> "sélectionnez la librairie que vous voulez".
1. Comment reformater un fichier source Java ?
   > Ouvrez votre fichier dans l'éditeur et appuyez sur Ctrl+Alt+Shift+Lou dans la fenêtre de l'outil Projet , cliquez avec le bouton droit sur le fichier et sélectionnez Reformater le code .
1. Comment trouver la déclaration d'une variable ou méthode ?
   > Vous voyez une déclaration de variable entre les parenthèses qui suivent le nom de la méthode. La variable int value est un paramètre de la méthode, cette variable recevant une valeur à chaque fois que la méthode est appelée.
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
   > on clique sur le bouton droit dans l'éditeur de code et on selectionne la commande insérer un extrait.
1. Comment renommer une classe dans l'ensemble du projet ?
   > Pour renommer une classe, il y a deux possibilités : selectionner la classe dans la vue « Packages » ou positionner le curseur sur la définition du nom de la classe dans l'éditeur. Puis il faut utiliser l'option « Renommer » du menu contextuel « Propager les modifications ».
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
   > Si vous utilisez intellij, allez dans les Run > Edit Configurations paramètres du menu. Une boîte de dialogue apparaîtra. Vous pouvez maintenant ajouter des arguments dans le Program arguments champ de saisie. Vous pouvez saisir des arguments dans la zone de texte Arguments du programme.
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
   > la perspective "Débogage" affiche quelques vues aussi présentes dans la perspective Java (les vues "Structure" et "Console") ainsi que l'éditeur de code Java.
   Elle affiche aussi plusieurs vues particulièrement dédiées au débogage.
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
   > les Java beans.
   les fichiers JAR.
   RMI pour les objets distribués.
   la sérialisation.
   l'introspection.
   JDBC pour l'accès aux données.
   les classes internes (inner class)
   l'internationalisation...
