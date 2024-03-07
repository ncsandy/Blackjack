import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Dealer implements CardHolder {

    private final ArrayList<Card> hand;

    @Getter @Setter
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

}
