package com.test;

public abstract class Potion {

    private String type;
    private String color;
    private int potency;


    public Potion(String type, String color, int potency) {
        this.type = type;
        this.color = color;
        this.potency = potency;
    }

    public abstract void usePotion(Player player);


    //Getters & Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }
}
