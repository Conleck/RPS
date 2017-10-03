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

    public static void startGame(ArrayList<Player> players){
        if(players.size()!=0){
            int active = 0;
            do{
                System.out.println("Please enter Player1's username:");
                Scanner scan = new Scanner(System.in);
                String playerOne = scan.nextLine();
                active = playerSearch(players, playerOne);
            }while(active == -1);
            int active2 = 0;
            do{
                System.out.println("Please enter Player2's username:");
                Scanner scan = new Scanner(System.in);
                String playerTwo = scan.nextLine();
                active = playerSearch(players, playerTwo);
            }while(active2 == -1);
            Game game = new Game();
            game.startGame(players.get(active), players.get(active2));
        }
    }


    public static int playerSearch(ArrayList<Player> players, String username){
        for(int x = 0; x < players.size(); x++){
            if(username == players.get(x).getName()){
                return x;
            }
        }
        return -1;
    }
}
