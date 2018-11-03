package src;

import src.BaseClasses.Logger;
import src.Enums.LogType;
import src.Interfaces.*;


public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();
        Logger eventLogger = new EventLogger();

        combatLog.setSuccessor(eventLogger);

        AttackGroup group = new Group();

        group.addMember(new Warrior("Warrior",10,combatLog));
        group.addMember(new Warrior("ElderWarrior",13,combatLog));

        Target dragon = new Dragon("Dragon",100,25,combatLog);

        Executor executor = new CommandExecutor();

        Command groupTarget = new GroupTargetCommand(group,dragon);
        Command groupAttack = new GroupAttackCommand(group);
    }
}
