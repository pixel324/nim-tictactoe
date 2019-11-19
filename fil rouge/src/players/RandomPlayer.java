package players;
import games.*;

import java.util.Scanner;
import java.util.Random;
/**
 * Classe implémentant GamePlayer, et qui permet de faire joueur un joueur aléatoire
 */
public class RandomPlayer implements GamePlayer{
    /**
     * Constructeur vide du joueur aléatoire
     */
    public RandomPlayer(){
    }
    /**
     * Méthode permettant de choisir le coup joué par le joueur aléatoire, coup qui sera forcément valide
     * @param partie est le jeu auquel on joue de type AbstractGame
     * @return le coup choisi par l'ordinateur de manière aléatoire sous forme d'un entier
     */
    @Override
    public int chooseMove(AbstractGame partie){
        Random randomGenerator = new Random();
        System.out.println(partie.validMoves());
        System.out.println("Choix du coup : ");
        int kou = randomGenerator.nextInt(partie.validMoves().size());
        int choi = partie.validMoves().get(kou);
        System.out.println(choi);

        return(choi);
    }
    /**
     * Méthode permettant d'obtenir le nom du joueur aléatoirement choisi
     * @return le nom du joueur aléatoire grace a un "hashcode" sous forme d'un string
     */
    @Override
    public String toString(){
        return("Joueur aléatoire #" + this.hashCode());
    }
    
}