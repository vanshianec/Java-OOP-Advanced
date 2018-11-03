package src;

import src.BaseClasses.Logger;
import src.Enums.LogType;

public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();
        Logger errorLog = new ErrorLogger();

        combatLog.setSuccessor(errorLog);

        combatLog.handle(LogType.ATTACK,"some attack");
        combatLog.handle(LogType.ERROR,"some error");
        combatLog.handle(LogType.EVENT,"some event");
    }
}
