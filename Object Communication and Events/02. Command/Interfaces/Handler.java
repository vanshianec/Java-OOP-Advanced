package src.Interfaces;

import src.Enums.LogType;

public interface Handler {
    void handle(LogType logType, String message);
    void setSuccessor(Handler successor);

}
