package com.test;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    /* - MAIN - startar igång spelet genom att köra de två menyerna. */
    public static void main(String[] args) {

        Player player;

        player = startMeny();
        player.setGold(+500); //TESTING SHOP
        meny(player);

    }

    /* 1 * Startmenyn som initierar spelet. */
    public static Player startMeny() {
        String name;
        Player player;

        System.out.println();
        System.out.println("Welcome to the Game");
        System.out.print("Enter your name: ");
        name = scanString();
        System.out.println("Do you want to be (1) a Decker, (2) a Spellcaster or (3) a Street Samurai?");
        player = setType(name);
        System.out.println("Congratulations runner!! " + '\n' + name + " the " + player.getType() + " is now ready to hit the streets of Neo-Tokyo");
        System.out.println();

        return player;
    }


    /* 2 * Metoden skapar en Player med typen Decker, Spellcaster eller StreetSamurai beroende på spelarens val. */
    public static Player setType(String name) {

        Player player1 = null; //Annars säger programmet att den kanske inte initierad när den skall skickas tillbaka.

        boolean noChoice = true;

        do {
            char choice = scanChar();

            if (choice == '1') {
                player1 = new Decker(name);
                noChoice = false;
            } else if (choice == '2') {
                player1 = new Spellcaster(name);
                noChoice = false;
            } else if (choice == '3') {
                player1 = new StreetSamurai(name);
                noChoice = false;
            } else {
                System.out.println("Error, try again!");
            }
        } while(noChoice == true);

        return player1;
    }


    /* 3 * Menyn som dyker upp efter varje handling är slutförd */
    public static void meny(Player player) {
        boolean noChoice = true;

        do {

            System.out.println();
            System.out.println("What do you want to do next?");
            System.out.println("1. Go on adventure");
            System.out.println("2. Look at character sheet");
            System.out.println("3. Go shopping");
            System.out.println("E. Exit the game");


            char choice = scanChar();

            if (choice == '1') {
                goOnAdventure(player);
                noChoice = true;

            } else if (choice == '2') {
                Player.toString(player);
                noChoice = true;

            } else if (choice == '3') {
                Shop.greet(player);
                noChoice = true;

            } else if (choice == 'E' || choice == 'e') {
                System.out.println("Thanks for playing!");
                noChoice = false;

            } else {
                System.out.println("Error, try again!");
            }
        } while (noChoice == true);

    }

    /* 4 * When the player chose to go on adventure and 10% of the time, nothing happens. */
    public static void goOnAdventure(Player player) {

        if ( randomDouble() < 0.1) {
             peaceful();
             // 90% chance of combat
        } else {
             System.out.println("Suddenly, a hostile creature appears!");
             pressEnter(); //Press Enter to continue
             Combat.initCombat(player);
        }
    }

    /* 5 *  Some random stuff that happens if there is no fight. */
    public static void peaceful() {

            double event = randomDouble();
            if (event < 0.2) {
                System.out.println("You walk down the roads of Neo-Tokyo looking at all the random people walking by.");
            } else if (event < 0.4) {
                System.out.println("A few pigeons lands on the ground next to you and start eating on a left over sandwich.");
            } else if (event < 0.6) {
                System.out.println("Hot steam flows up from one of the many manholes.");
            } else if (event < 0.8) {
                System.out.println("You stop for a while to take in the living city's sounds.");
            } else {
                System.out.println("Top 10 % !");
            }
            pressEnter();
    }


    // MY RANDOMS

    public static double randomDouble() {
        return rand.nextDouble();
    }

    public static int randomInt(int min, int max) {
       int randomNum = rand.nextInt((max - min) + 1) + min;
       return randomNum;
    }

    // MY SCANNERS

    /* Scannar och sparar det inskrivna värdet i en String */
    public static String scanString() {
        String input = sc.nextLine();
        return input;
    }

    /* Scannar och sparar det inskrivna värdet i en char */
    public static char scanChar() {
        char input = sc.next().charAt(0);
        return input;
    }

    /* Scannar och sparar det inskrivna värdet i en int */
    public static int scanInt() {
        int input = sc.nextInt();
        return input;
    }

    // PRESS ENTER TO CONTINUE

    public static void pressEnter() {
        System.out.println("[Press Enter to continue]");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
