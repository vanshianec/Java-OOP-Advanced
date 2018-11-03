package src;

import src.BaseClasses.Logger;
import src.Enums.LogType;
import src.Interfaces.Attacker;
import src.Interfaces.Command;
import src.Interfaces.Executor;
import src.Interfaces.Target;


public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();
        Logger errorLog = new ErrorLogger();

        combatLog.setSuccessor(errorLog);

        Attacker warrior = new Warrior("Warrior",10,combatLog);
        Target dragon = new Dragon("Dragon",100,25,combatLog);
        Executor executor = new CommandExecutor();
        Command target = new TargetCommand(warrior,dragon);
        Command attack = new AttackCommand(warrior);

    }
}
