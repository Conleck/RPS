package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public static void startGame(Player Player1, Player Player2, ArrayList<Player> players) {
        boolean rematch;
        do {
            rematch = false;
            System.out.println("Lets go boiiis\n");
            System.out.println("Controls:\n\t-1 Rock\n\t-2 Paper\n\t-3 Scissors");
            int onePick = 0, twoPick = 0;
            System.out.println(Player1.getName() + " Go!! " + Player2.getName() + " Look Away!\nPress either 1,2 or 3:");
            Scanner scan = new Scanner(System.in);
            boolean correctMove = false;
            while (!correctMove) {
                try {
                    onePick = scan.nextInt();
                    if (onePick > 0 && onePick < 4) {
                        correctMove = true;
                    } else {
                        System.out.println("Please enter a number between 1 and 3");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter a number of 1-3");
                }
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println(Player2.getName() + " Go!! " + Player1.getName() + " Look Away!\nPress either 1,2 or 3:");
            Scanner scan2 = new Scanner(System.in);
            boolean correctMove2 = false;
            while (!correctMove2) {
                try {
                    twoPick = scan2.nextInt();
                    if (twoPick > 0 && twoPick < 4) {
                        correctMove2= true;
                    } else {
                        System.out.println("Please enter a number between 1 and 3");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter a number of 1-3");
                }
            }

            if (onePick == 1) {
                switch (twoPick) {
                    case 1:
                        rematch = true;
                        System.out.println("It's a draw! Lets go again!\n");
                        break;
                    case 2:
                        System.out.println(Player2.getName() + " Wins!\n");
                        Player1.loss();
                        Player2.win();
                        break;
                    case 3:
                        System.out.println(Player1.getName() + " Wins!\n");
                        Player1.win();
                        Player2.loss();
                        break;
                    default:
                        System.out.println("Something went wrong! Lets try again");
                        rematch = true;
                        break;
                }
            }else if (onePick == 2){
                switch (twoPick) {
                    case 1:
                        System.out.println(Player1.getName() + " Wins!\n");
                        Player1.win();
                        Player2.loss();
                        break;
                    case 2:
                        System.out.println("It's a draw! Lets go again!\n");
                        rematch = true;
                        break;
                    case 3:
                        System.out.println(Player2.getName() + " Wins!\n");
                        Player1.loss();
                        Player2.win();
                        break;
                    default:
                        System.out.println("Something went wrong! Lets try again");
                        rematch = true;
                        break;
                }
            } else if (onePick == 3){
                switch (twoPick) {
                    case 1:
                        System.out.println(Player2.getName() + " Wins!\n");
                        Player1.loss();
                        Player2.win();
                        break;
                    case 2:
                        System.out.println(Player1.getName() + " Wins!\n");
                        Player1.win();
                        Player2.loss();
                        break;
                    case 3:
                        System.out.println("It's a draw! Lets go again!\n");
                        rematch = true;
                        break;
                    default:
                        System.out.println("Something went wrong! Lets try again");
                        rematch = true;
                        break;
                }
            } else {
                System.out.println("Something went wrong! Lets try again");
                rematch = true;
            }
        }while(rematch);

        Main.menu(players);
    }
}
