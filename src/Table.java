import java.util.ArrayList;
import java.util.Random;

public class Table {
    static Random random = new Random();
    public static Formatter formatter = new Formatter();
    public void dealCards(ArrayList<Card> tableDeck, Player player, Dealer dealer)  {
        if(tableDeck.isEmpty() || player == null || dealer == null ) {
            throw new IllegalArgumentException("One of parameters is invalid");
        }

       for (int i = 0; i<2; i++){
           player.addCard(dealCard(tableDeck));
           dealer.addCard(dealCard(tableDeck));
       }

       player.setScore(readCardPlayer(player.getHand()));
       dealer.setScore(calculateScore(dealer.getHand()));

       firstDealerRead(dealer.getHand());

    }
    private Card dealCard(ArrayList<Card> deck) {
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    private int readCardPlayer(ArrayList<Card> dealtCards) {
        System.out.println("You have ");
        int score = 0;
        for(Card card: dealtCards) {
            score += card.getValue();
            formatter.getCardInfo(card);
        }

        System.out.println("Your score is " + score);

        return score;
    }
    private void firstDealerRead(ArrayList<Card> dealerHand) {
        System.out.println("\nThe dealer is showing...");
        formatter.getCardInfo(dealerHand.get(0));
    }

    private int calculateScore(ArrayList<Card> cards) {
        int score = 0;
        for(Card card: cards) {
            score += card.getValue();
        }
        return score;
    }
    protected void playGame(int playerChoice, ArrayList<Card> deck, Player player, Dealer dealer ) {
        if (playerChoice == 1) {
            player.addCard(dealCard(deck));
            System.out.println("Your score is " + calculateScore(player.getHand()));
        } else if (playerChoice == 2) {
            System.out.println("Dealer score is: " + calculateScore(dealer.getHand()));
            dealer.addCard(dealCard(deck));
        }
    }
}
