package com.test;

//TODO Randomgenerator that decides how much gold an archmage has. depending on level

public class Archmage extends Opponent {

    public Archmage(int gold) {
        super("Archmage", 1, 5, 7, 12, 50, 80, gold);
        weapon1 = new Weapon("Staff", "ranged attack","a long gnarled staff", 3, 3, 2);
        weapon2 = weapon1;
    }

    @Override
    public int attack() {
        System.out.println("The mage swings his staff over his head, mumbles a few words and a purple glowing ball appears and speeds towards you.");
        return weapon1.getAttackPower() + getWisdom(); //Magic users have different special attacks
    }

    @Override
    public int specialAttack() {
        System.out.println("The mage smacks you in the head with his staff");
        return super.attack();
    }

}
