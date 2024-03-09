import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Dealer implements CardHolder {

    private final ArrayList<Card> hand;

    private int score;
    public Dealer() {
        this.hand = new ArrayList<>();
        this.score = 0;
    }
    @Override
    public void addCard(Card card) {
        this.hand.add(card);
    }

    @Override
    public void clearHand() {
        this.hand.clear();
    }

    @Override
    public int getScore() {
        int score = 0;
        for (Card card : this.hand) {
            if (card.isAce()) {
                card.setValue(11);
            }
            score += card.getValue();
        }
        this.score = score;
        return this.score;
    }

    @Override
    public void readHand(Formatter formatter) {
        System.out.println("Dealer has: ");
        for (Card card: this.hand) {
            formatter.getCardInfo(card);
        }
    }
    public void firstDealerRead(Formatter formatter) {
        System.out.println("\nThe dealer is showing...");
        formatter.getCardInfo(this.hand.get(0));
    }
}
