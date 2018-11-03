package app.models.participants;

import static app.models.Config.*;

public class Necromancer extends  AbstractHero {

    public Necromancer(String name) {
        super(name, NECROMANCER_BASE_STRENGTH * HERO_HEALTH_MULTIPLIER,
                NECROMANCER_DAMAGE_MULTIPLIER *(NECROMANCER_BASE_STRENGTH  + NECROMANCER_BASE_DEXTERITY + NECROMANCER_BASE_INTELLIGENCE),
                 HERO_START_GOLD,  NECROMANCER_BASE_STRENGTH, NECROMANCER_BASE_DEXTERITY, NECROMANCER_BASE_INTELLIGENCE);
    }
    @Override
    public double getDamage() {
        return (this.getIntelligence() * 2) + (this.getDexterity() * 2) + (this.getStrength() * 2);
    }
}