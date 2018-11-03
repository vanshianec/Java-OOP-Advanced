import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String category = "";
        String type = "";
        String description = "";
        switch(input){
            case "Rank":
                category = CardPower.class.getAnnotation(CustomAnnotation.class).category();
                type = CardPower.class.getAnnotation(CustomAnnotation.class).type();
                description = CardPower.class.getAnnotation(CustomAnnotation.class).description();
                break;
            case "Suit":
                category = CardSuit.class.getAnnotation(CustomAnnotation.class).category();
                type = CardSuit.class.getAnnotation(CustomAnnotation.class).type();
                description = CardSuit.class.getAnnotation(CustomAnnotation.class).description();
        }

        System.out.printf("Type = %s, Description = %s%n",type,description);

    }
}
