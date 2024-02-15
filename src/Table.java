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

       readCard(player.getHand());

        System.out.println("The dealer is showing + \n");
        readCardDealer(dealer.getHand());


    }
    private Card dealCard(ArrayList<Card> deck) {
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    private void readCard(ArrayList<Card> deltCards) {
        for(Card card: deltCards) {
            formatter.getCardInfo(card);
        }
    }
    private void readCardDealer(ArrayList<Card> dealerHand) {
        formatter.getCardInfo(dealerHand.get(0));
    }
}
