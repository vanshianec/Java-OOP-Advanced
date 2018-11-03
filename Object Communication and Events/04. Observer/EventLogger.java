package src;

import src.BaseClasses.Logger;
import src.Enums.LogType;

public class EventLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if(LogType.EVENT == type){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
