package com.test;

public interface OpponentMoves {

    int attack();
    int specialAttack();
    int defense();

    void flee();
    void heal();

    void looseFight();
    void winFight();

}
