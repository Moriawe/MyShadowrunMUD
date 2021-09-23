package com.test;

import java.util.ArrayList;

public abstract class Player extends Entity implements PlayerMoves {

    //TODO write out objects in the potionbag
    //TODO Exceptions när potionbag är empty

    String type;
    int experiencePoints;
    ArrayList<Potion> potionBag = new ArrayList<Potion>();

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

    @Override
    public int defense() {
        return getWeapon2().getDefensePower() + getSpeed();
    }

    @Override
    public void flee() {

    }

    @Override
    public void drinkPotion() {

    }

    @Override
    public void looseFight() {

    }

    @Override
    public void winFight() {

    }

    @Override
    public void lootGold() {

    }

    @Override
    public void goShop() {

    }

    @Override
    public void levelUp() {

    }

    // Getters & Setters

    public int getXP() {
        return experiencePoints;
    }

    public void setXP(int xp) {
        this.experiencePoints = xp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
