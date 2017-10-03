package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        menu(players);
    }

    public static void menu(ArrayList<Player> players){
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("\nPlease select from the following options:");
        System.out.println("\t1-Create Player(s)");
        System.out.println("\t2-Start a new Game");
        System.out.println("\t3-View Stats");
        System.out.println("\t4-Quit");
        Scanner scan = new Scanner(System.in);
        int optionNo = 0;
        boolean optionCorrect = false;
        while(!optionCorrect){
            try{
                optionNo = scan.nextInt();
                if(optionNo >0 && optionNo < 5){
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
                menu(players);
                break;
            case 2:
                startGame(players);
                break;
            case 3:
                showScore(players);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    public static ArrayList<Player> createPlayer(ArrayList<Player> players){
        boolean active = true;
        while(active){
            System.out.println("Please enter your desired username:");
            Scanner scan2 = new Scanner(System.in);
            String username = scan2.nextLine();
            if(playerSearch(players, username)== -1){
                players.add(new Player(username));
                System.out.println("Do you wish to add another player?:\n\ty for yes, n for no:");
                Scanner scan3 = new Scanner(System.in);
                String response = scan3.nextLine();
                if(!response.equals("y")){
                    active = false;
                    System.out.println(response);
                }
            } else{
                System.out.println("Sorry, this name belongs to an existing player");
            }
        }

        return players;
    }

    public static void showScore(ArrayList<Player> players){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Winrates:\n===================");
        for (int i = 0; i < players.size(); i++) {
            float percentage = ((float)players.get(i).getWins())/(players.get(i).getWins() + players.get(i).getLosses())*100;
            String stringPercentage = String.format("%.2f", percentage);
            System.out.println(players.get(i).getName() + " - " + stringPercentage + "%");
        }
        scanner.nextLine();
        menu(players);
    }

    public static void startGame(ArrayList<Player> players){
        if(players.size()>1){
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
                active2 = playerSearch(players, playerTwo);
                if(active == active2){
                    active2 = -1;
                    System.out.println("Player2 must not be the same as Player1.");
                }
            }while(active2 == -1);
            Game game = new Game();
            game.startGame(players.get(active), players.get(active2), players);
        }else{
            System.out.println("Please ensure both players have a username.");
            menu(players);
        }

    }


    public static int playerSearch(ArrayList<Player> players, String username){
        for(int x = 0; x < players.size(); x++){
            if(username.equals(players.get(x).getName())){
                return x;
            }
        }
        return -1;
    }
}
