package com.test;

import java.util.ArrayList;

public abstract class Player extends Entity implements PlayerMoves {

    //TODO write out objects in the potionbag
    //TODO Exceptions när potionbag är empty

    String type; // What is your profession?
    int experiencePoints; // XP
    ArrayList<Potion> potionBag = new ArrayList<Potion>(); // bag of potions

    //Constructor  (making the variables shorter, setting XP=0 for a starter player)
    public Player(String name, String type, int spe, int str, int wis, int mp, int hp) {
        super(name, spe, str, wis, mp, hp, 0);
        this.type = type;
        this.experiencePoints = 0;
    }

    public static void toString(Player player) {
        System.out.println("* * * * * * * *");
        System.out.println("* Name: " + player.getName());
        System.out.println("* Profession: " + player.getType());
        System.out.println("* Level: " + player.getLevel() + " / 10");
        System.out.println("* HP: " + player.getHpNow() + " / " + player.getHP());
        System.out.println("* XP: " + player.getXP());
        System.out.println("* Gold: " + player.getGold());
        System.out.println("* * * * * * * *");
        System.out.println("* Speed: " + player.getSpeed());
        System.out.println("* Strength: " + player.getStrength());
        System.out.println("* Wisdom: " + player.getWisdom());
        System.out.println("* * * * * * * *");
    }

    /* Attack 1 attackerar med första vapnet*/
    @Override
    public int attack() {
            return getWeapon1().getAttackPower() + getStrength();
    }

    /* Attack 2 attackerar med andra vapnet. */
    @Override
    public int specialAttack() {
            return getWeapon2().getAttackPower() + getStrength();
    }

    /* How good you are at dodging */
    @Override
    public int defense() {
        return (getWeapon2().getDefensePower() + getSpeed())/ 2;
    }

    @Override
    public void flee() {
        System.out.println("You run for your life and gets to live another day!");
    }

    @Override
    public void drinkPotion() {

    }

    @Override
    public void levelUp() {
        System.out.println("Ding! You level up!");
        setLevel((getLevel() + 1));

        setSpeed(getSpeed() + 1);
        setStrength(getStrength() + 1);
        setWisdom(getWisdom() + 1);

        setHP(getHP() + 10);
        setHpNow(getHP());
    }


    // Getters & Setters

    public int getXP() {

        return experiencePoints;
    }

    public void setXP(int xp) {
        int lvl1 = 10;
        int lvl2 = lvl1 + 15;
        int lvl3 = lvl2 + 15;
        int lvl4 = lvl3 + 15;
        int lvl5 = lvl4 + 15;
        int lvl6 = lvl5 + 15;
        int lvl7 = lvl6 + 15;
        int lvl8 = lvl7 + 15;
        int lvl9 = lvl8 + 15;
        int lvl10 = lvl9 + 15;

        if (xp >= lvl1 && xp <= lvl2) {

        }
        this.experiencePoints = xp;
    }

    public String getType() {
        return type;
    }

}
