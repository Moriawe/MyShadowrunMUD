package com.test;

public class Dog extends Opponent {

    public Dog(int gold) {
        super("Dog", 1, 18, 8, 2, 0, 10, gold);
        weapon1 = new Weapon("bite", "melee attack", "glimmering wet teeth", 2, 2,1);
        weapon2 = new Weapon("claw", "melee attack", "razorsharp claws", 1, 1, 0);
    }


    /* This is the dog's basic attack. It takes attackpower of the weapon teeth and adds the dogs strength. */
    @Override
    public int attack() {
        System.out.println("The dog growls threatening and tries to bite you.");
        return super.attack();
    }

    /* This is the dog's special attack where it attacks with it claws instead. */
    @Override
    public int specialAttack() {
        System.out.println("The dog barks furiously and tries to scratch you with it's claws.");
        return super.specialAttack();
    }

    @Override
    public int defense() {
        return super.defense();
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
