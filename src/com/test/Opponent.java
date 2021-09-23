package com.test;

public abstract class Opponent extends Entity implements OpponentMoves {

    public Opponent(String name, int lvl, int spe, int str, int wis, int mp, int hp, int gold) {
        super(name, spe, str, wis, mp, hp, gold);

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
        return (getWeapon2().getDefensePower() + getSpeed())/ 2;
    }

}
