package com.test;

//TODO Randomgenerator that decides how much gold an archmage has. depending on level

public class EpicMonster extends Opponent {

    Weapon staff;

    public EpicMonster(int gold) {
        super("Archmage", 5, 15, 20, 15, 100, 200, gold);
        staff = new Weapon("Staff", "ranged attack","a long gnarled staff", 3, 3, 2);
    }

    @Override
    public int attack() {
        System.out.println("The mage swings his staff over his head, mumbles a few words and a purple glowing ball appears and speeds towards you.");
        int totalAttackPower = staff.getAttackPower() + getWisdom(); //I could write it all in the return state but this is easier to read.
        return totalAttackPower;
    }

    @Override
    public int specialAttack() {
        System.out.println("The mage smacks you in the head with his staff");
        int totalAttackpower = staff.getAttackPower() + getStrength();
        return totalAttackpower;
    }

    @Override
    public void flee() {

    }

    @Override
    public void heal() {

    }

    @Override
    public void looseFight() {

    }

    @Override
    public void winFight() {

    }
}
