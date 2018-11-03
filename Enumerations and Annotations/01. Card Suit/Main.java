import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardSuit[]suitList = CardSuit.values();
        String input = reader.readLine();
        System.out.println(input+":");
        for (CardSuit cardSuit : suitList) {
            System.out.println(cardSuit);
        }
    }
}
