package com.test;

public interface PlayerMoves {

    int attack();
    int specialAttack();
    int defense();

    void flee();
    void drinkPotion();

    void looseFight();
    void winFight();

    void lootGold();
    void goShop();

    void levelUp();


}
