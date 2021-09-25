package com.test;

import java.util.ArrayList;

public class Combat {

    /* 6 *  Combat between a player and an opponent. The player is taken in as an argument while the opponent is freshly created for just this combat session. */
    public static void initCombat(Player player) {
        Opponent opponent;

        Double rand = Main.randomDouble();

        if (rand < 0.3) {
            opponent = new Dog(Main.randomInt(0, 5)); // Making a new dog, with between 0 - 5 gold
        } else if (rand < 0.6) {
            opponent = new Thug(Main.randomInt(10, 25)); // Making a new thug, with between 10 - 25 gold
        } else if (rand < 0.9) {
            opponent = new Archmage(Main.randomInt(20, 50)); // Making a new archmage, with between 20 - 50 gold
        } else {
            opponent = new EpicMonster(Main.randomInt(50, 200)); // Making a new epicMonster, with between 50 - 200 gold
        }

        System.out.println("It is a " + opponent.getName());

        combatMeny(player, opponent);
    }


    /* 7 * This is the combatmenu that pops up between every beating. */
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

            char choice = Main.scanChar();

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
                    checkBag(player);
                    noChoice = false; // I want to come back to this meny after drinking a potion
                    break;
                case '4':
                    player.flee();
                    noChoice = true; // I want to run and leave this menu.
                    break;
                default:
                    System.out.println("Error, try again!");
                    noChoice = false; // Something wrong happened, and we are going to run the menu again.
                    break;
            }

            // If you get killed it is GAME OVER
            if (player.getHpNow() <= 0) {
                System.out.println();
                System.out.println("You were killed by the " + opponent.getName());
                Main.pressEnter();
                noChoice = true;
                System.exit(0);

                // If you kill the opponent you loot it's gold AND you get XP!
            } else if (opponent.getHpNow() <= 0) {
                int xp = 10; //TODO do certain mobs give different xp?
                System.out.println();
                System.out.println("You killed the " + opponent.getName() + " and gained " + xp + "Xp!");
                System.out.println("You found " + opponent.getGold() + " gold !! ");
                player.setGold(player.getGold() + opponent.getGold());
                Level.checkLevel(player, xp);
                player.addXP(xp);
                noChoice = true;

                // If noone gets killed the fight continues...
            } else {
                System.out.println();
                System.out.println(player.getName() + ": " + player.getHpNow() + " / " + player.getHP());
                System.out.println(opponent.getName() + ": " + opponent.getHpNow() + " / " + opponent.getHP());
            }

        } while (noChoice == false);

    }

    //TODO Can I make these 4 into ONE singel method?

    /* Player attacks */
    public static void firstAttack(Player player, Opponent opponent) {
        int oppDodge;
        int playerDam;

        playerDam = player.attack();
        System.out.println("You do " + playerDam + " damage.");
        oppDodge = opponent.defense();
        System.out.println("The " + opponent.getName() + " dodges for " + oppDodge + " points");
        opponent.setHpNow(opponent.getHpNow() - (playerDam - oppDodge)); // Amount of damage done minus the dodgepoints
    }

    /* Player special attacks */
    public static void secondAttack(Player player, Opponent opponent) {
        int oppDodge;
        int playerDam;

        playerDam = player.specialAttack();
        System.out.println("You do " + playerDam + " damage.");
        oppDodge = opponent.defense();
        System.out.println("The " + opponent.getName() + " dodges for " + oppDodge + " points");
        opponent.setHpNow(opponent.getHpNow() - (playerDam - oppDodge));
    }

    /* Opponent attacks */
    public static void oppFirstAttack(Player player, Opponent opponent) {
        int oppDam;
        int playerDodge;

        oppDam = opponent.attack();
        System.out.println("The " + opponent.getName() + " does " + oppDam + " damage to you");
        playerDodge = player.defense();
        System.out.println("You dodge for " + playerDodge + " points.");
        player.setHpNow(player.getHpNow() - (oppDam - playerDodge));
    }

    /* Opponent special attacks */
    public static void oppSecondAttack(Player player, Opponent opponent) {
        int oppDam;
        int playerDodge;

        oppDam = opponent.specialAttack();
        System.out.println("The " + opponent.getName() + " does " + oppDam + " damage to you");
        playerDodge = player.defense();
        System.out.println("You dodge for " + playerDodge + " points.");
        player.setHpNow(player.getHpNow() - (oppDam - playerDodge));
    }

    /* Checks Players bag for potions and gives the option to drink one */
    public static void checkBag(Player player) {
        System.out.println("You look in your bag for a fitting potion...");
        if (player.potionBag.isEmpty()) {
            System.out.println("... it seems you are all out.");
        } else
            checkNumberOfPotions(player.potionBag);
            System.out.println("Which one do you want to drink?");
            System.out.println("(1) Healing (2) Speed (3) Strength (4) Wisdom");

            char choice = Main.scanChar();

            switch (choice) {
                case '1':
                    player.drinkPotion("Healing");
                    break;
                case '2':
                    player.drinkPotion("Speed");
                    break;
                case '3':
                    player.drinkPotion("Strength");
                    break;
                case '4':
                    player.drinkPotion("Wisdom");
                    break;
                default:
            }
    }

    /* Goes through potionBag and sees which potions it contains */
    public static void checkNumberOfPotions(ArrayList<Potion> potionBag){

        int wisdom = 0;
        int speed = 0;
        int strength = 0;
        int healing = 0;


        for (int i = 0; i < potionBag.size(); i++) {
            if (potionBag.get(i).getType().contains("Wisdom")) {
                wisdom += 1;
            } else if (potionBag.get(i).getType().contains("Speed")) {
                speed += 1;
            } else if (potionBag.get(i).getType().contains("Strength")) {
                strength += 1;
            } else if (potionBag.get(i).getType().contains("Healing")) {
                healing += 1;
            }
        }

        System.out.println("You have \n"
                + healing + " Healing potions \n"
                + speed + " Speed potions \n"
                + strength + " Strength potions \n"
                + wisdom + " Wisdom potions");

    }

}
