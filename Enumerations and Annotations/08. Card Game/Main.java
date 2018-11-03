import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardSuit [] suits = CardSuit.values();
        CardPower [] cardPowers = CardPower.values();
        List<String> deck = new ArrayList<>();
        for (CardSuit suit : suits) {
            for (CardPower cardPower : cardPowers) {
                deck.add(String.format("%s of %s%n",cardPower.name(),suit.name()));
            }
        }
        List<String> usedCards = new ArrayList<>();
        List<String> firstPlayerCards = new ArrayList<>();
        List<String> secondPlayerCards = new ArrayList<>();
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();
        int firstPlayerCardsCount = 0;
        int secondPlayerCardsCount = 0;
        while(firstPlayerCardsCount < 5){
            String card = reader.readLine();
            try{
                CardPower.valueOf(card.split(" ")[0]);
                CardSuit.valueOf(card.split(" ")[2]);
            }
            catch(Exception e){
                System.out.println("No such card exists.");
                continue;
            }
            if(usedCards.contains(card)){
                System.out.println("Card is not in the deck.");
                continue;
            }
            firstPlayerCards.add(card);
            usedCards.add(card);
            firstPlayerCardsCount++;
        }
        while(secondPlayerCardsCount < 5){
            String card = reader.readLine();
            try{
                CardPower.valueOf(card.split(" ")[0]);
                CardSuit.valueOf(card.split(" ")[2]);
            }
            catch(Exception e){
                System.out.println("No such card exists.");
                continue;
            }
            if(usedCards.contains(card)){
                System.out.println("Card is not in the deck.");
                continue;
            }
            secondPlayerCards.add(card);
            usedCards.add(card);
            secondPlayerCardsCount++;
        }
        String bestCard = "";
        String winner = "";
        int bestSum = 0;

        for (String firstPlayerCard : firstPlayerCards) {
            int sum = CardPower.valueOf(firstPlayerCard.split(" ")[0]).getPower()
                    + CardSuit.valueOf(firstPlayerCard.split(" ")[2]).getPower();
            if(sum > bestSum){
                bestSum = sum;
                winner = firstPlayerName;
                bestCard = firstPlayerCard;
            }
        }

        for (String  secondPlayerCard : secondPlayerCards) {
            int sum = CardPower.valueOf(secondPlayerCard.split(" ")[0]).getPower()
                    + CardSuit.valueOf(secondPlayerCard.split(" ")[2]).getPower();
            if(sum > bestSum){
                bestSum = sum;
                winner = secondPlayerName;
                bestCard = secondPlayerCard;
            }
        }

        System.out.printf("%s wins with %s.",winner,bestCard);


    }
}
