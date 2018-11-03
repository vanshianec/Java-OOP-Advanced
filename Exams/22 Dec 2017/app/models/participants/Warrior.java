package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

import static app.models.Config.*;

public class Warrior extends AbstractHero {

    public Warrior(String name){
        super(name,WARRIOR_BASE_STRENGTH*HERO_HEALTH_MULTIPLIER,
                (WARRIOR_BASE_STRENGTH*WARRIOR_DAMAGE_MULTIPLIER)+WARRIOR_BASE_DEXTERITY,HERO_START_GOLD,
                WARRIOR_BASE_STRENGTH,WARRIOR_BASE_DEXTERITY,WARRIOR_BASE_INTELLIGENCE);
    }
    @Override
    public double getDamage(){
        return (this.getStrength() * 2) + this.getDexterity();
    }



}
