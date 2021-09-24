package com.test;

public class Level {

    static final int lvl1 = 0;
    static final int lvl2 = lvl1 + 10;
    static final int lvl3 = lvl2 + 15;
    static final int lvl4 = lvl3 + 20;
    static final int lvl5 = lvl4 + 25;
    static final int lvl6 = lvl5 + 30;
    static final int lvl7 = lvl6 + 35;
    static final int lvl8 = lvl7 + 40;
    static final int lvl9 = lvl8 + 45;
    static final int lvl10 = lvl9 + 50;


    public static void checkLevel(Player player, int xp) {

        if (player.getLevel() == 1 && player.getXP() + xp >= lvl2) {
        player.levelUp();

        } else if (player.getLevel() == 2 && player.getXP() + xp >= lvl3) {
            player.levelUp();

        } else if (player.getLevel() == 3 && player.getXP() + xp >= lvl4) {
            player.levelUp();

        } else if (player.getLevel() == 4 && player.getXP() + xp >= lvl5) {
            player.levelUp();

        } else if (player.getLevel() == 5 && player.getXP() + xp >= lvl6) {
            player.levelUp();

        } else if (player.getLevel() == 6 && player.getXP() + xp >= lvl7) {
            player.levelUp();

        } else if (player.getLevel() == 7 && player.getXP() + xp >= lvl8) {
            player.levelUp();

        } else if (player.getLevel() == 8 && player.getXP() + xp >= lvl9) {
            player.levelUp();

        } else if (player.getLevel() == 9 && player.getXP() + xp >= lvl10) {
            player.levelUp();
        }

    }


}
