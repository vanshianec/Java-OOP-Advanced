package src;

import src.BaseClasses.AbstractHero;
import src.BaseClasses.Logger;
import src.Interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";


    public Warrior(String id, int dmg,Logger logger,int reward) {
        super(id, dmg, logger,reward);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        System.out.println(String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }



    @Override
    public void update(int value) {

    }
}
