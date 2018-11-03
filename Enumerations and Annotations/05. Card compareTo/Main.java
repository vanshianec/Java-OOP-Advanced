import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();
        String rank2 = reader.readLine();
        String suit2 = reader.readLine();

        CardPower cp = Enum.valueOf(CardPower.class,rank);
        CardSuit cs = Enum.valueOf(CardSuit.class,suit);
        CardPower cp2 = Enum.valueOf(CardPower.class,rank2);
        CardSuit cs2 = Enum.valueOf(CardSuit.class,suit2);

        int firstCardPower = cp.getPower() + cs.getPower();
        int secondCardPower = cp2.getPower() + cs2.getPower();
        int power = 0;
        String name;
        String csName;
        if(Integer.compare(firstCardPower,secondCardPower)>=0){
             name = cp.name();
             csName = cs.name();
             power = firstCardPower;
        }else{
            name = cp2.name();
            csName = cs2.name();
            power = secondCardPower;
        }


        System.out.printf("Card name: %s of %s; Card power: %d",name,csName,power);



    }
}
