package com.test;

public class StreetSamurai extends Player {

    public StreetSamurai(String name) {
        super(name, "Street Samurai",7, 10, 5, 0, 120);
        weapon1 = new Weapon("fist", "melee", "a bone iron decorates your fist", 2, 2, 0);
        weapon2 = new Weapon("katana", "melee", "it's slim, it's beautiful and it's retractable", 2, 2, 0);
    }

    @Override
    public int attack() {
        System.out.println("You give it a straight right!");
        return super.attack();
    }

    @Override
    public int specialAttack() {
        System.out.println("You draw you katana and chop at it. ");
        return super.specialAttack();
    }

}
