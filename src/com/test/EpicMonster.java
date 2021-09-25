package com.test;

public class EpicMonster extends Opponent {

    Weapon staff;

    public EpicMonster(int gold) {
        super("Cyborg troll", 5, 15, 20, 15, 100, 200, gold);
        weapon1 = new Weapon("Gattling gun", "ranged attack","Multibarrel deathmachine", 3, 3, 2);
        weapon2 = new Weapon("Razor axe", "melee", "razorsharp twohanded axe", 5, 4, 2);
    }

    @Override
    public int attack() {
        System.out.println("Six rotating barrels spew hot lead at you.");
        return super.attack();
    }

    @Override
    public int specialAttack() {
        System.out.println("With a roar the troll attacks you with his massive axe!");
        return super.specialAttack();
    }

    @Override
    public int defense() {
        return super.defense();
    }

}
