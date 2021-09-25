package com.test;

import java.util.ArrayList;

public abstract class Player extends Entity implements PlayerMoves {

    //TODO write out objects in the potionbag
    //TODO Exceptions när potionbag är empty
    //TODO When used the potion should be removed. Needs to have a method of its own. Contains!!

    String type; // What is your profession?
    int experiencePoints; // XP
    ArrayList<Potion> potionBag; // bag of potions

    //Constructor  (making the variables shorter, setting XP=0 for a starter player)
    public Player(String name, String type, int spe, int str, int wis, int mp, int hp) {
        super(name, spe, str, wis, mp, hp, 0);
        potionBag = new ArrayList<>();
        this.type = type;
        this.experiencePoints = 0;
    }

    //TODO Make it show how much xp needed for next level
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
    public void drinkPotion(String potionType) {

        for (Potion potion : potionBag) {
            if (potion.getType().contains(potionType)) {
                potion.usePotion(this);
                potionBag.remove(potion);
                return;
            }
        }
        System.out.println("You don't have any " + potionType + " potions.");
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

    public String getType() {
        return type;
    }

}
