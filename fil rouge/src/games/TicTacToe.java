package games;
import players.*;

import java.util.List;
import java.util.ArrayList;
/**
 * Classe de notre jeu du morpion, nous n'utilisons qu'une seule variable propre à cette classe qui est le tableau de jeu, qui est un tableau de 3x3 de GamePlayer
 */
public class TicTacToe extends AbstractGame {

	private GamePlayer [][] grid;
	/**
	 * Constructeur de la classe TicTacToe (morpion)
	 * @param joueur1 est un GamePlayer représentant le joueur 1
	 * @param joueur2 est un GamePlayer représentant le joueur 2
	 */
	public TicTacToe(GamePlayer joueur1,GamePlayer joueur2){
		super(joueur1,joueur2);
		this.grid = new GamePlayer [3][3];
	}

	/**
	 * Méthode permettant de savoir si un coup est valide ou non
	 * @param nombre est le coup saisi par le joueur ou l'ordinateur
	 * @return de manière booléenne si le coup est valide(true) ou non (false)
	 */
	@Override
	public boolean Valide(int nombre){
		if (nombre > 9 || nombre <1){
			return(false);
		}
		if (this.grid[2-(nombre-1)/3][(nombre-1)%3]  == null){
			return(true);
		}else{
			return(false);
	} 
	}
	/**
	 * Méthode permettant d'éxécuter le coup valide choisi par le joueur ou l'ordinateur
	 * @param coup est un entier, représentant le coup joué
	 */
	@Override
	public void execute(int coup){
		grid[2-(coup-1)/3][(coup-1)%3] = this.enjeu;
	}
	/**
	 * Méthode permettant d'obtenir le joueur courant
	 * @return sous forme d'un string le nom du joueur courant
	 */
	@Override
	public GamePlayer joueur(){
		return(this.enjeu);
	}
	/**
	 * Méthode permettant d'obtenir la liste des coups valides 
	 * @return sous forme d'une liste, les coup valides
	 */
	@Override
	public List<Integer> validMoves(){
		List<Integer> list = new ArrayList<> ();
		for (int i = 0; i<3 ; i++){
			for (int k = 0; k<3 ; k++){
				if (this.grid[i][k] == null){
					list.add((-i+2)*3 + k +1);
				}
			}
		}
		return(list);
	}

	/**
	 * Méthode permettant d'afficher la situation de la partie afin d'aider à l'ergonomie (ici on affiche une grille de morpion)
	 * @return un String qui est la grille de morpion actuelle
	 */
	@Override
	public String situationToString(){
		String jour = "";
		for (int i = 0; i<3 ; i++){
			for (int k = 0; k<3 ; k++){
				if (this.grid[i][k] == this.joueur1){
					jour = jour + " X ";
				}
				if (this.grid[i][k] == this.joueur2){
					jour = jour + " 0 ";
				}
				if (this.grid[i][k] == null){
					jour = jour + "   ";}
				if (k < 2){
					jour = jour + "|";}
				}
			if (i < 2){
				jour = jour + System.lineSeparator() + "---|---|---" + System.lineSeparator();
				}	
		}
		return(jour);
	}
	/**
	 * Méthode permettant d'afficher le coup joué par le joueur de manière estétique
	 * @param move est le coup valide joué par le joueur ou l'ordinateur
	 * @return un string qui est le coup joué avec cet affichage : (case : (0,0))
	 */
	@Override
	public String moveToString(Integer move){
		int d = (2-(move - 1)/3);
		int n = ((move-1)%3);
		return("Case : ("+d+","+n+")");
	}

	/**
	 * Méthode permettant de savoir si la partie est finie ou non 
	 * @return true ou false en fonction de l'accomplissement ou non de la partie
	 */
	@Override
	public boolean isOver(){
		if (this.getWinner()!=null){
			return true;
		}
		for (int i=0; i<this.grid.length;i++){
			for (int j=0; j<this.grid[i].length;j++){
				if (this.grid[i][j]==null){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Méthode permettant de connaître le véritable gagant(dans le morpion c'est celui qui joue en dernier qui a potentiellement gagné)
	 * @param zone est un GamePlayer, qui représente le joueur courant
	 * @return un GamePlayer qui est le joueur gagnant
	 */
	private GamePlayer retourwinner(GamePlayer zone){
		if(zone==null){
			return null;
		}
		else if(zone==super.joueur1){
			return super.joueur1;
		}
		return super.joueur2;
	}
	/**
	 * Méthode permettant de voir si un joueur gagne dans les colonnes de la grille
	 * @param numero est un entier, qui représente la colonne sur laquelle on va chercher le gagnant
	 * @return un GamePlayer, décidé comme gagnant, en utilisant la méthode "retourwinner", ou null s'il n'y a pas de gagnant
	 */
	private GamePlayer retourcolonne(int numero){
		GamePlayer A = this.grid[0][numero];
		for(int i=1;i<3;i++){
			if (this.grid[i][numero]!=A){
				return null;
			}
		}
		return retourwinner(A);
	}
	/**
	 * Méthode permettant de voir si un joueur gagne dans les diagonales de la grille
	 * @return un GamePlayer, décidé comme gagnant, en utilisant la méthode "retourwinner", ou null si il n'y a pas de gagnant
	 */
	private GamePlayer retourcroissement(){
		GamePlayer A = this.grid[1][1];
		if (A!=null){
			if (this.grid[0][0]==A && this.grid[2][2]==A){
				return retourwinner(A);
			}
			if (this.grid[0][2]==A && this.grid[2][0]==A){
				return retourwinner(A);
			}
		}
		return null;
	}
	/**
	 * Méthode permettant de voir si un joueur gagne dans les lignes de la grille
	 * @param numero est un entier, qui représente la ligne sur laquelle on va chercher le gagnant
	 * @return un GamePlayer, décidé comme gagnant, en utilisant la méthode "retourwinner", ou null si il n'y a pas de gagnant
	 */
	private GamePlayer retourligne(int numero){
		GamePlayer A = this.grid[numero][0];
		for(int i=1;i<3;i++){
			if (this.grid[numero][i]!=A){
				return null;
			}
		}
		return retourwinner(A);
	}
	
	/**
	 * Méthode permettant d'obtenir le nom du joueur gagnant
	 * @return le nom du gagnant est un gamePlayer si il y en a un 
	 */
	@Override
	public GamePlayer getWinner(){
		for(int i=0;i<3;i++){
			GamePlayer A = this.retourligne(i);
			if (A!=null){
				return A;
			}
			GamePlayer B = this.retourcolonne(i);
			if (B!=null){
				return B;
			}
		}
		GamePlayer A = this.retourcroissement();
		if (A!=null){
			return A;
		}
		return null;
	}
	/**
	 * Méthode permettant d'obtenir un copie du jeu actuel
	 * @return un AbstractGame, qui contient la copie du jeu actuel, les actions faites sur cette copie n'impacteront donc pas le "vrai" jeu
	 */
	@Override
	public AbstractGame getCopy(){
		TicTacToe res = new TicTacToe(super.joueur1, super.joueur2);
		res.enjeu = super.enjeu;
		for(int g = 0 ; g < 3 ; g++){
			for (int j = 0 ; j < 3 ; j++){
				res.grid[g][j] = this.grid[g][j];
			}
		}
		return(res);
	}
	
	
}	
	
