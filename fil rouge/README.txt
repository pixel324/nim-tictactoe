Auteurs du projet : 
		MAURAND Pierre 21702704, L2 Informatique, Groupe 4B, le vendredi apr�s-midi
		GALLIS Robin 21700872, L2 Informatique, Groupe 4B, le vendredi apr�s-midi
		RAGOT David 21708377, L2 Informatique, Groupe 4B, le vendredi apr�s-midi
		BERTHIER Th�o 21611020, L2 Informatique, Groupe 4B, le vendredi apr�s-midi

Enseignante : 
		C�line Alec

Pour lancer notre application :
	
	�tape 1 - Apr�s d�compression du fichier, lancer un terminal unix, et taper "cd src" afin de se placer dans le dossier principal contenant nos dossiers (normalement vous devriez voir 3 packages nomm�es orchestration , players et games).
	�tape 2 - Taper dans le terminal la commande "mkdir build", un dossier build vient d'�tre cr�e.
	�tape 3 - �x�cuter la commande : javac -d build players/*.java games/*.java orchestration/*.java
	�tape 4 - �x�cuter la commande : java -cp build/ orchestration.Demo "nom_du_jeu" "type_joueur1" "type_joueur2" "nom_joueur1(si c'est un humain)" "nom_joueur2(si c'est un humain)"

	Il existe 2 jeux : TicTacToe et Nim (les majuscules ne sont pas importantes)
	Il existe 3 types de joueurs : MinMax, aleatoire et humain (les majuscules ne sont pas importantes)
	Pour le Nim, la taille du tas ainsi que le nombre maximum d'allumettes sera demand� lors de l'�x�cution du jeu.

Commandes sp�cifiques :
 
	Cr�ation du .jar :
		A la suite de l'�tape 2, il est possible de cr�er un .jar de notre application en se pla�ant dans le 
		dossier build avec la commande "cd build", puis �x�cuter la commande : jar cfe "nom_du_jar".jar orchestration.Demo . (le point est important)

	Lancement du .jar :
		Afin de lancer le .jar, il faut se placer dans le dossier ou est situ� le .jar 
		(normalement toujours dans le dossier build) puis �x�cuter la commande : java -jar "nom_du_jar".jar "nom_du_jeu" "type_joueur1" "type_joueur2" "nom_joueur1(si c'est un humain)" "nom_joueur2(si c'est un humain)"
	
	Cr�ation d'une javadoc expliquant notre projet : 
		Se placer dans le dossier principal (le dossier nomm� "src"), puis ex�cuter la commande "mkdir doc" dans 
		un terminal, puis ex�cutez la commande : javadoc -d doc games/*.java orchestration/*.java players/*.java
	
	Acc�der � la javadoc :
		Se placer dans le dossier doc gr�ce � la commande "cd doc", puis lancer le fichier nomm� "index.html"


NIM :
	But du jeu : 
		Le but du jeu du Nim est de faire en sorte que notre adversaire retire la derni�re allumette.
	Initiation du jeu : 
		Afin de pouvoir commencer � jouer, il faut choisir la taille du tas d'allumettes, et le nombre maximum
		d'allumettes que chaques joueurs pourra retirer.
	D�roulement du jeu : 
		Le joueur 1 commence � jouer, il va devoir choisir un nombre d'allumettes � retirer du tas compris entre
		1 et le nombre maximum choisit pr�c�demment. Quand il aura enlev� ces ou cette allumette(s), sa sera
		au joueur 2 de jouer ... etc
	Fin  de jeu : 
		Le jeu se finit quand l'un des deux joueurs retire la derni�re allumette du tas, ce joueur aura donc perdu.


TICTACTOE :
	But du jeu : 
		Le but du TicTacToe, est d'aligner 3 fois son symbole en diagonale, verticale ou horizontale.
	Initiation du jeu : 
		Afin de pouvoir joueur, il faut avoir 2 joueurs, et leurs noms si ils sont humains.
	D�roulement du jeu : 
		Le joueur 1 commence � jouer, il va choisir une case de la grille (repr�sent�e par le pav� num�rique sur
		un clavier), si la case choisie est vide, le symbole sera plac�, viendra ensuite le tour du joueur 2 ... etc
	Fin  de jeu : 
		Le jeu se finit quand l'un des deux joueurs aligne ses 3 symboles en diagonale, � l'horizontale ou � la 
		verticale.

Voici � quoi ressemble la grille avec les nombres � taper pour jouer dans chaques cases : 
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
