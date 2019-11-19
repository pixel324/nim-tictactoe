package orchestration;
import players.*;
import games.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe principale de notre programme de jeux, elle met en corrélation les arguments passés, et le type de jeux voulu ainsi que les types de joueurs.
 */
public class Demo{
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        boolean poss = false;
        if (args.length < 3 && args.length > 5 ){
            poss = true;            
        }
        else if (!args[0].toLowerCase().equals("nim") && !args[0].toLowerCase().equals("tictactoe")){
            poss = true;
        }
        int joueurnb = 0;
        if (poss == true){
            System.out.println("mettre sous la forme <jeu> <type de joueur1> <type de joueur2> <noms>");
            System.out.println("Nous acceptons pour le jeu : tictactoe ou nim");
            System.out.println("Nous accpetons pour le type de joueur : human , minmax ou aleatoire");
            throw new IllegalArgumentException("mauvais usage des arguments");
        }
        Orchestrator game = new Orchestrator();
        AbstractGame gamechoix = null;
        GamePlayer joueur1 = null;
        GamePlayer joueur2 = null;
        String role1 = args[1];
        boolean choi = false;
        while(choi == false){
            if (role1.toLowerCase().equals("minmax")){
                joueur1 = new MinMaxPlayer();
                choi = true;
            }
            else if (role1.toLowerCase().equals("human")){
                joueur1 = new Human(args[3]);
                joueurnb = joueurnb + 1;
                choi = true;
            }
            else if (role1.toLowerCase().equals("aleatoire")){
                joueur1 = new RandomPlayer();
                choi = true;
            }
            else{
                System.out.println("quel est le type du premier joueur ?");
                role1 = scanner.nextLine();
            }
        }
        choi = false;
        String role2 = args[2];
        while(choi == false){
            if (role2.toLowerCase().equals("minmax")){
                joueur2 = new MinMaxPlayer();
                choi = true;
            }
            else if (role2.toLowerCase().equals("human")){
                if (joueurnb == 1){
                    joueur2 = new Human(args[4]);
                }else{
                    joueur2 = new Human(args[3]);
                }
                choi = true;
            }
            else if (role2.toLowerCase().equals("aleatoire")){
                joueur2 = new RandomPlayer();
                choi = true;
            }
            else{
                System.out.println("quel est le type du deuxieme joueur ?");
                role2 = scanner.nextLine();
            }
        }
        choi = false;
        String jeu = args[0];
        while(choi == false){
            if (args[0].toLowerCase().equals("tictactoe")){
                gamechoix = new TicTacToe(joueur1,joueur2);
                choi = true;
            }
            else if (args[0].toLowerCase().equals("nim")){
                int alum = 0;
                int nbmax = 0;
                boolean condi = false;
                while(!condi){
                    System.out.println("Veuillez nous indiquer le nombre d'allumettes dans le tas : ");
                    String alumet = scanner.nextLine();
                    System.out.println("Veuillez nous indiquer le nombre maximum d'allumettes a enlever : ");
                    String nombreal = scanner.nextLine();
                    try{
                        alum = Integer.parseInt(alumet);
                        nbmax = Integer.parseInt(nombreal);
                        condi = true;
                    }catch(NumberFormatException error){
                        System.out.println("veuillez indiquer des valeurs decimales");
                    } 
                }
                gamechoix = new Nim(alum,nbmax,joueur1,joueur2);
                choi = true;
            }
            else{
                System.out.println("jeu non valide , veuillez donner un jeu valide : ");
                jeu = scanner.nextLine();
            }
        }
        game.playGame(gamechoix);
        
    }
}
