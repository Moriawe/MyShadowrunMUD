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

    /* Attack 1 attacks with weapon1 */
    @Override
    public int attack() {
            return getWeapon1().getAttackPower() + getStrength();
    }

    /* Attack 2 attacks with your weapon2 */
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

    /* When you level up you get +1 on Speed, Strength and Wisdom. You also get +10 HP and regain all lost HP. */
    @Override
    public void levelUp() {
        System.out.println("Ding! You level up! (and get all HP back)");
        setLevel((getLevel() + 1));

        setSpeed(getSpeed() + 1);
        setStrength(getStrength() + 1);
        setWisdom(getWisdom() + 1);

        setHP(getHP() + 10);
        setHpNow(getHP()); //When you level up you get all your HP back. Remove this line if you don't like that.
    }

    /* I use addXP instead of setXP */
    public void addXP(int xp) {

        this.experiencePoints += xp;
    }

    // Getters & Setters

    public int getXP() {

        return experiencePoints;
    }

    public void setXP(int xp) {
        this.experiencePoints = xp;
    }

    /* My leveling system.
        int lvl1 = 10;
        int lvl2 = lvl1 + 15;
        int lvl3 = lvl2 + 20;
        int lvl4 = lvl3 + 25;
        int lvl5 = lvl4 + 30;
        int lvl6 = lvl5 + 35;
        int lvl7 = lvl6 + 40;
        int lvl8 = lvl7 + 45;
        int lvl9 = lvl8 + 50;
        int lvl10 = lvl9 + 60;

        if (getLevel() == 1 && this.experiencePoints + xp >= lvl2) {
            levelUp();

        } else if (getLevel() == 2 && this.experiencePoints + xp >= lvl3) {
            levelUp();

        } else if (getLevel() == 3 && this.experiencePoints + xp >= lvl4) {
            levelUp();

        } else if (getLevel() == 4 && this.experiencePoints + xp >= lvl5) {
            levelUp();

        } else if (getLevel() == 5 && this.experiencePoints + xp >= lvl6) {
            levelUp();

        } else if (getLevel() == 6 && this.experiencePoints + xp >= lvl7) {
            levelUp();

        } else if (getLevel() == 7 && this.experiencePoints + xp >= lvl8) {
            levelUp();

        } else if (getLevel() == 8 && this.experiencePoints + xp >= lvl9) {
            levelUp();

        } else if (getLevel() == 9 && this.experiencePoints + xp >= lvl10) {
            levelUp();
        }*/


    public String getType() {
        return type;
    }

}
