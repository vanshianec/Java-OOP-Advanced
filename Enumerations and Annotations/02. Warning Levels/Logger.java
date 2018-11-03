import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importanceLevel;

    public Logger(String importanceLevel) {
        this.messages = new ArrayList<>();
        this.importanceLevel = Enum.valueOf(Importance.class,importanceLevel);
    }

    public void addMessage(String importance,String message){
        if(this.importanceLevel.compareTo(Enum.valueOf(Importance.class,importance.toUpperCase())) <= 0){
            messages.add(new Message(importance,message));
        }
    }

    public Iterable<Message> getMessages(){
        return messages;
    }
}
