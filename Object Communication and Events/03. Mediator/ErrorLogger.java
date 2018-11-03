package src;

import src.BaseClasses.Logger;
import src.Enums.LogType;

public class ErrorLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if(type == LogType.ERROR){
            System.out.println(type.name()+": "+message);
        }
        super.passToSuccessor(type,message);
    }
}
