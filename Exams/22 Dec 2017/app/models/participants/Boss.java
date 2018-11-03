package app.models.participants;

import app.contracts.Targetable;

import static app.models.Config.*;

public class Boss extends Character {


    public Boss(String name) {
        super(name, BOSS_HEALTH, BOSS_DAMAGE, BOSS_GOLD);
    }

    @Override
    public void receiveReward(double reward) {
        super.receiveReward(reward*0.1);
    }

    @Override
    public void levelUp() {
        this.setHealth(BOSS_HEALTH);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: Boss", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f | Gold: %.2f",
                        this.getHealth(), this.getDamage(),this.getGold()));
        return sb.toString();
    }


}
