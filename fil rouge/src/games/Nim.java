package games;
import players.*;

import java.util.List;
import java.util.ArrayList;
/**
 * Classe de notre jeu du nim
 * 3 variables sont intégrés, il s'agit de 3 entier représentant la taille du tas, sa taille dans le jeu et le nombre maximum d'allumettes à enlever
 */
public class Nim extends AbstractGame {
	
	private int taille;
	private int nbmax;
	private int taillecourant;
	/**
	 * Constructeur de la classe Nim 
	 * @param taille est la taille du tas pour le jeu du nim
	 * @param nbmax est le nombre maximum d'allumette que l'ont peut enlever en une fois
	 * @param joueur1 est le nom du joueur 1
	 * @param joueur2 est le nom du joueur 2 
	 */
	public Nim(int taille,int nbmax, GamePlayer joueur1,GamePlayer joueur2){
		super(joueur1,joueur2);
		this.taille = taille;
		this.nbmax = nbmax;
		this.taillecourant = taille;
	}
	/**
	 * Méthode qui permet d'obtenir la taille initiale du tas, c'est un accesseur
	 * @return la taille initiale du tas sous forme d'un entier
	 */
	public int GetInitialNbMatches(){
		return(this.taille);
	}
	/**
	 * Méthode permettant d'obtenir la taille actuelle du tas, c'est un accesseur
	 * @return la taille du tas sous forme d'un entier
	 */
	public int GetNbMatches(){
		return(this.taillecourant);
	}
	/**
	 * Méthode permettant de savoir si un coup est valide ou non
	 * @param nombre est le coup joué, sous forme d'entier
	 * @return si le coup est correct "vrai" ou incorrect "faux"
	 */
	@Override
	public boolean Valide(int nombre){
		if (nombre <= 0 || nombre > nbmax || nombre > taillecourant){
			return(false);
		}else{
			return(true);
		}
		
	}
	/**
	 * Méthode permettant d'éxécuter un coup (ici on retire le coup a la taille du tas actuel)
	 * @param coup est le coup valide qui devra etre éxécuté. C'est un entier
	 */
	@Override
	public void execute(int coup){
		this.taillecourant = this.taillecourant - coup;
	}
	/**
	 * Méthode permettant d'obtenir le nom du joueur courant
	 * @return sous forme de String le nom du joueur courant
	 */
	@Override
	public GamePlayer joueur(){
		return(this.enjeu);
	}
	/**
	 * Méthode permettant d'obtenir la liste des coup valides
	 * @return la liste des coups que le joueur peut éxécuter 
	 */
	@Override
	public List<Integer> validMoves(){
		List<Integer> list = new ArrayList<> ();
		for (int cou=1;cou<=this.nbmax;cou++){
			if(this.taillecourant-cou>=0){
				list.add(cou);
			}

		}
		return(list);
	}
	/**
	 * Méthode permettant de visualiser le déroulement du jeu
	 * @return sous forme d'une String, le déroulement du jeu, avec un "bel" affichage
	 */
	@Override
	public String situationToString(){
		return("Il reste "+this.taillecourant+" alumettes.");
	}
	/**
	 * Méthode permettant de visualiser le coup joué
	 * @param donne est le coup joué sous forme d'un entier
	 * @return de manière "estétique" le coup joué sous forme de String
	 */
	@Override
	public String moveToString(Integer donne){
		return("Vous avez choisi : "+donne);
	}
	/**
	 * Méthode permettant de savoir si la partie est finie ou non
	 * @return sous forme d'un bouléen, true ou false en fonction de la fin ou non de la partie
	 */
	@Override
	public boolean isOver(){
		if (this.taillecourant <= 0){
			return(true);
		}else{
			return(false);
		}
	}
	/**
	 * Méthode permettant d'obtenir le nom du joueur gagnant
	 * @return un String qui désigne le nom du joueur gagnant, ou null si il n'y a pas de gagnants
	 */
	@Override
	public GamePlayer getWinner (){
		if(this.taillecourant <= 0){
			return(this.enjeu);
		}else{
			return(null);
		}
	}
	/**
	 * Méthode permettant de copier le jeu au moment demandé et non le jeu initial
	 * @return un AbstractGame qui représente le jeu.
	 */
	@Override
	public AbstractGame getCopy(){
		Nim res = new Nim(this.taille,this.nbmax, this.joueur1,this.joueur2);
		res.taillecourant = this.taillecourant;
		res.enjeu = this.enjeu;
		return res;
	}
}
