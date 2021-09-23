package com.test;

public class Weapon {

    private String name;
    private String attackType; //is it a physical attack? magical? elemental? or a combination!
    private String description; //How does the weapon look?
    private int attackPower;  //how much damage can this weapon inflict?
    private int defensePower;  //how much damage can this weapon block?
    private int attackRate; //how quickly can the weapon be used to attack? Is it a small knife or giant two-handed hammer?

    public Weapon(String name, String attackType, String description, int attackPower, int defensePower, int attackRate) {
        this.name = name;
        this.attackType = attackType;
        this.description = description;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.attackRate = attackRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(int attackRate) {
        this.attackRate = attackRate;
    }
}
