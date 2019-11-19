package players;
import games.*;
/**
 * Notre interface qui gère tout les types de joueurs
 */

public interface GamePlayer{
     /**
      * Méthode permettant de choisir un coup
      * @param partie est un objet de type AbstractGame , donc une partie
      * @return un entier qui est le coup valide.
      */
    public int chooseMove(AbstractGame partie);
}