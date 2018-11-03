package app.models;

public final class Config {

    public static final int HERO_HEALTH_MULTIPLIER = 10;
    public static final int LEVEL_UP_MULTIPLIER = 2;

    public static final int WIZARD_BASE_STRENGTH = 3;
    public static final int WIZARD_BASE_DEXTERITY= 3;
    public static final int WIZARD_BASE_INTELLIGENCE = 4;

    public static final int WARRIOR_BASE_STRENGTH = 5;
    public static final int WARRIOR_BASE_DEXTERITY= 4;
    public static final int WARRIOR_BASE_INTELLIGENCE = 1;

    public static final int NECROMANCER_BASE_STRENGTH = 4;
    public static final int NECROMANCER_BASE_DEXTERITY = 3;
    public static final int NECROMANCER_BASE_INTELLIGENCE = 3;

    public static final double HERO_START_GOLD = 200.0;
    
    public static final double BOSS_GOLD = 100;
    public static final double BOSS_HEALTH = 500;
    public static final double BOSS_DAMAGE = 5;
    public static final double BOSS_INDIVIDUAL_REWARD = 50;

    public static final int WIZARD_DAMAGE_MULTIPLIER = 5;
    public static final int WARRIOR_DAMAGE_MULTIPLIER = 2;
    public static final int NECROMANCER_DAMAGE_MULTIPLIER = 2;

    public static final String CHARACTER_CANNOT_ATTACK_MESSAGE =" is dead! Cannot attack.";
    public static final String CHARACTER_CANNOT_BE_ATTACKED_MESSAGE =" is dead! Cannot be attacked.";
    public static final String CHARACTER_ATTACKED_MESSAGE =" attacked!";
    public static final String CHARACTER_HAS_BEEN_SLAIN_MESSAGE_FORMAT =" %s has been slain by %s.";

    public static final String BOSS_FIGHT_INVALID_BOSS_MESSAGE = "Invalid boss.";
    public static final String BOSS_FIGHT_NOT_ENOUGH_PARTICIPANTS_MESSAGE = "There should be at least 1 participant for boss fight!";
    public static final String BOSS_FIGHT_BOSS_HAS_BEEN_SLAIN_MESSAGE = "Boss has been slain by: ";
    public static final String BOSS_FIGHT_BOSS_WIN_MESSAGE = "Boss has slain them all!";

    public static final String ONE_VS_ONE_INVALID_PARTICIPANTS_COUNT_MESSAGE =  "There should be exactly 2 participants for OneVsOne!";
    public static final String ONE_VS_ONE_HERO_IS_VICTORIOUS_MESSAGE_FORMAT= "%s is victorious!%s%s";
}
