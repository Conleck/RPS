package com.company;

import java.util.Scanner;

public class Player {
    private String name;
    private int wins, losses;

    public Player(String name){
        this.name = name;
        wins = 0;
        losses = 0;
    }

    public static void createPlayer(){
        System.out.println("Please enter your desired username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        Player player1 = new Player(username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void win(){
        wins++;
    }
    public void loss(){
        losses++;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}


