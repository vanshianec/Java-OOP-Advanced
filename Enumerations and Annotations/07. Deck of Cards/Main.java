import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardSuit [] suits = CardSuit.values();
        CardPower [] cardPowers = CardPower.values();

        for (CardSuit suit : suits) {
            for (CardPower cardPower : cardPowers) {
                System.out.printf("%s of %s%n",cardPower.name(),suit.name());
            }
        }

    }
}
