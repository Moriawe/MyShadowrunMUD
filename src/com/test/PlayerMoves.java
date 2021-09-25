package com.test;

public interface PlayerMoves {

    int attack();
    int specialAttack();
    int defense();

    void flee();

    void drinkPotion(String potion);

    void levelUp();


}
