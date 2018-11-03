import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();

        CardPower cp = Enum.valueOf(CardPower.class,rank);
        CardSuit cs = Enum.valueOf(CardSuit.class,suit);

        System.out.printf("Card name: %s of %s; Card power: %d",cp.name(),cs.name(),cp.getPower()+cs.getPower());



    }
}
