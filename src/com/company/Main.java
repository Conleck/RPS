package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("\nPlease select from the following options:");
        System.out.println("\t1-Create Player(s)");
        System.out.println("\t2-Start a new Game");
        System.out.println("\t3-View Stats");
        Scanner scan = new Scanner(System.in);
        int optionNo = 0;
        boolean optionCorrect = false;
        while(!optionCorrect){
            try{
                optionNo = scan.nextInt();
                if(optionNo >0 && optionNo < 4){
                    optionCorrect=true;
                }
                else{
                    System.out.println("Please enter a valid option:");
                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid option:");
            }
        }
        switch(optionNo){
            case 1:
                players = createPlayer(players);
                break;
        }
    }

    public static ArrayList<Player> createPlayer(ArrayList<Player> players){
        boolean active = true;
        while(active){
            System.out.println("Please enter your desired username:");
            Scanner scan2 = new Scanner(System.in);
            String username = scan2.nextLine();
            players.add(new Player(username));
            System.out.println("Do you wish to add another player?:\n\ty for yes, n for no:");
            Scanner scan3 = new Scanner(System.in);
            if(scan3.nextLine()!="y"){
                active = false;
            }
        }

        return players;
    }

    public static void showScore(){
        System.out.println("Scoreboard:\n===================");
        System.out.println("");

    }

    public static void startGame(Player Player1, Player Player2){

    }
}
