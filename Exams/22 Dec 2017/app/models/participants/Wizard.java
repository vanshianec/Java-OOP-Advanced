package app.models.participants;

import static app.models.Config.*;
import static app.models.Config.WARRIOR_BASE_INTELLIGENCE;

public class Wizard extends AbstractHero {
    public Wizard(String name) {
        super(name, WIZARD_BASE_STRENGTH * HERO_HEALTH_MULTIPLIER,
                (WIZARD_BASE_INTELLIGENCE * WIZARD_DAMAGE_MULTIPLIER) + WIZARD_BASE_DEXTERITY, HERO_START_GOLD,
                WIZARD_BASE_STRENGTH, WIZARD_BASE_DEXTERITY, WIZARD_BASE_INTELLIGENCE);
    }
    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

}
