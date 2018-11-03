package app.models.participants;

import app.contracts.Targetable;

import javax.print.DocFlavor;

import static app.models.Config.*;

public abstract class Character implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    protected Character(String name){
        this.name = name;
        this.isAlive = true;
    }

    protected Character(String name, double health, double damage, double gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.gold = gold;
        this.isAlive = true;
    }


    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + CHARACTER_CANNOT_ATTACK_MESSAGE;
        }

        if (!target.isAlive()){
            return target.getName() + CHARACTER_CANNOT_BE_ATTACKED_MESSAGE;
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + CHARACTER_ATTACKED_MESSAGE;
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(CHARACTER_HAS_BEEN_SLAIN_MESSAGE_FORMAT, target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        if(health<=0){
            this.isAlive = false;
        }
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    public abstract void levelUp();


    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
}
