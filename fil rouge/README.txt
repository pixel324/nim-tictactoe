Auteurs du projet : 
		MAURAND Pierre 21702704, L2 Informatique, Groupe 4B, le vendredi après-midi
		GALLIS Robin 21700872, L2 Informatique, Groupe 4B, le vendredi après-midi
		RAGOT David 21708377, L2 Informatique, Groupe 4B, le vendredi après-midi
		BERTHIER Théo 21611020, L2 Informatique, Groupe 4B, le vendredi après-midi

Enseignante : 
		Céline Alec

Pour lancer notre application :
	
	Étape 1 - Après décompression du fichier, lancer un terminal unix, et taper "cd src" afin de se placer dans le dossier principal contenant nos dossiers (normalement vous devriez voir 3 packages nommées orchestration , players et games).
	Étape 2 - Taper dans le terminal la commande "mkdir build", un dossier build vient d'être crée.
	Étape 3 - Éxécuter la commande : javac -d build players/*.java games/*.java orchestration/*.java
	Étape 4 - Éxécuter la commande : java -cp build/ orchestration.Demo "nom_du_jeu" "type_joueur1" "type_joueur2" "nom_joueur1(si c'est un humain)" "nom_joueur2(si c'est un humain)"

	Il existe 2 jeux : TicTacToe et Nim (les majuscules ne sont pas importantes)
	Il existe 3 types de joueurs : MinMax, aleatoire et humain (les majuscules ne sont pas importantes)
	Pour le Nim, la taille du tas ainsi que le nombre maximum d'allumettes sera demandé lors de l'éxécution du jeu.

Commandes spécifiques :
 
	Création du .jar :
		A la suite de l'étape 2, il est possible de créer un .jar de notre application en se plaçant dans le 
		dossier build avec la commande "cd build", puis éxécuter la commande : jar cfe "nom_du_jar".jar orchestration.Demo . (le point est important)

	Lancement du .jar :
		Afin de lancer le .jar, il faut se placer dans le dossier ou est situé le .jar 
		(normalement toujours dans le dossier build) puis éxécuter la commande : java -jar "nom_du_jar".jar "nom_du_jeu" "type_joueur1" "type_joueur2" "nom_joueur1(si c'est un humain)" "nom_joueur2(si c'est un humain)"
	
	Création d'une javadoc expliquant notre projet : 
		Se placer dans le dossier principal (le dossier nommé "src"), puis exécuter la commande "mkdir doc" dans 
		un terminal, puis exécutez la commande : javadoc -d doc games/*.java orchestration/*.java players/*.java
	
	Accéder à la javadoc :
		Se placer dans le dossier doc grâce à la commande "cd doc", puis lancer le fichier nommé "index.html"


NIM :
	But du jeu : 
		Le but du jeu du Nim est de faire en sorte que notre adversaire retire la dernière allumette.
	Initiation du jeu : 
		Afin de pouvoir commencer à jouer, il faut choisir la taille du tas d'allumettes, et le nombre maximum
		d'allumettes que chaques joueurs pourra retirer.
	Déroulement du jeu : 
		Le joueur 1 commence à jouer, il va devoir choisir un nombre d'allumettes à retirer du tas compris entre
		1 et le nombre maximum choisit précédemment. Quand il aura enlevé ces ou cette allumette(s), sa sera
		au joueur 2 de jouer ... etc
	Fin  de jeu : 
		Le jeu se finit quand l'un des deux joueurs retire la dernière allumette du tas, ce joueur aura donc perdu.


TICTACTOE :
	But du jeu : 
		Le but du TicTacToe, est d'aligner 3 fois son symbole en diagonale, verticale ou horizontale.
	Initiation du jeu : 
		Afin de pouvoir joueur, il faut avoir 2 joueurs, et leurs noms si ils sont humains.
	Déroulement du jeu : 
		Le joueur 1 commence à jouer, il va choisir une case de la grille (représentée par le pavé numérique sur
		un clavier), si la case choisie est vide, le symbole sera placé, viendra ensuite le tour du joueur 2 ... etc
	Fin  de jeu : 
		Le jeu se finit quand l'un des deux joueurs aligne ses 3 symboles en diagonale, à l'horizontale ou à la 
		verticale.

Voici à quoi ressemble la grille avec les nombres à taper pour jouer dans chaques cases : 
	7 | 8 | 9
	---------
	4 | 5 | 6
	---------
	1 | 2 | 3

Enfin voici l'arborescence de notre application : 

	Fil rouge (dossier)
		|
		|-->ReadMe.txt (fichier)
		|-->src (dossier)
		     |
		     |-->orchestration (dossier)
		     |		|-->Demo.java (fichier)
		     |		|-->Orchestrator.java (fichier)
		     |-->players (dossier)
		     |	    |-->GamePlayer.java (fichier)
		     |	    |-->Human.java (fichier)
		     |	    |-->MinMaxPlayer (fichier)
		     |      |-->RandomPlayer (fichier)
		     |-->games (dossier)
		     |     |-->AbstractGame.java (fichier)
		     |	   |-->Nim.java (fichier)
		     |	   |-->TicTacToe (fichier)
