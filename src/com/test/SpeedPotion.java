package com.test;

public class SpeedPotion extends Potion {

    public SpeedPotion() {
        super("Speed potion", "green", 2);
    }

    public void usePotion(Player player) {
        System.out.println("You can feel your adrenalinelevelse rise as the potion flows through your veins.");
        player.setSpeed(player.getSpeed() + getPotency());
    }


}
