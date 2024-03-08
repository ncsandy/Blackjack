import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Dealer implements CardHolder {

    private final ArrayList<Card> hand;

    @Setter
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
    public int getScore(ArrayList<Card> hand) {
        for (Card card : hand) {
            if (card.isAce()) {
                card.setValue(11);
            }
            this.score += card.getValue();
        }
        return this.score;
    }

    @Override
    public void readHand() {

    }
}
