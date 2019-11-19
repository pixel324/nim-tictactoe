package orchestration;
import players.*;
import games.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe permettant l'ochestration de tout les packages
 */
public class Orchestrator{
    /**
     * Constructeur de notre orchestrator, il est vide
     */
    public Orchestrator(){
    }

    /**
     * Méthode permettant de joueur une partie du jeu passé en argument
     * @param partie est un AbstractGame qui représente le type de jeu auquel on va jouer (nim , tictactoe...etc)
     */
    static void playGame(AbstractGame partie){
        Scanner scanner = new Scanner(System.in);
        while(partie.isOver() != true) {
          System.out.println("Au tour de " + partie.joueur());
          System.out.println(partie.situationToString());
          int kou = partie.joueur().chooseMove(partie);
          System.out.println(partie.moveToString(kou));
          partie.executer(kou);
          if(partie.isOver() == true){
              if (partie.getWinner() == null && partie.isOver() == true){
                  System.out.println("partie nulle");
              }else{
                  System.out.println("Partie finie , " + partie.getWinner()+ " gagne");
                  System.out.println(partie.situationToString());
              }
          }

        }
        scanner.close();
    }
    
}