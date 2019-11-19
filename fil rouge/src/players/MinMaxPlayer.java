package players;
import games.*;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
/**
 * Notre classe implémentant GamePlayer, qui génère un joueur intelligent via un algorithme
 */

public class MinMaxPlayer implements GamePlayer{
    /**
     * Constructeur vide de note classe MinMaxPlayer
     */
    public MinMaxPlayer(){

    }
    /**
     * Redéfinition de notre methode ChooseMove, qui nous permet de choisir un coup
     * @param partie 
     * @return 
     */
    @Override
    public int chooseMove(AbstractGame partie){
        return(negamax(partie,partie.joueur()));
    }
    /**
     * Méthode permettant de nous donner le meilleur coup à jouer
     * @param partie est un AbstractGame qui représente la partie jouée (nim ou tictactoe)
     * @param a est un GamePlayer qui représente l'ordinateur
     * @return un entier représentant le meilleur coup à jouer
     */
    public int negamax(AbstractGame partie,GamePlayer a){
        int meilleurCoup = 0;
        int meilleureValeur = -100;
        List<Integer> liste;
        liste = partie.validMoves();
        for (Integer c:liste){
            AbstractGame lo = partie.getCopy();
            lo.executer(c);
            GamePlayer j = lo.joueur();
            int v = -evaluer(lo,j);
            if (v > meilleureValeur){
                meilleureValeur = v;
                meilleurCoup = c;
            }
        }
        return(meilleurCoup);
    }
    /**
     * Méthode permettant de simuler un jeu, afin d'obtenir toutes les possibilités de jeu
     * @param a est un AbstractGame qui représente la partie en cours
     * @param b est un GamePlayer qui représente l'ordinateur
     * @return un entier représentant le potentiel coup à jouer
     */
    public int evaluer(AbstractGame a,GamePlayer b){
        GamePlayer c = a.getWinner();
        if (a.isOver()==true){
            if (c == (b)){
                return 1;
            }
            else if (c!=null){
                return -1;
            }
            return 0;
        }
        
        else {
            int res = -100;
            int act;
            for(Integer d: a.validMoves()){
                AbstractGame lo = a.getCopy();
                lo.executer(d);
                GamePlayer j = lo.joueur();
                act = -evaluer(lo,j);
                if (res<act){
                    res = act;
                }
            }
            return res;
        }
    }
    /**
     * Méthode permettant de redéfinir "ToString" afin de donner un nom au joueur minmax
     * @return un String qui nous donne le nom du joueur aléatoire grâce à un hashcode
     */
    @Override
    public String toString(){
        return("Joueur MinMax #" + this.hashCode());
    }


}
