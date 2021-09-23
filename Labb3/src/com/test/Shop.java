package com.test;

import java.util.ArrayList;

public class Shop {

    //TODO Do while loopen i storen?
    //TODO Also, do he have a stock that can run out?
    //TODO Lägga in saker i players potionbag snarare än att dricka det direkt.

    ArrayList<Potion> stockOfPotions = new ArrayList<Potion>(); //The stock of potions in the store.
    ArrayList<Weapon> stockOfWeapons = new ArrayList<Weapon>(); //The stock of weapons in the store.
    static int treasure; //The amount of money the store has.


    public static void greet(Player player) {
        player = player;
        char choice;
        boolean noChoice = true;

        System.out.println();
        System.out.println("You are greeted by a small goblinlike man, he bows and says: ");
        System.out.println("Welcome to my shop! What can I help you with?");
        System.out.println();

        do {

            System.out.println("I want to buy: ");
            System.out.println("(1) a healing potion - 100 gold");
            System.out.println("(2) a strength potion - 100 gold");
            System.out.println("(3) a speed potion - 100 gold");
            System.out.println("(4) a wisdom potion - 100 gold");
            System.out.println("(E) Exit the shop");

            choice = Main.scanChar();

            if (player.getGold() >= 100) {

                if (choice == '1') {
                    System.out.println("Ah, a healing potion, they could come in very handy indeed!");
                    player.potionBag.add(new HealingPotion());
                    //System.out.println("You are handed a red shining bottle and put it in your bag.");
                    player.potionBag.get(0).usePotion(player); //TODO When used the potion should be removed. Needs to have a method of its own. ALSO it can't be added over MAX HP. Contains!!
                    buyItems(100, player);
                    noChoice = true;
                } else if (choice == '2') {
                    System.out.println("Strength potion, the citys finest I assure you.");
                    player.potionBag.add(new StrengthPotion());
                    //System.out.println("You are handed a bottle with a blue liquid in it and put it in your bag.");
                    player.potionBag.get(0).usePotion(player);
                    buyItems(100, player);
                    noChoice = true;
                } else if (choice == '3') {
                    System.out.println("a speed potion you say? Let me see...");
                    player.potionBag.add(new SpeedPotion());
                    //System.out.println("You are handed a small bottle with a green substance and put it in your bag.");
                    player.potionBag.get(0).usePotion(player);
                    buyItems(100, player);
                    noChoice = true;
                } else if (choice == '4') {
                    System.out.println("Wisdom potion? Want to feel clever hu?");
                    player.potionBag.add(new WisdomPotion());
                    //System.out.println("You are handed a bottle with something black and thick in it and put it in your bag.");
                    player.potionBag.get(0).usePotion(player);
                    buyItems(100, player);
                    noChoice = true;
                } else if (choice == 'E' || choice == 'e') {
                    System.out.println("Bye bye now, please come again!");
                    noChoice = false;
                } else {
                    System.out.println("Sorry, I didn't quite hear you there, could you please repeat that?");
                    noChoice = true;
                }

            } else {
                    System.out.println("Do you dare come in here without enough gold?! Get out!");
                    noChoice = false;
                }


        } while(noChoice == true);
    }


    public void sellItems() {

    }

    //Method withdraws the amount of gold from the players stash and adds to the stores treasure.
    public static void buyItems(int gold, Player player) {
       player.setGold(player.getGold() - gold);
       treasure += gold;
    }


    public void getStock() {
        for (int i = 0; i < stockOfPotions.size(); i++ ) {
         //TODO Needs to sort through and add the stock for 4 different potions.
        }
        for (int i = 0; i < stockOfWeapons.size(); i++ ) {
            //TODO Needs to sort through and add the stock for different weapons.
        }

    }


}
