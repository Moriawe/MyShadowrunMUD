package com.test;

public class Thug extends Opponent {

    public Thug(int gold) {
        super("thug", 1, 10, 8, 5, 0, 10, gold);
        weapon1 = new Weapon("pistol", "ranged", "A smoth black pistol", 3, 1, 4);
        weapon2 = weapon1;
    }

    @Override
    public int attack() {
        System.out.println("The thug smacks you in the head with his gun");
        return super.attack();
    }

    @Override
    public int specialAttack() {
        System.out.println("The thug raises a gun and fires at you.");
        return super.specialAttack();
    }

}
