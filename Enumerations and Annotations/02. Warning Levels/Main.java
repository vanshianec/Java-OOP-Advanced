import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String importance = reader.readLine();
        Logger logger = new Logger(importance);
        String message = reader.readLine();
        while(!message.equals("END")){
            String[] tokens = message.split(": ");
            logger.addMessage(tokens[0],tokens[1]);
            message = reader.readLine();
        }

        Iterable<Message> messages= logger.getMessages();
        for (Message m : messages) {
            System.out.println(m);
        }






    }
}
