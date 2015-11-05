
package quiz3;

import java.util.Scanner;

/**
 * @author Kristina Kolesar
 */
public class Quiz3 {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int player = 0;
        int wins = 0;
        int losses = 0;
        int ties = 0;
        int computer;
        int last = 2;
        int last_play = 0;
        int prev = 0;
        int third = 0;
        
        final int WIN = 1;
        final int LOSE = 0;
        final int TIE = 2;
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSORS = 3;
        
        // Display Menu
        while (player != 4)
        {
        System.out.println("Rock, Paper, Scissors!");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println("4. Quit");
        System.out.print("Please enter the number of your choice:");
        player = input.nextInt();
        
        // Validate player input
        while (player < 0 || player > 4)
        {
            System.out.println("That's an invalid choice. Please enter 1, 2, 3, or 4.");
            player = input.nextInt();
        }
        
        //Formatting space
            System.out.println("");
                   
            
            // Get computer choice
                     
            // IF LAST 3 ROUNDS SAME
            if ((prev==last_play) && (prev == third))
            {
                computer = 1+ (int)(Math.random() * 3);
                    while (third == SCISSORS && computer == ROCK)
                    {
                        computer = 1+ (int)(Math.random() * 3);
                        System.out.println("" + computer);
                    }
                    while (third == PAPER && computer == SCISSORS)
                    {
                        computer = 1+ (int)(Math.random() * 3);
                        System.out.println("" + computer);
                    }
                    while (third == ROCK && computer == PAPER)
                    {
                        computer = 1+ (int)(Math.random() * 3);
                        System.out.println("" + computer);
                    }
            }
            
            // IF LAST 2 ROUNDS SAME
            else if (prev == last_play)
                if (last_play == ROCK)
                    computer = PAPER;
                else if (last_play == PAPER)
                    computer = SCISSORS;
                else
                    computer = ROCK;
                       
            // THROW BASED OFF WIN/LOSS AND LAST ROUND
            else if (last == WIN)
                if (last_play == SCISSORS)
                computer = ROCK;
                else if (last_play == PAPER)
                computer = SCISSORS;
                else
                computer = PAPER;
            
            else if (last == TIE)
                if (last_play == ROCK)
                    computer = PAPER;
                else if (last_play == PAPER)
                    computer = SCISSORS;
                else 
                    computer = ROCK;
            
            else 
                if (last_play == ROCK)
                    computer = SCISSORS;
                else if (last_play == PAPER)
                    computer = ROCK;
                else 
                    computer = PAPER;
            
                  // Evaluate player choice
            switch (player) {
                case 1:
                    System.out.println("You chose Rock!");
                    third = prev;
                    prev = last_play;
                    last_play = ROCK;
                    break;
                case 2:
                    System.out.println("You chose Paper!");
                    third = prev;
                    prev = last_play;
                    last_play = PAPER;
                    break;
                case 3:
                    System.out.println("You chose Scissors!");
                    third = prev;
                    prev = last_play;
                    last_play = SCISSORS;
                    break;
                case 4:
                    System.out.println("Quitting the Program.");
                    System.exit(0);
                    break;

            }
            
            // Display computer's choice
            if (computer == ROCK)
                System.out.println("The computer chose Rock");
            else if (computer == PAPER)
                System.out.println("The computer chose Paper");
            else
                System.out.println("The computer chose Scissors");
            
            // Evaluate winner
            
            if (player == computer)
            {
                System.out.println("The game is a Tie!\n");
                last = TIE;
                ties++;
            }
            else if ((player == 1 && computer == 2)||
                    (player == 2 && computer == 3)||
                    (player == 3 && computer == 1)) 
            {
                    System.out.println("You lose.\n");
                    last = LOSE;
                    losses++;
            }
            else
            {
                System.out.println("You win!\n");
                last = WIN;
                wins++;
            }
            
            System.out.println("Wins:" + wins);
            System.out.println("Losses: " + losses);
            System.out.println("Ties: " + ties);
        }
       
    }
}
