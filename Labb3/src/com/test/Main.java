package com.test;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static Opponent opponent;

    /* - MAIN - startar igång spelet genom att köra de två menyerna. */
    public static void main(String[] args) {

        Player player;

        player = startMeny();
        player.setGold(+500); //TESTING SHOP
        meny(player);

    }

    /* 1 * Startmenyn som inititerar spelet. */
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


        public static void outOfTheHouse() {
            System.out.println("“It's a dangerous business, Frodo, going out your door. You step onto the road, and if you don't keep your feet, there's no knowing where you might be swept off to.”");
        }

        public static void goOnAdventure(Player player) {

            // 10% chance that nothing happens.
            // nextDouble returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
            if ( randomDouble() < 0.1) {
                peaceful();
                // 90% chance of combat
            } else {
                System.out.println("Suddenly, a hostile creature appears!");
                pressEnter(); //Press Enter to continue
                initCombat(player);
            }
        }

    /* 4 *  Combat between a player and an opponent. The player is taken in as an argument while the opponent is freshly created for just this combat session. */
    public static void initCombat(Player player) {  //TODO I made the opponent a classvariable, dunno if good. If it works, why not player as one to?

        Double rand = randomDouble();

        if (rand < 0.3) {
            opponent = new Dog(randomInt(0, 5)); // Making a new dog, with between 0 - 5 gold
        } else if (rand < 0.6) {
            opponent = new Thug(randomInt(10, 25)); // Making a new thug, with between 10 - 25 gold
        } else if (rand < 0.9) {
            opponent = new Archmage(randomInt(20, 50)); // Making a new archmage, with between 20 - 50 gold
        } else {
            opponent = new EpicMonster(randomInt(50, 200)); // Making a new epicMonster, with between 50 - 200 gold
        }

        System.out.println("It is a " + opponent.getName());

        combatMeny(player, opponent);
    }


    /* 5 * This is the combatmenu that pops up between every beating. */
    public static void combatMeny(Player player, Opponent opponent) {

        boolean noChoice;

        do {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Attack!");
            System.out.println("2. Special attack!");
            System.out.println("3. Drink a potion.");
            System.out.println("4. Flee!");
            System.out.println("E. Exit the game.");
            System.out.println();

            char choice = scanChar();

            switch (choice) {
                case '1':
                    firstAttack(player, opponent);
                    oppFirstAttack(player, opponent);
                    noChoice = false; // I want to fight now and then come back to this menu
                    break;
                case '2':
                    secondAttack(player, opponent);
                    oppSecondAttack(player, opponent);
                    noChoice = false; // I want to fight now and then come back to this menu
                    break;
                case '3':
                    player.drinkPotion();
                    noChoice = false; // I want to come back to this meny after drinking a potion
                    break;
                case '4':
                    player.flee();
                    noChoice = true; // I want to run and leave this menu.
                    break;
                case 'E':
                    System.out.println("Thanks for playing!");
                    noChoice = true; // I want to quit the game and leave this menu.
                    break;
                case 'e':
                    System.out.println("Thanks for playing!");
                    noChoice = true; // I want to quit the game and leave this menu.
                    break;
                default:
                    System.out.println("Error, try again!");
                    noChoice = false; // Something wrong happened, and we are going to run the menu again.
                    break;
            }
        } while (noChoice = false);

    }

    /* Player attacks */
    public static void firstAttack(Player player, Opponent opponent) {
        int oppDodge;
        int playerDam;

        playerDam = player.attack();
        System.out.println("You do " + playerDam + " damage.");
        oppDodge = opponent.defense();
        System.out.println("The " + opponent.getName() + " dodges for " + oppDodge + " points");
        opponent.setHpNow(playerDam - oppDodge); // Amount of damage done minus the dodgepoints
    }

    /* Player special attacks */
    public static void secondAttack(Player player, Opponent opponent) {
        int oppDodge;
        int playerDam;

        playerDam = player.specialAttack();
        System.out.println("You do " + playerDam + " damage.");
        oppDodge = opponent.defense();
        System.out.println("The " + opponent.getName() + " dodges for " + oppDodge + " points");
        opponent.setHpNow(playerDam - oppDodge);
    }

    /* Opponent attacks */
    public static void oppFirstAttack(Player player, Opponent opponent) {
        int oppDam;
        int playerDodge;

        oppDam = opponent.attack();
        System.out.println("The " + opponent.getName() + " does " + oppDam + " damage to you");
        playerDodge = player.defense();
        System.out.println("You dodge for " + playerDodge + " points.");
        player.setHpNow(oppDam - playerDodge);
    }

    /* Opponent special attacks */
    public static void oppSecondAttack(Player player, Opponent opponent) {
        int oppDam;
        int playerDodge;

        oppDam = opponent.specialAttack();
        System.out.println("The " + opponent.getName() + " does " + oppDam + " damage to you");
        playerDodge = player.defense();
        System.out.println("You dodge for " + playerDodge + " points.");
        player.setHpNow(oppDam - playerDodge);
    }


    public static void peaceful() {

            double event = randomDouble();
            if (event < 0.2) {
                System.out.println("You walk down the roads of Neo Tokyo looking at all the random people walking by.");
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
