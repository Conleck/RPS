package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


    }

    public static void showScore(){
        System.out.println("Scoreboard:\n===================");
        System.out.println("");

    }

    public static void startGame(Player Player1, Player Player2){
        System.out.println("Lets go boiiis\n");
        System.out.println("Controls:\n\t-1 Rock\n\t-2 Paper\n\t-3 Scissors");
        int onePick =0, twoPick=0;
        System.out.println(Player1.getName() + " Go!! " + Player2.getName() + " Look Away!\nPress either 1,2 or 3:");
        Scanner scan = new Scanner(System.in);
        onePick = scan.nextInt();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println(Player2.getName() + " Go!! " + Player1.getName() + " Look Away!\nPress either 1,2 or 3:");
        twoPick = scan.nextInt();
    }

    public static void createPlayer(){


        Player
    }
}
