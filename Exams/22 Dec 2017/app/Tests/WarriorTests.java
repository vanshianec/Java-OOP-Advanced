package app.Tests;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.AbstractHero;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import app.models.participants.Character;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WarriorTests {
    private static double TEN_DAMAGE = 10;
    private static double STARTING_HEALTH = 20;
    private static double ZERO_HEALTH = 0;
    private static double POSITIVE_HEALTH = 10;
    private static int CURRENT_LEVEL = 3;
    private static int EXPECTED_LEVEL = 4;
    private static int STATS_MULTIPLIER = 2;
    private static double TEN_GOLD = 10;
    private static double ZERO_GOLD  = 0;
    private static double EXPECTED_TARGET_GOLD = 400;
    private static String RANDOM_NAME_FOR_INITIALIZATION = "Random";
    private AbstractHero warrior;

    @Before
    public void createWarrior() {
        warrior = new Warrior(RANDOM_NAME_FOR_INITIALIZATION);
    }

    @Test
    public void checkIfWarriorReceivesDamage() {
        warrior.setHealth(STARTING_HEALTH);
        warrior.takeDamage(TEN_DAMAGE);
        Assert.assertEquals(warrior.getHealth(), STARTING_HEALTH - TEN_DAMAGE, 0);

    }

    @Test
    public void checkIfWarriorIsAlive() {
        warrior.setHealth(POSITIVE_HEALTH);
        boolean expectedWarriorStatement = warrior.isAlive();
        Assert.assertEquals(expectedWarriorStatement, warrior.getHealth() > ZERO_HEALTH);
    }

    @Test
    public void increaseLevelIncreaseHealthAndDoubleStatsChecker() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class warriorClass = Warrior.class;
        Constructor constructor = warriorClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Warrior refClass = (Warrior) constructor.newInstance(RANDOM_NAME_FOR_INITIALIZATION);
        Field levelField = warriorClass.getSuperclass().getDeclaredField("level");
        levelField.setAccessible(true);
        levelField.set(refClass, CURRENT_LEVEL);
        Method method = warriorClass.getSuperclass().getDeclaredMethod("levelUp");
        method.setAccessible(true);
        method.invoke(refClass, null);
        Assert.assertEquals(EXPECTED_LEVEL, levelField.get(refClass));
        int currentDexterity = warrior.getDexterity();
        int currentIntelligence = warrior.getIntelligence();
        int currentStrength = warrior.getStrength();
        //health is calculated by the formula (Strength * 10)
        warrior.setHealth(STARTING_HEALTH);
        warrior.takeDamage(TEN_DAMAGE);
        warrior.levelUp();
        Assert.assertEquals(currentDexterity * STATS_MULTIPLIER, warrior.getDexterity());
        Assert.assertEquals(currentIntelligence * STATS_MULTIPLIER, warrior.getIntelligence());
        Assert.assertEquals(currentStrength * STATS_MULTIPLIER, warrior.getStrength());
        Assert.assertEquals(warrior.getStrength() * Config.HERO_HEALTH_MULTIPLIER, warrior.getHealth(), 0);
    }

    @Test
    public void seeIfRewardIsReceived() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class warriorClass = Warrior.class;
        Constructor constructor = warriorClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Warrior refWarrior = (Warrior) constructor.newInstance(RANDOM_NAME_FOR_INITIALIZATION);
        Field gold = warriorClass.getSuperclass().getSuperclass().getDeclaredField("gold");
        gold.setAccessible(true);
        gold.set(refWarrior, 0);
        Method receiveReward = warriorClass.getSuperclass().getSuperclass().getMethod("receiveReward", Double.TYPE);
        receiveReward.invoke(refWarrior, TEN_GOLD);
        Assert.assertEquals((double) gold.get(refWarrior), TEN_GOLD, 0);

    }

    @Test
    public void seeIfRewardIsGiven() {
        Targetable hero = new Warrior("TestTarget");
        //warriors base gold is 200;
        double gold = warrior.getGold();
        //check if it's not less than 0
        Assert.assertTrue(gold > 0);
        warrior.giveReward(hero);
        //hero should have 400 gold now
        Assert.assertEquals(ZERO_GOLD,warrior.getGold(),0);
        Assert.assertEquals(EXPECTED_TARGET_GOLD,hero.getGold(),0);
    }


}
