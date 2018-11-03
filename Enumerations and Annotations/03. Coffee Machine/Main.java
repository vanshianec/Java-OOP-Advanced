import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine machine = new CoffeeMachine();
        String command = reader.readLine();
        while(!command.equals("END")){
            if(command.split(" ").length == 1){
                machine.insertCoin(command);
            }
            else{
                machine.buyCoffee(command.split(" ")[0],command.split(" ")[1]);
            }
            command = reader.readLine();
        }
        Iterable<Coffee> coffees = machine.coffeesSold();
        for (Coffee coffee : coffees) {
            System.out.print(coffee);
        }





    }
}
