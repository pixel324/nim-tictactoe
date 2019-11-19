package games;
import players.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Interface gérant les jeux présents dans le jeu
 * Elle prend 3 variables en compte qui sont toutes des GamePlayer, ici nous les utilisons en mode "protected".
 */
public abstract class AbstractGame {
	
	protected GamePlayer enjeu;
	protected GamePlayer joueur1;
	protected GamePlayer joueur2;
	/**
	 * Constructeur de la classe AbstractGame
	 * @param joueur1 représente le premier joueur
	 * @param joueur2 représente le deuxième joueur
	 */
	public AbstractGame(GamePlayer joueur1,GamePlayer joueur2){
		
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.enjeu = joueur1;
		
		}
	/**
	 * Méthode abstraite qui éxécute un coup
	 * @param coup entier représentant le coup joué
	 */
	public abstract void execute(int coup);
	/**
	 * Méthode qui change le joueur et éxécute un coup
	 * @param coup entier qui représente le coup joué
	 */
	
	public void executer(int coup){
		this.execute(coup);
		if (this.enjeu == joueur1){
			this.enjeu = joueur2;
		}else{
			this.enjeu = joueur1;
		}
	}
	/**
	 * Méthode permettant d'obtenir le joueur courant, c'est un accesseur
	 * @return renvoie le joueur courant sous la forme d'un GamePlayer
	 */
	public GamePlayer joueur(){
		return(this.enjeu);
	}
	/**
	 * Méthode abstraite permettant d'obtenir la liste des coups valides
	 * @return renvoie une liste contenant les coups valides sous la forme d'une liste
	 */
	public abstract List<Integer> validMoves();
	
	/**
	 * Méthode abstraite permettant d'obtenir la situation acutelle du jeu
	 * @return sous forme de string la situation du jeu via un affichage défini dans les instances de AbstractGame sous la forme d'un String
	 */
	public abstract String situationToString();
	
	/**
	 * Méthode abstraite permettant d'obtenir un beau affichage du coup choisi
	 * @param donne est le coup choisi
	 * @return la mise en forme du coup choisi du type : "vous avez choisi : coup choisi" sous la forme d'un String
	 */
	public abstract String moveToString(Integer donne);
	
	/**
	 * Méthode abstraite permettant de savoir si la partie est finie
	 * @return True ou False en fonction de la fin de la partie (true si elle est finie et false sinon)
	 */
	public abstract boolean isOver();

	/**
	 * Méthode abstraite permettant d'obtenir le nom du gagnant
	 * @return le nom du gagnant si il y en a un et null sinon, sous la forme d'un GamePlayer
	 */
	public abstract GamePlayer getWinner();

	/**
	 * Méthode abstraite permettant de savoir si un coup est valide ou non
	 * @param nbr est le coup joué
	 * @return	True ou False en fonction de la véracité du (si le coup est valide, true est renvoyé, false sinon)
	 */
	public abstract boolean Valide(int nbr);

	/**
	 * Méthode abstraite permettant d'obtenir une copie du jeu actuel
	 * @return la copie du jeu instancié sous la forme d'un AbstractGame
	 */
	public abstract AbstractGame getCopy();
}
