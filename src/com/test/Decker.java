package com.test;

public class Decker extends Player {

    static String cyberdeckDesc = "A cyberdeck is a powerful portable microcomputing device with enough computational power to render the ASIST interface of the Matrix as well as run illegal programs to subvert Matrix protocols.";

    public Decker(String name) {
        super(name, "Decker", 10, 5, 7, 20, 80);
        weapon1 = new Weapon("pistol", "ranged", "a metal pistol", 2, 1, 2);
        weapon2 = new Weapon("cyberdeck", "ranged",cyberdeckDesc, 3, 2, 1);
    }

    @Override
    public int attack() {
        System.out.println("You aim your pistol and shoot.");
        return super.attack();
    }

    @Override
    public int specialAttack() {
        System.out.println("You pull out your deck and order a couple of nearby policedrones to fire.");
        return super.specialAttack();
    }

}
