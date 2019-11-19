package players;
import games.*;

import java.util.Scanner;
/**
 * Classe implémentant GamePlayer et permettant de gérer le joueur humain
 */
public class Human implements GamePlayer{

    private String name;

    /**
     * Constructeur de la classe Human
     * @param name est un String qui représente le nom du joueur humain
     */
    public Human(String name){
        this.name = name;
    }
    /**
     * Méthode qui redéfinis chooseMoove, tout en regardant si un coup est valide ou non et qui affiche la liste des coups valides
     * @param partie est un objet de type AbstractGame ( une partie ) qui représente la partie joué(nim ou tictactoe)
     * @return un entier qui représente le coup joué après le choix du joueur humain
     */
    @Override
    public int chooseMove(AbstractGame partie){
        System.out.println(partie.validMoves());
        System.out.println("Choix du coup : ");
        Scanner scan = new Scanner(System.in);
        String kou = "0";
        boolean boubou =false;
        while(partie.Valide(Integer.parseInt(kou)) == false){
            try{
                kou = scan.nextLine();
                int a = Integer.parseInt(kou);
                if (boubou == true){
                    System.out.println("Veuillez choisir un nombre valide");
                }
            }catch(NumberFormatException error){
                System.out.println("Veuillez choisir un nombre valide");
                kou = "0";
            }
            boubou = true;
        }
        return(Integer.parseInt(kou));
    }
    /**
     * Méthode qui redéfinis toString, et qui permet d'obtenir le nom de l'humain
     * @return sous forme d'un String le nom de l'humain
     */
    @Override
    public String toString(){
        return(this.name);
    }
    
}