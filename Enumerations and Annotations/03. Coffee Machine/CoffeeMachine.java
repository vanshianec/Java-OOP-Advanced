import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private int totalCoinsSum;
    List<Coffee> coffees;

    public CoffeeMachine() {
        this.totalCoinsSum = 0;
        coffees = new ArrayList<>();
    }

    public void buyCoffee(String size,String type){
        CoffeeSize coffeeSize = Enum.valueOf(CoffeeSize.class,size.toUpperCase());

        if(coffeeSize.getPrice() <= totalCoinsSum){
            coffees.add(new Coffee(type,size));
            totalCoinsSum = 0;
        }
    }

    public void insertCoin(String coin){
        Coin c = Enum.valueOf(Coin.class,coin.toUpperCase());
        totalCoinsSum += c.getValue();
    }

    public Iterable<Coffee> coffeesSold(){
        return coffees;
    }


}
