package com.test;

public abstract class Entity {

    private String name; //Name of the player or creature
    private int level; //Level

    private int speed; //represents how fast the character moves. Determines frequency of attacks and chance to dodge incoming attacks.
    private int strength; //represents the character's physical strength. Determines amount of damage attacks inflict.
    private int wisdom; // represents how clever the character is. Determines power of spells and ability to resist magic attacks.

    private int magicPoints; //represents the amount of magical power a character has. Higher the power, the more spells can be cast.
    private int hitPoints; //represents the amount of damage a character can take before dying or being knocked out.
    private int gold; //represent the amount of gold the entity has and can loose/buy things for.

    protected Weapon weapon1;
    protected Weapon weapon2;


    private int hpNow; //Current amount of hitpoints.
    private int mpNow; //Current amount of magicpoints.

    public Entity(String name, int speed, int strength, int wisdom, int magicPoints, int hitPoints, int gold) {
        this.name = name;
        this.speed = speed;
        this.strength = strength;
        this.wisdom = wisdom;
        this.magicPoints = magicPoints;
        this.hitPoints = hitPoints;
        this.gold = gold;
        this.hpNow = hitPoints;
        this.mpNow = magicPoints;
        this.level = 1;
    }

    //Getters & Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getMP() {
        return magicPoints;
    }

    public void setMP(int mp) {
        this.magicPoints = mp;
    }

    public int getHP() {
        return hitPoints;
    }

    public void setHP(int hp) {
        this.hitPoints = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) { this.gold = gold; }

    public int getHpNow() {
        return hpNow;
    }

    public void setHpNow(int hpNow) {
        this.hpNow = hpNow;
    }

    public int getMpNow() {
        return mpNow;
    }

    public void setMpNow(int mpNow) {
        this.mpNow = mpNow;
    }

    public Weapon getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }
}
