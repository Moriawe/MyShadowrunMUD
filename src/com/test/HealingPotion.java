package com.test;

public class HealingPotion extends Potion {

    public HealingPotion() {
        super("Healing potion", "red", 10);
    }

    public void usePotion(Player player) {
        System.out.println("You feel a warm sensation in your throat that spreads through your body and heals it.");
        player.setHpNow(player.getHpNow() + getPotency());
    }

}
