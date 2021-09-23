package com.test;

public class StrengthPotion extends Potion {

    public StrengthPotion() {
        super("Strength potion", "blue", 2);
    }

    public void usePotion(Player player) {
        System.out.println("You feel the muscles in your body flex with new strength.");
        player.setStrength(player.getStrength() + getPotency());
    }

}
