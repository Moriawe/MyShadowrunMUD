package com.test;

public class Spellcaster extends Player {

    public Spellcaster(String name) {
        super(name, "Spellcaster",5, 7, 10, 50, 70);
        weapon1 = new Weapon("staff", "ranged/melee", "A long gnarled staff with technoshit on", 2, 2, 0);
        weapon2 = weapon1;

    }

    @Override
    public int attack() {
        System.out.println("You smack it in the head with your staff");
        return super.attack();
    }

    @Override
    public int specialAttack() {
        System.out.println("You mumble som arcane words and a purple ball appears in thin air and goes straight for your opponent.");
        return weapon1.getAttackPower() + getWisdom(); //Magic users have different special attacks
    }

    @Override
    public void flee() {
        super.flee();
    }

    @Override
    public int defense() {
        return super.defense();
    }

    @Override
    public void drinkPotion() {
        super.drinkPotion();
    }

    @Override
    public void looseFight() {
        super.looseFight();
    }

    @Override
    public void winFight() {
        super.winFight();
    }

}
