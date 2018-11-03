package src.BaseClasses;

import src.Interfaces.Attacker;
import src.Interfaces.Observer;
import src.Interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHero implements Attacker,Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Target target;
    private Logger logger;
    private List<Observer> observers;
    private int reward;

    public AbstractHero(String id, int dmg,Logger logger,int reward) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
        this.reward = reward;
        observers = new ArrayList<>();
    }


    public void setTarget(Target target) {
        if (target == null) {
            System.out.println(TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            System.out.println(String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            System.out.println(String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            System.out.println(String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.reward);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
