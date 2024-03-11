import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Player implements CardHolder {

    @Getter @Setter
    private String name;

    @Setter
    private int money;

    @Getter @Setter
    private ArrayList<Card> hand;

    private int score;

    Player(String name) {
        this.name = name;
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
        int numOfAces = 0;
        for (Card card : this.hand) {
            score += card.getValue();
            if (card.isAce()) {
                numOfAces++;
            }
            if (score > 21 && numOfAces > 0) {
                numOfAces -= 1;
                score -= 10;
            }
        }

        this.score = score;
        return this.score;
    }
    @Override
    public void readHand(Formatter formatter) {
        System.out.println(this.getName() + " has ");
        for (Card card: this.hand) {
            formatter.getCardInfo(card);
        }
    }
}