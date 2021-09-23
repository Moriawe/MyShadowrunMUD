package com.test;

public class WisdomPotion extends Potion {

    public WisdomPotion() {
        super("Wisdom potion", "black", 2);
    }

    public void usePotion(Player player) {
        System.out.println("The headache you get is almost making you kneel but as it releases it grips of you, you see the world in new colors.");
        player.setWisdom(player.getWisdom() + getPotency());
    }

}
